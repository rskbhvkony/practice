package com.j8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringExample {
	public static void main(String[] args) {
		
		
		String input = "swiss"; 
				// Find the second non-repeating character 
				Optional<Character> secondNonRepeating = input.chars() // Get a stream of characters 
				.mapToObj(c -> (char) c) // Convert int stream to character stream 
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // Count occurrences in a LinkedHashMap 
				.entrySet().stream() // Stream the entries of the map 
				.filter(entry -> entry.getValue() == 1) // Keep only the characters that occur once 
				.skip(1) // Skip the first non-repeating character 
				.map(entry -> entry.getKey()) // Get the character 
				.findFirst(); // Get the first element (second non-repeating character) 
				// Output the second non-repeating character 
				secondNonRepeating.ifPresent(c -> System.out.println("The second non-repeating character is: " + c));

				

				System.out.println(firstNonRepeatingCharacter("swiss"));
				convertStringtoUpper();
				
	}
	
	private static Character firstNonRepeatingCharacter(String input) {  
        Character result =  input.chars()           // IntStream
        .mapToObj(i -> Character.toLowerCase(Character.valueOf((char) i)))  // convert to lowercase & then to Character object Stream
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
             .entrySet().stream()                       // EntrySet stream
             .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
             .map(entry -> entry.getKey())              // get the keys of EntrySet
             .findFirst().get();                        // get the first entry from the keys
        return result;    
  }
	
	private static List<String> convertStringtoUpper(){
		
		List<String> ls = List.of("Apple", "Watermelon");
	     Optional.ofNullable(ls);
	     List<String> ls1 = ls.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());//.forEach(System.out::print);
	     System.out.println(ls1);
	     
	     List<String> list = Arrays.asList("abc", "def", "ghi");
	     List<String> ls2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
	     ls2.forEach(System.out::print);
	     System.out.println(ls2);
	     return ls1;
    }   
	
}
