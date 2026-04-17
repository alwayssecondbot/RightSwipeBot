package ru.yanes.algorithms.sorting;

import java.util.Arrays;

public class Selection {
	public static void main(String[] args) {
		int[] arr = {1,4,10,8,12,3,2,6,11,5,7,9};

		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && key < arr[j]) {
				arr[j + 1] = arr[j]; // shift right
				j--;
				System.out.println(Arrays.toString(arr));
			}

			arr[j + 1] = key; // insert
		}

		System.out.println(Arrays.toString(arr));
	}
}
