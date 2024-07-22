package com.edu.arrays.examples;

public class SecondLargestNumber {
	    public static void main(String[] args) {
	        int[] arr = {1, 2, 3, 4, 5, 6};
	        int largest = Integer.MIN_VALUE;
	        int secondLargest = Integer.MIN_VALUE;

	        for (int num : arr) {
	            if (num > largest) {
	                secondLargest = largest;
	                largest = num;
	            } else if (num > secondLargest && num != largest) {
	                secondLargest = num;
	            }
	        }

	        System.out.println("The second largest number is: " + secondLargest);
	    }
}
