package com.array.examples;

import java.util.Arrays;

public class MaximumSubArrayProblem {
	private static void getSubArrayWithMaxSum(int[] inputArray) {
		// Initializing bestSum to first element of input array and
		// bestStart and bestEnd to first index i.e 0

		int bestSum = inputArray[0];
		int bestStart = 0;
		int bestEnd = 0;

		// Initializing currentSum and currentStart to 0

		int currentSum = 0;
		int currentStart = 0;

		for (int i = 0; i < inputArray.length; i++) {
			// Adding current element to currentSum

			currentSum = currentSum + inputArray[i];

			// If currentSum becomes negative, clearing currentSum and
			// setting currentStart to next element

			if (currentSum < 0) {
				currentSum = 0;
				currentStart = i + 1;
			}

			// If currentSum exceeds bestSum, assigning currentSum to bestSum and
			// updating bestStart and bestEnd

			else if (currentSum > bestSum) {
				bestSum = currentSum;
				bestStart = currentStart;
				bestEnd = i;
			}
		}

		// Printing sub array with bestSum

		System.out.println("Input Array : " + Arrays.toString(inputArray));

		System.out.print("Continous Sub Array With Maximum Sum : ");

		System.out.print("[ ");

		for (int i = bestStart; i <= bestEnd; i++) {
			System.out.print(inputArray[i] + " ");
		}

		System.out.print("]");

		System.out.println();

		System.out.println("Sum : " + bestSum);
	}

	public static void main(String[] args) {
		getSubArrayWithMaxSum(new int[] { 2, -3, 7, -4, 2, 5, -8, 6, -1 });
	}
}
