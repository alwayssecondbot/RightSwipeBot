package ru.yanes;

import java.util.Arrays;
import java.util.HashMap;

public class ArraysAndMaps {

    private static final int[][] triangle = new int[3][];
    public static void main(String[] args) {
        triangle[0] = new int[] {0};
        triangle[1] = new int[] {1,2};
        triangle[2] = new int[] {3,4,5};
        int counter = 0;
        for (int i = 0; i<triangle.length; i++) {
            triangle[i] = new int[i+1];
            for (int j=0; j<triangle[i].length; j++){
                triangle[i][j] = counter++;
            }
        }
        System.out.println(Arrays.deepToString(triangle));
        int[] angle = new int[] {1,2,3,4,5,6,7,8,9,0};
        System.arraycopy(angle, 4, angle,3,6);
        System.out.println(Arrays.toString(angle));
        int[] sortedNumbers = {10, 20, 30, 40, 50, 60, 70, 80};
        int index = Arrays.binarySearch(sortedNumbers, 25);
        System.out.println(index);

        HashMap<String, String> map = new HashMap<>();
        map.put("123-1-23-4", "Atlantis");
        map.put("124-5-67-8", "Gook");
        map.put("978-5-04-1", "Bob");
        System.out.println(map.getOrDefault("978-5-04-1", "Книга не найдена"));

    }
}
