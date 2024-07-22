package com.edu.arrays.examples;

public class ModifyingElements {
	public static void main(String[] args) {
		int[] myArray = { 1, 2, 3, 4, 5 };
		myArray[1] = 10;
		System.out.println("Array after modification: " + java.util.Arrays.toString(myArray));
	}
}
