package ru.yanes;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class RightSwipeBot{
    public static void main(String[] args){
        fixSystemOutEncoding();
//        System.out.print("Set car's weight, height and width: ");
//        short[] bodyChars = new short[3];
//        for (int i = 0; i < 3; i++){
//            bodyChars[i]=in.nextShort();
//        }
//        in.close();

        try (Scanner scanner = new Scanner(System.in)){
                Postgres postgres = new Postgres();

            System.out.print("Select action: 1 - create, 2 - drop: ");
            short answer = scanner.nextShort();
            switch (answer) {
                case 1 -> {
                    postgres.initiateDB();
                    postgres.populateDB();
                }
                case 2 -> postgres.dropDB();
                default -> throw new IllegalArgumentException("Variant '" + answer +"' doesn't exist");

            }
        }
    }

    private static void fixSystemOutEncoding() {
        System.setOut(new java.io.PrintStream(System.out, true, StandardCharsets.UTF_8));
        System.setErr(new java.io.PrintStream(System.err, true, StandardCharsets.UTF_8));
    }
}