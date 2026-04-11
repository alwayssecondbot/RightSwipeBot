package ru.yanes.algorithms.sorting;

import java.util.*;

public class Merge {
	public static void main(String[] args) {
		int[] arr = {1,4,10,8,12,3,2,6,11,5,7,9};

		int[] arr1 = {1};
		int[] arr2 = {2};


		MergeSort.mergeSort(arr);
		System.out.println(Arrays.toString(arr));

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(23);
		list.add(3);
		sortList(list);
		System.out.println(list);
	}

	static void sortList(List<Integer> list) {
		list.sort(Comparator.comparing(Integer::intValue));
	}
}

class MergeSort {
	static void mergeSort(int[] arr) {
		if (arr.length < 2) return;

//		System.out.printf("Array: %s\n", Arrays.toString(arr));
		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];

		System.arraycopy(arr, 0, left, 0, mid);
		System.arraycopy(arr, mid, right, 0, arr.length - mid);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, arr);


	}

	static void merge(int[] left, int[] right, int[] arr) {
		int i = 0, j = 0, k = 0;

//		System.out.printf("Left: %s.  ", Arrays.toString(left));
//		System.out.printf("Right: %s\n", Arrays.toString(right));

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arr[k++] = left[i++];
			} else {
				arr[k++] = right[j++];
			}
		}

		while (i < left.length) {
			arr[k++] = left[i++];
		}

		while (j < right.length) {
			arr[k++] = right[j++];
		}
	}
}