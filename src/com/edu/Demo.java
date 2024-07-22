package com.edu;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int index = 0; true; index++) {
			System.out.println("Welcome");
			break;
		}
		
		// Creating a list of integers
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 6, 7, 2);

        // Finding the second largest number using Stream API
        Optional<Integer> secondLargest = numbers.stream().distinct() // Remove duplicates
                .sorted(Comparator.reverseOrder()) // Sort the stream in descending order
                .skip(1) // Skip the largest number
                .findFirst(); // Find the second largest number

        // Displaying the second largest number
        secondLargest.ifPresent(number -> System.out.println("Second Largest Number: " + number));
        
		/*
		 * Employee employees =
		 * com.edu.ManagerEmployeeJava8.getUnsortedEmployeeList().stream()
		 * .sorted(Comparator.comparingDouble(Employee::getAge).reversed());
		 * System.out.println("The second highest salary is:"+
		 * employees.get(1).getSalary());
		 */
        
        Employee secondHighestSalary = com.edu.ManagerEmployeeJava8.getUnsortedEmployeeList().stream()
        		.sorted(Comparator.comparingDouble(Employee::getAge).reversed()).skip(1).findFirst().get();
        System.out.println("SecondHighestSalary"+ secondHighestSalary);
        
		//FirstRepeat Number and First NonRepeat Number
		List<Integer> nbr = Arrays.asList(new Integer[] { 1, 2, 1, 3, 4, 4 });
		numbers.stream().filter(i -> Collections.frequency(nbr, i) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);
		
		//Find first non-repeated Character using basic java
		String string = "Bharath";
		int index = -1;
		char fnc = ' ';
		for (char i : string.toCharArray()) {
			if (string.indexOf(i) == string.lastIndexOf(i)) {
				fnc = i;
				break;
			} else {
				index += 1;
			}
		}
		if (index == 1) {
			System.out.println("Either all characters are repeating or " + "string is empty");
		} else {
			System.out.println("First non-repeating character is " + fnc);
		}
		
		//First NonRepeat Character and First Repeat Character using Java 8
		String input = "Bharath";

		Map<Character, Long> charCount = input.chars().mapToObj(i -> (char) i)
		                                 .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println( " charCount # "+ charCount);

		Optional<Character> firstNonRepeat = charCount.entrySet().stream()
						     .filter((e) -> e.getValue() == 1)
						     .map(e -> e.getKey()).findFirst();

		Optional<Character> firstRepeat = charCount.entrySet().stream()
						     .filter((e) -> e.getValue() > 1)
						     .map(e -> e.getKey()).findFirst();

		if(firstNonRepeat.isPresent()){
		   System.out.println( " firstNonRepeat # "+ firstNonRepeat.get());
		}

        System.out.println( " firstRepeat # "+ firstRepeat.get());
		
        
        
        
        // Step 1: Convert the string into a stream of characters
        Character result = input.chars() // Creates an IntStream
                .mapToObj(c -> (char) c) // Convert int to Character
                // Step 2: Collect characters to map with occurrence count, preserving order
                .collect(Collectors.toMap(Function.identity(), v -> 1, Integer::sum, LinkedHashMap::new))
                // Step 3: Find the first character with more than one occurrence
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null); // Retrieve the first repeated character, if any

        // Step 4: Print the first repeated character
        if (result != null) {
            System.out.println("First repeated character: " + result);
        } else {
            System.out.println("No repeated characters found.");
        }
        
        String original = "JAVA";
        char[] chars = original.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
        
        System.out.println("");
        String str = "Java Articles are Awesome";

        Character resultChar =   str.chars() // Stream of String       
                                .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
                                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == 1L)
                                .map(entry -> entry.getKey())
                                .findFirst()
                                .get();
        System.out.println("resultChar :: "+resultChar);     
        
        Map<String, Long> frequencyOfEachChar = Arrays.stream(str.split("")).map(String::toLowerCase)
                .collect(Collectors.groupingBy(strg -> strg, LinkedHashMap::new, Collectors.counting()));
        System.out.println("Frequency Of Each Char "+frequencyOfEachChar);
        
        Map<Character, Long> frequencyMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // Displaying the frequency of each character
        frequencyMap.forEach((character, frequency) -> System.out.println("Character: " + character + ", Frequency: " + frequency));
        
        // 1. convert string into IntStream by calling chars on string
        // , here removing space by replaceAll method
        IntStream intStream = str.replaceAll("\\s", "").chars();
     
           // 2. convert IntSteram into Character Stream by mapToObj(c -> (char) c)
        Stream<Character> charWrapperStream = intStream.mapToObj(c -> (char) c);
     
            //3. using groupingby find char and frquency in map
        Map<Character, Long> findFrequncyOfChar = charWrapperStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
     
        // 4. Displaying the frequency of each character
     
        findFrequncyOfChar.forEach((character,freqency)-> System.out.println("chracter "+character +" freqency "+freqency));
        // or 
        System.out.println("Frequency "+findFrequncyOfChar);
        
        String string1 = "Heart";
        String string2 = "Earth";

        string1 = Stream.of(string1.split("")).map(String::toUpperCase)
          .sorted().collect(Collectors.joining());
        
        string2 = Arrays.stream(string2.split("")).map(String::toUpperCase)
          .sorted().collect(Collectors.joining());

        if (string1.equalsIgnoreCase(string2)) {

         System.out.println("Two String " + string1 + " and " + string2 + " are Anagrams");

        } else {
         System.out.println("Two String " + string1 + " and " + string2 + " are NOT Anagrams");

        }
        
        //Map<Boolean, List<Integer>> response = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(n -> n % 2 == 0)));
	}
}