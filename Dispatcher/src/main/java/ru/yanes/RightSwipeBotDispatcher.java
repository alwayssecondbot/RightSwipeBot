package ru.yanes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class RightSwipeBotDispatcher {
    public static void main(String[] args){
        fixSystemOutEncoding();
        SpringApplication.run(RightSwipeBotDispatcher.class, args);
    }

    private static void fixSystemOutEncoding() {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}
