package com.array.examples;

public class KthLargestAndSmallestNumber {
	public static void main(String[] args) {
		int k = 3;
		int[] a = { 5, 7, 9, 13, 7 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			if (i == k - 1) {
				System.out.println(k + " Larget number is " + a[i]);
				break;
			}
		}
	}

}
