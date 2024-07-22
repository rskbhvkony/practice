package com.synchron;

public class SeperateNumbersAndStrings {
	public static void main(String[] args) {
      String input = "avbdt457hhlsis6";
      String alphabet = input.replaceAll("[0-9]", "");
      String numbers = input.replaceAll("[^0-9]", "");
      System.out.println(alphabet);
      System.out.println(numbers);
      
      
      char[] ch = alphabet.toCharArray();
      
      for (int i = 0; i < ch.length; i++) {
          for (int j = i + 1; j < ch.length; j++) {
              
              if (Character.toLowerCase(ch[j]) > Character.toLowerCase(ch[i])) {
                  char temp = ch[i];
                  ch[i] = ch[j];
                  ch[j] = temp;
              }
          }
      }
      System.out.println("String after sorting character in Descending order");
      System.out.println(String.valueOf(ch));
      
      
	}
}
