package ru.yanes.algorithms.sorting;

import java.util.Arrays;

public class Bubble {
	public static void main(String[] args) {
		int[] arr = {1,4,10,8,12,3,2,6,11,5,7,9};

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}
}
