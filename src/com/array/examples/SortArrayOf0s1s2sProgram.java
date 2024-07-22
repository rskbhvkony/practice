package com.array.examples;

import java.util.Arrays;

public class SortArrayOf0s1s2sProgram {
	private static void sortArray(int[] inputArray) {
		System.out.println("Array Before Sorting : " + Arrays.toString(inputArray));

		// Initializing low and mid to 0

		int low = 0;

		int mid = 0;

		// and high to last index

		int high = inputArray.length - 1;

		// Until mid doesn't cross high

		while (mid <= high) {
			// If an element is 0, bring it to the beginning

			if (inputArray[mid] == 0) {
				swap(inputArray, low, mid);
				low++;
				mid++;
			}

			// If an element is 2, send it to the end

			else if (inputArray[mid] == 2) {
				swap(inputArray, mid, high);
				high--;
			}

			// If an element is 1, let it be there only

			else {
				mid++;
			}
		}

		System.out.println("Array After Sorting : " + Arrays.toString(inputArray));
	}

	// Utility method for swapping

	private static void swap(int[] inputArray, int i, int j) {
		int temp = inputArray[i];
		inputArray[i] = inputArray[j];
		inputArray[j] = temp;
	}

	public static void main(String[] args) {
		sortArray(new int[] { 1, 0, 2, 2, 0, 2, 1, 2, 1, 1, 2, 0 });

		System.out.println("=====================================");

		sortArray(new int[] { 1, 2, 0, 2, 0, 1, 0, 2, 1, 0, 0, 2 });

		System.out.println("=====================================");

		sortArray(new int[] { 2, 1, 0, 0, 1, 2, 2, 0, 1, 0, 2, 1 });

		System.out.println("=====================================");
	}
}
