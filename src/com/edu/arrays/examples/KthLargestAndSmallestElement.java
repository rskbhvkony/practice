package com.edu.arrays.examples;

public class KthLargestAndSmallestElement {
	public static void main(String[] args) {
		int[] arr = { 7, 5, 9, 3, 2, 8, 1, 6 };
		int k = 5;
		java.util.Arrays.sort(arr);
		System.out.println(k + "th largest element: " + arr[arr.length - k]);
		System.out.println(k + "th smallest element: " + arr[k - 1]);
	}
}
