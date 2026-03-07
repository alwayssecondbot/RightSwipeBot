package ru.yanes;

import java.util.*;
import java.util.function.*;

public class Lambda {
    public static void main(String[] args) {
        Random rand = new Random();
        Addable<Integer> add = s -> s>10?s:10;
        Removable<Integer> remove = s -> s<11;
        List<Integer> list = new ArrayList<>();

        Supplier<String> supp = () -> new String();
        String o = supp.get();
        o = "query";
        o = toUpper().apply(o);
        System.out.println(o);


        Function<String, Integer> f = i -> i.length();
        Function<Integer, String> g = i -> "Hello: "+i;

        String h = f.andThen(g).apply("world");
        System.out.println(h);


        for (int i : rand.ints(10, 1, 18).toArray()) {
            if (add.andThen(remove).test(i)) {
                list.add(i);
            }
        }
        System.out.println(Arrays.toString(list.toArray()));

//        list.removeIf(remove::test);
//        System.out.println(Arrays.toString(list.toArray()));

        list.removeIf(s -> s>16);
        System.out.println(Arrays.toString(list.toArray()));
        int x = list.get(0);
//        int x=1;
//        System.out.println(j);
        switch(x){
            case 1:
                System.out.print("Arg equal 1");
                break;
            case 2:
                System.out.print("Arg equal 2");
                int arg = 23;
                break;
            case 23:
                System.out.print("Arg equal 23");
                break;
            default:
                var arg1 = "default";
                System.out.print("Arg has default value");
                break;
        }

        switch(x){
            case 1 -> System.out.print("Arg equal 1");
            case 2 -> System.out.print("Arg equal 2");
            case 23 -> System.out.print("Arg equal 23");
            default -> System.out.print("Arg has default value");
        }

        UnaryOperator<Integer> sqrt = s -> s*s;
        int l = sqrt.apply(2); // 4
        System.out.println(l);

        List<String> planets = Arrays.asList("Mars", "Venus", "Jupiter", "Saturn");
        Predicate<String> longEnough = s -> s.length() <= 5;
        Function<String,String> toUpper = String::toUpperCase;
        Consumer<String> printSt = System.out::println;

        planets.forEach(s-> {
            if (longEnough.test(s)) {
                printSt.accept(toUpper.apply(s));
            }
        });
    }

    public static UnaryOperator<String> toUpper(){
        return String::toUpperCase;
    }

    public Predicate<String> getPasswordValidator(int minLength) {
        int minlength = minLength + 1;
        return s -> s.length() > minlength;
    }

    void checkSecurity(String password){
        int attempts = 0;

        Predicate<String> validator = input -> {
            System.out.println("Попытка №" + attempts);
            return input.equals(password);
        };

//        attempts++; // Увеличиваем счетчик после создания лямбды

        if (validator.test("1234")) {
            System.out.println("Доступ разрешен");
        }
    }
}

interface Addable<T> {
    T test(T t);

    default <V> Removable<T> andThen(Removable<T> after) {
        Objects.requireNonNull(after);
        return (t) -> after.test(test(t));
    };
}

interface Removable<T> {
    boolean test(T t);
}

