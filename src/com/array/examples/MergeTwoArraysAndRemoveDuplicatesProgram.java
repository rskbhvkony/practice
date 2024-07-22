package com.array.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MergeTwoArraysAndRemoveDuplicatesProgram {
	private static int[] mergeArraysAndRemoveDuplicates(int[] arrayA, int[] arrayB) {
		// Step 1 : Merging of two arrays

		// Defining mergedArray with combined size of arrayA and arrayB

		int[] mergedArray = new int[arrayA.length + arrayB.length];

		// Initializing pointers of arrayA, arrayB and mergedArray with 0

		int i = 0, j = 0, k = 0;

		// Inserting all elements of arrayA into mergedArray

		while (i < arrayA.length) {
			mergedArray[k] = arrayA[i];
			k++;
			i++;
		}

		// Inserting all elements of arrayB into mergedArray

		while (j < arrayB.length) {
			mergedArray[k] = arrayB[j];
			k++;
			j++;
		}

		// Step 2 : Removing duplicates from merged array

		// Defining one HashSet object called setWithNoDuplicates
		// Remember, HashSet allows only unique elements

		Set<Integer> setWithNoDuplicates = new HashSet<>();

		// Adding all elements of mergedArray into setWithNoDuplicates

		for (int m = 0; m < mergedArray.length; m++) {
			setWithNoDuplicates.add(mergedArray[m]);
		}

		// Now, setWithNoDuplicates will have only unique elements of mergedArray

		// So, now iterate setWithNoDuplicates and
		// add its elements into new array called mergedArrayWithNoDuplicates

		Iterator<Integer> it = setWithNoDuplicates.iterator();

		int[] mergedArrayWithNoDuplicates = new int[setWithNoDuplicates.size()];

		int n = 0;

		// Adding all elements of setWithNoDuplicates into mergedArrayWithNoDuplicates

		while (it.hasNext()) {
			mergedArrayWithNoDuplicates[n] = it.next();
			n++;
		}

		// Step 3 : Sorting merged array after removing duplicates

		Arrays.sort(mergedArrayWithNoDuplicates);

		return mergedArrayWithNoDuplicates;
	}

	public static void main(String[] args) {
		int[] arrayA = new int[] { 7, -5, 3, 8, -4, 11, -19, 21 };

		int[] arrayB = new int[] { 6, 13, -7, 0, 11, -4, 3, -5 };

		int[] mergedArray = mergeArraysAndRemoveDuplicates(arrayA, arrayB);

		System.out.println("Array A : " + Arrays.toString(arrayA));

		System.out.println("Array B : " + Arrays.toString(arrayB));

		System.out.println("Sorted Merged Array With No Duplicates : ");

		System.out.println(Arrays.toString(mergedArray));
	}
}
