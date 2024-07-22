package com.edu.arrays.examples;

public class LoopingThrough {
	public static void main(String[] args) {
		int[] myArray = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < myArray.length; i++) {
			System.out.println("Element at index " + i + ": " + myArray[i]);
		}
	}
}