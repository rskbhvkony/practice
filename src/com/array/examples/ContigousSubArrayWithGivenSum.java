package com.array.examples;

import java.util.Arrays;
import java.util.HashMap;

public class ContigousSubArrayWithGivenSum {
	private static void hashingMethod(int[] inputArray, int givenSum) {
		System.out.println("Given Array : " + Arrays.toString(inputArray));

		System.out.println("Given Sum : " + givenSum);

		System.out.println("Contiguous Sub Arrays With Sum " + givenSum + " Are : ");

		// Initializing currentSum to 0

		int currentSum = 0;

		// Defining sumIndexMap with currentSum as keys and index as values

		HashMap<Integer, Integer> sumIndexMap = new HashMap<>();

		// Inserting 0 as key and 1 as value into sumIndexMap

		sumIndexMap.put(0, -1);

		// Iterating each element of inputArray

		for (int i = 0; i < inputArray.length; i++) {
			// Adding current element to currentSum

			currentSum = currentSum + inputArray[i];

			// Checking whether sumIndexMap contains (currentSum - givenSum)

			if (sumIndexMap.containsKey(currentSum - givenSum)) {
				// If it contains, printing sub array

				printSubArray(inputArray, sumIndexMap.get(currentSum - givenSum) + 1, i);
			}

			// Inserting currentSum as key and i as its value into sumIndexMap

			sumIndexMap.put(currentSum, i);
		}
	}

	// Utility Method To Print Sub Array

	private static void printSubArray(int[] inputArray, int start, int end) {
		System.out.print("[");

		for (int i = start; i <= end; i++) {
			System.out.print(" " + inputArray[i]);
		}

		System.out.println(" ]");
	}

	public static void main(String[] args) {
		hashingMethod(new int[] { 2, 4, 2, 8, 3, 3, 2, -4, 12 }, 8);

		System.out.println("=====================================");

		hashingMethod(new int[] { 5, -9, 4, -2, 7, 1, -4, -3, -7 }, -7);

		System.out.println("=====================================");

		hashingMethod(new int[] { 7, 3, 6, 5, 21, -6, -15, 28, 8 }, 21);
	}
}
