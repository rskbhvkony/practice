package com.edu;

public class StringTest {
	public static void main(String[] args) {
      String str = "Hello";
      String s = str.concat("world");
      System.out.println(s);
      
      String[] strAr = {"Anilsaqwertyui", "Sam", "Joe"};  
      
    	    for (String word : strAr) {

    	        for (int i = 0; i < word.length(); i += 2) {
    	            System.out.print(word.charAt(i));
    	        }

    	        System.out.print(" ");

    	        for (int i = 1; i < word.length(); i += 2) {
    	            System.out.print(word.charAt(i));
    	        }

    	        System.out.println();
    	    }
    	 }
}
