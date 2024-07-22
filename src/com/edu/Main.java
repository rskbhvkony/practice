package com.edu;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("This", "is", "how", "reduce()", "works!");

		// The stream reduce method takes up a lambda expression where
		// we have the accumulator.
		
		// Inside the accumulator, we'll combine all the words together in one sentence.
		Optional<String> finalString = words.stream()
						.reduce((prevString, string) -> prevString + " " + string);

		// Printing the final string
		System.out.println(finalString.get());
		
		
		List<String> strings = List.of("A BCD","A EFG","A HIJ");// ...
				Optional<String> result = strings.stream()
				                                 .filter(s -> s.startsWith("A"))
				                                 .findAny();
        System.out.println(" ** result **"+ result);
        
        System.out.println(Stream.of("A BCD","A EFG","A HIJ").findAny());
        System.out.println(Stream.of("A BCD","A EFG","A HIJ").parallel().findFirst());
        
        Integer intMax = Stream.of(1,3,4,9).distinct().reduce(Integer::max).get();
        System.out.println("Max  "+ intMax);
        
        Integer intMin = Stream.of(1,3,4,9).distinct().reduce(Integer::min).get();
        System.out.println("Max  "+ intMin);
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalInt maxNumber = numbers.stream() // Convert list to stream
                				.mapToInt(Integer::intValue) // Convert Integer to int
                				.max();//.stream().findAny();
        System.out.println("Max Number  "+ maxNumber);
        
        Optional<Integer> maximumNumber = numbers.stream().max(Integer::compareTo);
        System.out.println("Max Number  "+ maximumNumber);
        
       	Stream.of(86, 7, 5).findAny().ifPresent(s -> System.out.println(s));
        
        Stream.of("one", "two", "three", "four")
        .filter(e -> e.length() > 3)
        .peek(e -> System.out.println("Filtered value: " + e))
        .map(String::toUpperCase)
        .peek(e -> System.out.println("Mapped value: " + e))
        .collect(Collectors.toList());
        
        
        String[] str = new String[10];
		str[5] = "Eazy Bytes";

		Optional<String> empty = Optional.empty();
		System.out.println(empty);

		Optional<String> value = Optional.of(str[5]);
		System.out.println(value.get());
		// We should of() when we are sure that value will present, otherwise go for
		// ofNullable()
		Optional<String> nullValue = Optional.ofNullable(str[4]);
		nullValue.ifPresent(System.out::println);
		System.out.println(nullValue.orElse("No Value"));
		
		String input = "JJavva Inspires Is HelpFul";

        Character nonRepeat =
                input.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(e-> e.getValue()==1).map(e->e.getKey()).findFirst().get();
		
		System.out.println("NonRepeat "+nonRepeat);
		
		Character repeat =
                input.chars()
                .mapToObj(c->Character.toLowerCase(Character.valueOf((char) c)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
				.entrySet().stream().filter(e-> e.getValue()>1).map(e->e.getKey()).findFirst().get();

        System.out.println("Repeat "+repeat);
        
        OptionalInt maxNumbe = numbers.stream() // Convert list to stream
                .mapToInt(Integer::intValue) // Convert Integer to int
                .max();

	}
}
