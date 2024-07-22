package com.edu.arrays.examples;

public class SortingArrays {
	public static void main(String[] args) {
		int[] myArray = { 5, 3, 4, 1, 2 };
		java.util.Arrays.sort(myArray);
		System.out.println("Sorted array: " + java.util.Arrays.toString(myArray));
	}
}
