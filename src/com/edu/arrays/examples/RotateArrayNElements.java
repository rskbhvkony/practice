package com.edu.arrays.examples;

public class RotateArrayNElements {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int n = 2; // Number of positions to rotate
		reverseArray(arr, 0, n - 1);
		reverseArray(arr, n, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);

		System.out.println("Rotated array: " + java.util.Arrays.toString(arr));
	}

	static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}