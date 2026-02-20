package ru.yanes;

import java.util.Arrays;

public class Strings {
    public static void main (String[] args) {
        String a = "noof";
        String b = new String("noof");
        int[] c = {1,2,3,4};
        int[] d = {1,2,3,4};
        int[] e = new int[] {1,2,3,4};
        int[] f = Arrays.copyOf(e,4);
        int[] g = c;

        if (a==b) {
            System.out.println("a = b");
        } else {
            System.out.println("a != b");
        }

        if (c==d) {
            System.out.println("c=d");
        } else {
            System.out.println("c!=d");
        }
        System.out.println(c);
        System.out.println(d);

        if (Arrays.equals(e,f)) {
            System.out.println("e=f");
        } else {
            System.out.println("e!=f");
        }
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(f));

        if (g==c) {
            System.out.println("g=c");
            c[0] = 10;
            System.out.println(Arrays.toString(g));
        }
        String[] authors = {"King", "Rowling", "Tolkien"};
        StringBuilder s = new StringBuilder("Авторы: ");
        for (String author:authors) {
            s.append(" ");
            s.append(author);
            s.append(";");
        }
    }
}
