package ru.yanes;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Test {
    public static void main(String[] args){
//        List<Integer> a = List.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
//        int b=10;
//        String c = "str";
//        Integer d = 10;
//
//       List<Integer> g = a.stream()
//               .filter(j-> j > 3)
//               .sorted()
//               .toList();
//       System.out.println(g.toString());

        int[][] a = {
                {1,3,4,5},
                {11,23,51,1000},
                {1,23,45612,1},
                {1,1,1,1}
        };
        String[][] shelves = {
                {"A1", "B2", "C3", "G6"},
                {"D4", "E5", "D4"},
                {"B2", "F6", "G6"}
        };
//        List<List<Integer>> a = new java.util.ArrayList<>(List.of());
//        a.add(List.of(new Integer[]{1,3,4,5}));
//        a.add(List.of(new Integer[]{11,23,51,1000}));
//        a.add(List.of(new Integer[]{1,23,45612,1}));
//        a.add(List.of(new Integer[]{1,1,1,1}));
        IntStream.range(0, a.length)
                .boxed()
                .flatMap(i -> IntStream.range(0,a[i].length)
                        .filter(j->a[i][j]>100)
                        .mapToObj(j -> "Row - "+i+", Column: "+j))
                .findFirst()
                .ifPresent(System.out::println);
        boolean clear=true;
        point:
        for (int i=0; i<shelves.length;i++){
            for (String id:shelves[i]){
                for (int k=i+1; k<shelves.length;k++){
                    for (String id1:shelves[k]){
                        if (Objects.equals(id, id1)){
                            System.out.printf("Дубликат найден: ID '%s' на стеллажах '%d' и '%d'\n", id, i, k);
                            clear=false;
                            break point;
                        }
                    }
                }
            }
        }
        if (clear){
            System.out.println("Всё чисто");
        }
//        IntStream.range(0, shelves.length)
//                .boxed()
//                .flatMap(i-> IntStream.range(0,shelves[i].length)
//                        .forEach(IntStream.range(i+1, shelves.length)
//                                        .boxed()
//                                        .flatMap(j-> IntStream.range(0,shelves[i+1].length)
//                                                .filter(d-> shelves[i][c] == shelves[i + 1][d]))
//                                        .findFirst()))

        IntStream.range(0, shelves.length)
                .boxed()
                .flatMap(i -> Arrays.stream(shelves[i])
                        .map(id -> new AbstractMap.SimpleEntry<>(id, i))) // Пара: "A1", 0
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey)) // Группируем по ID
                .entrySet().stream()
                .filter(entry -> entry.getValue().stream()
                        .map(AbstractMap.SimpleEntry::getValue)
                        .distinct().count() > 1) // Оставляем только те ID, что на разных стеллажах
                .findFirst()
                .ifPresent(result -> {
                    String id = result.getKey();
                    List<Integer> sIndices = result.getValue().stream()
                            .map(AbstractMap.SimpleEntry::getValue).distinct().toList();
                    System.out.printf("Дубликат найден: ID '%s' на стеллажах %s", id, sIndices);
                });
    }

    static void printTrue(String s){
        System.out.println(s + " is True");
    }

    static void printFalse(String s){
        System.out.println(s + " is False");
    }
}
