package ru.yanes.IOstreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;


public class IO {
	public static void main(String[] args) throws IOException {
		//Decorator pattern
		FileInputStream fis = new FileInputStream("data.txt"); // Raw bytes from file
		BufferedInputStream bis = new BufferedInputStream(fis); // Adds a buffer (faster!)
		DataInputStream dis = new DataInputStream(bis); // Allows reading ints, doubles, etc.

		if (dis.available() > 0) {
			String str = dis.readLine(); //deprecated
			System.out.println(str);
		} else  {
			dis.close();
			System.out.println("empty");
		}

		//Modern way
		String content = Files.readString(Path.of("./data.txt"));
		System.out.println(content);

		Files.write(Path.of("./output.txt"), Stream.of(content)
				.flatMap(str -> Arrays.stream(str.split("\\s")))
				.filter(str -> str.length() > 3)
				.toList());
	}

	class User implements Serializable {
		private String name;
	}
}
