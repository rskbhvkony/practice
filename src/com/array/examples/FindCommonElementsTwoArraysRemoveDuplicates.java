package com.array.examples;

public class FindCommonElementsTwoArraysRemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5, -9, -7, -1, 8, 9, 12, 18, 18, 21, 27, 37, 71 };
		int arr[] = {1,2,5,5,6,6,7,2,1,1,2,9, 9};
	//	int n = arr.length;

		
		
	    int n = removeDuplicates(arr);

		// Print updated array
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println(" ");
		
		int[] arrayOne = { 4,3,2,3,1 };

		int[] arrayTwo = { 2,2,5,2,3,6};
		
		int[] result = findIntersectionValues(arrayOne, arrayTwo);
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		
		System.out.println();
		int[] resul = new int[arrayOne.length+arrayTwo.length];
		sortedMerge(arrayOne, arrayTwo,resul, arrayOne.length, arrayTwo.length );
		for (int i = 0; i < resul.length; i++)
			System.out.print(resul[i] + ", ");
		
		
	}

	public static void sortedMerge(int a[], int b[], int res[], int n, int m) {
		int i = 0, j = 0, k = 0;
		while (i < n) {
			res[k] = a[i];
			i++;
			k++;
		}

		while (j < m) {
			res[k] = b[j];
			j++;
			k++;
		}

	}
	
	public static int removeDuplicates(int arr[]) {
		int n = arr.length;
		if (n == 0 || n == 1)
			return n;
		int rd = 0;
		for (int i = 1; i < n; i++)
			if (arr[rd] != arr[i]) {
				rd++;
				arr[rd] = arr[i];
			}
		return rd+1;
	}
	
	public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
		int[] answer = new int[2]; 
        int[] count1 = new int[101];
        int[] count2 = new int[101];
        for (int i=0; i<nums1.length; i++) {
        	count1[nums1[i]]++;
        }
        for (int i=0; i<nums2.length; i++) {
        	count2[nums2[i]]++;
        }
        int result1=0, result2 =0;
        
        for (int i=1; i<=100; i++) {
        	if(count2[i]>=1) {
        		result1+=count1[i];
        	}
        	if(count1[i]>=1) {
        		result2+=count2[i];
        	}
        }
        answer[0] = result1;
        answer[1] = result2;
        return answer;
    }

}
