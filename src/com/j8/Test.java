package com.j8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		List<String> strings = List.of("A BCD", "A EFG", "A HIJ");// ...
		Optional<String> result = strings.stream().filter(s -> s.startsWith("A")).findAny();
		System.out.println(" ** result **" + result);

		System.out.println(Stream.of("A BCD", "A EFG", "A HIJ").findAny());
		System.out.println(Stream.of("A BCD", "A EFG", "A HIJ").parallel().findFirst());
		
		List<Integer> integer = List.of(1,2,3,4,5,6,7,8,9,10,11);// .
		integer.forEach(e -> System.out.println(e));
		
		List < String > fruits = List.of("Banana", "Apple", "Mango", "Orange");
        fruits.forEach(System.out::println);
        
        
        List<String> ls = List.of("Apple", "Watermelon");
	     Optional.ofNullable(ls);
	     ls.stream().map(str -> str.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
	    // System.out.println("OutPut : "+ls);
	     
	     List<String> list = Arrays.asList("abc", "def", "ghi");
	     List<String> ls2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
	     ls2.forEach(System.out::println);
	     System.out.println(ls2);
	     //return ls1;
	}
}
