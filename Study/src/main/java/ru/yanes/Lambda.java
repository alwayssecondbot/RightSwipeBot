package ru.yanes;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Lambda {
    public static void main(String[] args) {
        Random rand = new Random();
        Addable<Integer> a = s -> s>10?s:10;
        Removable<Integer> r = s -> s<11;
        List<Integer> list = new ArrayList<>();

        Supplier<String> supp = () -> new String();
        String o = supp.get();
        o = "query";
        toUpper().accept(o);
        System.out.println(o);

        for (int i : rand.ints(10, 1, 18).toArray()) {
             list.add(a.test(i));
        }

        System.out.println(Arrays.toString(list.toArray()));

        list.removeIf(r::test);
        System.out.println(Arrays.toString(list.toArray()));

        list.removeIf(s -> s>16);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(j);
    }

    public static Consumer<String> toUpper(){
        return s -> s.toUpperCase();
    }
}

interface Addable<T> {
    T test(T t);
}

interface Removable<T> {
    boolean test(T t);
}

interface MultiplyByTwo<T> {
    T multiplyByTwo(Function t);
}