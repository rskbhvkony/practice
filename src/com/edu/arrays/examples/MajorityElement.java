package com.edu.arrays.examples;

public class MajorityElement {

	    public static void main(String[] args) {
	        int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};
	        int candidate = findCandidate(arr);
	        if (isMajority(arr, candidate)) {
	            System.out.println("Majority element is: " + candidate);
	        } else {
	            System.out.println("No majority element found");
	        }
	    }

	    static int findCandidate(int[] arr) {
	        int majIndex = 0, count = 1;
	        for (int i = 1; i < arr.length; i++) {
	            if (arr[majIndex] == arr[i]) {
	                count++;
	            } else {
	                count--;
	            }
	            if (count == 0) {
	                majIndex = i;
	                count = 1;
	            }
	        }
	        return arr[majIndex];
	    }

	    static boolean isMajority(int[] arr, int candidate) {
	        int count = 0;
	        for (int num : arr) {
	            if (num == candidate) {
	                count++;
	            }
	        }
	        return count > arr.length / 2;
	    }
	}