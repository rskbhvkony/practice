package com.array.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicatesInAnArray {
	 public static void main(String[] args) {
	        // Declare and initialize an integer array 'my_array'.
		 int[] a={1,2,5,5,6,6,7,9};
		 // Iterate through the elements of the array.
	        for (int i = 0; i < a.length-1; i++) {
	            for (int j = i+1; j < a.length; j++) {
	                // Check if two elements are equal and not the same element.
	                if ((a[i] == a[j]) && (i != j)) {
	                    // If a duplicate is found, print the duplicate element.
	                    System.out.println("Duplicate Element : " + a[j]);
	                }
	            }
	        }
	        
	        
	       IntStream stream = Arrays.stream(a);
	       			 stream.mapToObj(c -> (int) c)
	                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
	                .entrySet().stream()                 // Map -> Stream
	                .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
	                .map(Map.Entry::getKey)
	                .collect(Collectors.toSet());
	     	System.out.print(stream + " -");
	     	System.out.println("");
	     	
	        List<Integer> listOfIntegers = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);
	                  listOfIntegers.stream()
	                 .collect(Collectors.groupingBy(Function.identity() , Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
	                 .entrySet().stream()                 // Map -> Stream
	                 .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
	                 .map(Map.Entry::getKey)
	                 .collect(Collectors.toSet());
	         System.out.print(listOfIntegers);
	         System.out.println("");
	         
	       int n=  removeDuplicates(a);

	 		// Print updated array
	 		for (int i = 0; i < n; i++)
	 			System.out.print(a[i] + " ");
	    }  

		public static int removeDuplicates(int arr[]) {
			int n = arr.length;
			if (n == 0 || n == 1)
				return n;
			int j = 0;
			for (int i = 0; i < n - 1; i++)
				if (arr[i] != arr[i + 1])
					arr[j++] = arr[i];
			arr[j++] = arr[n - 1];
			return j;
		}
}
