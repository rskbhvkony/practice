package com.edu.arrays.examples;

import java.util.*;

public class DynamicArrayFindSecondHighest {
	public static Integer findSecondHighest(List<Integer> arr) {
		if (arr.size() < 3) {
			return null; // or throw an exception if size must be at least 3
		}

		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num > highest) {
				secondHighest = highest;
				highest = num;
			} else if (num > secondHighest && num != highest) {
				secondHighest = num;
			}
		}

		return secondHighest == Integer.MIN_VALUE ? null : secondHighest;
	}

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,4,7,7,5));// (Arrays.asList(10, 5, 20,20, 30,30,  40));

		Integer resul = findSecondHighest(arr);
        if (resul != null) {
            System.out.println("The second-highest element is: " + resul);
        } else {
            System.out.println("There is no second-highest element.");
        }
        
        Integer result = findSecondHighest8(arr);
		if (result != null) {
			System.out.println("Using Java 8 The second-highest element is: " + result);
		} else {
			System.out.println("Using Java 8 There is no second-highest element.");
		}
		
	}
	
	
	public static Integer findSecondHighest8(List<Integer> arr) {
        // Check if size is less than 3
        if (arr.size() < 3) {
            System.out.println("The size must be at least 3.");
            return null;  // Return null if the list size is less than 3
        }

        // Use Streams to find the second-highest value
        Optional<Integer> secondHighest = arr.stream()
            .sorted(Comparator.reverseOrder())  // Sort the list in descending order
            .distinct()                         // Remove duplicates
            .skip(1)                            // Skip the first element (highest)
            .findFirst();                       // Get the next element (second-highest)

        return secondHighest.orElse(null);  // Return the second-highest or null if not present
    }
        
}
	
	

