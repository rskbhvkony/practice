package com.edu.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalExample {
	public static void main(String[] args) {

		List<List<String>> data = new ArrayList<List<String>>();

	    data.add(Arrays.asList("Susan","Alexandra","Weaver","08/10/1949","Manhattan","Sigourney Weaver", null));
	    data.add(Arrays.asList("Charlize",null,"Theron","07/08/1975","Benoni","Charlize Theron","@CharlizeAfrica"));
	    data.add(Arrays.asList("Milica","Bogdanovna","Jovovich","17/12/1975","Kiev","Milla Jovovich", null));
	    data.add(Arrays.asList("Emily","Jean","Stone","06/12/1988","Scottsdale","Emma Stone",null));
	    data.add(Arrays.asList("Rose","Arianna","McGowan","05/09/1973","Certaldo","Rose McGowan","@rosemcgowan"));
	    data.add(Arrays.asList("Renée",null,"Zellweger","25/04/1969","Katy","Renée Zellweger",null));
	    data.add(Arrays.asList("Neta-Lee",null,"Hershlag","09/06/1981","Jerusalem","Natalie Portman",null));
	    data.add(Arrays.asList("Olivia","Jane","Cockburn","10/03/1984","New York City","Olivia Wilde","@oliviawilde"));
	    data.add(Arrays.asList("Ariana",null,"Grande-Butera","26/06/1993","Boca Raton","Ariana Grande","@ArianaGrande"));                                                                                                                             
	    data.add(Arrays.asList("Linda","Carroll","Hamilton","26/09/1956","Salisbury","Linda Hamilton",null));
	    data.stream()
	      .map(r -> changeToUpperCase(r))
	      .forEach(System.out::println);
	    
	    List<String> rawNumbers = Arrays.asList("1", null, "3", "2", "1", null);

	    List<Integer> numbers = rawNumbers.stream().map(Optional::ofNullable).map(OptionalExample::parseToInt)
	      .collect(Collectors.toList());

	  }

	  private static List<String> changeToUpperCase(List<String> row) {
	    return row.stream().map(OptionalExample::toUpperCase).collect(Collectors.toList());
	  }

	  private static String toUpperCase(String col) {
	    return Optional.ofNullable(col).map(String::toUpperCase).orElse("");
	    
	  }
	  
	  public static Integer parseToInt(Optional<String> opt) {
	    return opt.map(Integer::parseInt).orElse(0);
	  }
	  
	}
