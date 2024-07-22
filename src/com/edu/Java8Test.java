package com.edu;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Test {
	public static void main(String[] args) {
		System.out.println(" ** " +arraysCompareCheck());
		isLeapYear();
		System.out.println("******************");
		
		String str = "Venkata Rajasekhar";

		// Stream<Character>map
		// =str.chars().mapToObj(Character.toLowerCase(ch->(char)ch));
		IntStream tnst = str.replace(" ", "").chars();
		Map<Character, Long> map = tnst.mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		// m.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Each char count " + map);
		
		//		s -> Character.toLowerCase(Character.valueOf((char) s))
		Map<Character, Long> charCount = str.chars().mapToObj(i -> (char) i)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("Each char count " + charCount);
		
		List<String> colors = Arrays.asList("RED", null, "BLUE", null, "GREEN");
		 
        colors = colors.stream().filter(Objects::nonNull)        //x -> x != null or `Objects::nonNull`
                    .collect(Collectors.toList());
        System.out.println("colors " + colors);
        
		
		int a[] = { 10, 5, 15 };
		int b[] = { 20, 3, 2, 12, 2 };
		
		System.out.println(" Output "+Arrays.stream(b).distinct().boxed().collect(Collectors.toSet()));
		System.out.println(" Output "+Arrays.stream(b).boxed().collect(Collectors.toSet()));
		
		int n = a.length;
		int m = b.length;

		// Final merge list
		int res[] = new int[n + m];
		sortedMerge(a, b, res, n, m);
		
		for (int i = 0; i < res.length; i++) {
			for (int j = i + 1; j < res.length; j++) {
				if (res[i] > res[j]) {
					int temp = res[i];
					res[i] = res[j];
					res[j] = temp;
				}
			}
		}
		
		System.out.print("Sorted merged list :");
		for (int i = 0; i < n + m; i++)
			System.out.print(" " + res[i]);

		
		
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

	public static boolean arraysCompareCheck() {
		int[] a = { 1, 2, 3 };
		int[] b = { 1, 2, 3 };
		// public static boolean arraysCompareCheck(String a[], String b[]){
		if (a.length != b.length) {
			return false;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] != b[i]) {
					return false;
				}
			}
		}
		return true;
	} 
	
	public static void isLeapYear() {
	    int year = 2024;
	    String result;
	    // divisible by 4, not by 100, or divisible by 400
	    result = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? "is a leap year" : "is not a leap year";
	    System.out.println(year + " " + result + ".");
	}
	
}
