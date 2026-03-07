package ru.yanes;

import java.util.function.UnaryOperator;

public class LinksToMethods {
    public static void main(String[] args) {
        String s = "qwerty";
        UnaryOperator<String> add = s::concat;
        String d = " berry ";
        String e = " gerry ";
        System.out.println(add.apply(d).trim());
    }
}
