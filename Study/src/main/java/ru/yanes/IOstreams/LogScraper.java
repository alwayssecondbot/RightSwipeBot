package ru.yanes.IOstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class LogScraper {
	public static void main(String[] args) throws IOException {

		try (BufferedReader reader = Files.newBufferedReader(Path.of("./logs/postgres.log"));
		     BufferedWriter writer = Files.newBufferedWriter(Path.of("./errors.txt"))) {

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("ERROR")) {
					writer.write(line);
					writer.newLine();
				}
			}
		}



//		Path source = Path.of("./logs/postgres.log");
//		Path target = Path.of("./logs/errors.txt");
//
//		try (Stream<String> stream = Files.lines(source, Charset.defaultCharset())) {
//			List<String> errors = stream
//					.filter(line -> line.contains("ERROR"))
//					.toList();
//			Files.write(target, errors);
//		}
	}
}