package com.edu.arrays.examples;

public class ZeroesToTheEnd {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 0, 3, 0, 4, 0 };
		int n = arr.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while (count < n) {
			arr[count++] = 0;
		}

		System.out.println("Array after moving zeroes: " + java.util.Arrays.toString(arr));
	}
}
