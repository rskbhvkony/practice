package com.synchron;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;

public class Test{
	public static void main(String[] args) throws IOException {
		int number= 1234; // = and int
		LinkedList<Integer> stack = new LinkedList<Integer>();
		while (number > 0) {
		    stack.push( number % 10 );
		    number = number / 10;
		}

		while (!stack.isEmpty()) {
		    System.out.println(stack.poll());
		}
		
		String s = "Welcome to Baeldung";
		String inputString = "Hello World\r\n"
				+ "We are in an interview here\r\n"
				+ "When zombies arrive, quickly fax Judge Pat";
		
		String[] result = inputString.split(System.lineSeparator());
		for (int i=0; i < result.length; i++){
		      System.out.println(result[i]);
		    }
		
		
		String headerRow="Country|Capital|Population";
        String[] rowArray = headerRow.split("\\|");//|
        for (int i=0; i < rowArray.length; i++){
		      System.out.println(rowArray[i]);
		    }
        
        char ch = '/';
        System.out.println(Character.isWhitespace(ch));
        
        System.out.println("#".repeat(13));
		
        
        Path path = Files.writeString(Files.createTempFile("test", ".txt"), "This was posted on JD");
        System.out.println(path);
        String s1 = Files.readString(path);
        System.out.println(s1); //This was posted on JD
        
        String someString = "elephant";
        long count = someString.chars().filter(et -> et == 'e').count();
        System.out.println(count); 
        
        
        String exampleString = "This is just a sample string";
        long totalCharacters = exampleString.chars().filter(e -> e != ' ').count();
        System.out.println("There are total " + totalCharacters + " characters in exampleString");
	}
}