package ru.yanes.Tasks;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LogSniffer {
//	private static final Pattern LOG_PATTERN = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2}\\s+\\|\\s+[A-Z-]+?-SERVICE\\s+\\|" + "\\s+(ERROR|INFO|WARN|DEBUG)\\s\\|" + "\\s.+\\s\\|" + "\\s\\d+$");
	private static final Pattern LOG_PATTERN = Pattern.compile("(?<time>.*?) \\| (?<service>.*?) \\| (?<level>.*?) \\| (?<msg>.*?) \\| (?<rt>\\d+)");
	public record LogRecord(String serviceName, String level, String msg, Double time) {}

	public static void main(String[] args) {
		List<String> rawLogs = Arrays.asList("2026-03-07 12:00:01 | PAYMENT-SERVICE | ERROR | Connection timeout | 500",
				"2026-03-07 12:00:05 | ORDER-SERVICE | INFO | Order created | 120",
				"2026-03-07 12:00:05 | ORDER-SERVICE | INFO | Order created | 120",
				"2026-03-07 12:00:05 | PAYMENT-ORDER-SERVICE | WARN | Order created | 1200",
				"2026-03-07 12:00:05 | PAYMENT-ORDER-SERVICE | WARN | Order created | 900",
				"CORRUPTED_LINE_123",
				"2026-03-07 12:00:10 | PAYMENT-SERVICE | WARN | Slow response | 1500");

		Map<String, Double> analysedLogs = rawLogs.parallelStream()
				.flatMap(line -> parseLog(line).stream())
				.filter(record -> record.serviceName().startsWith("PAYMENT"))
				.filter(record -> record.level().equals("ERROR") || record.level().equals("WARN"))
				.collect(Collectors.groupingBy(
						LogRecord::serviceName,
						Collectors.averagingDouble(LogRecord::time))
				);

		System.out.println(analysedLogs);

	}

	static Optional<LogRecord> parseLog(String line) {
		Matcher matcher = LOG_PATTERN.matcher(line);
		if (matcher.matches()) {

//			Level lvl = switch (match) {
//				case "ERROR" -> Level.SEVERE;
//				case "INFO" -> Level.INFO;
//				case "WARN" -> Level.WARNING;
//				case "DEBUG" -> Level.CONFIG;
//				default -> throw new IllegalStateException("Unexpected value: " + match);
//			};
			return Optional.of(new LogRecord(
					matcher.group("service"),
					matcher.group("level"),
					line,
					Double.parseDouble(matcher.group("rt"))
			));
		}
		return Optional.empty();
	}

//	static String findPattern(String line, Pattern pattern) {
//		Matcher matcher = pattern.matcher(line);
//		matcher.find();
//		return matcher.group();
//	}
}