package ru.yanes.Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDetection {
	public static void main(String[] args) throws IOException {
		Path rootpath = Paths.get(System.getProperty("user.dir"));
		System.out.println("Root directory: " + rootpath);

		try (Stream<Path> paths = Files.walk(rootpath)) {
			long fileSize = paths.filter(file -> file.getFileName().toString().endsWith(".log"))
					.mapToLong(file -> {
						try {
//						System.out.println(file);
							return Files.size(file);
						} catch (IOException e) {
							return 0;
						}
					}).sum();

			System.out.println("file size: " + fileSize);
		}
	}
}
