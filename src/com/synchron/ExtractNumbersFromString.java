package com.synchron;

import java.util.ArrayList;
import java.util.List;

public class ExtractNumbersFromString {
	public static void main(String[] args) {

		String str = "XXXX1234G21#";
		
		List<String> listOfStr = new ArrayList<>();
				listOfStr.add("XXXX1234G21#");
				listOfStr.add("YYYY5678G21#");

		String numString = "";
		String string = "";
		for (String cities : listOfStr)   
		{  
			
		}
		for (int i = 0; i < str.length(); i++) {
			int ascii = str.charAt(i);
			// ascii value of 0 is 48 and of 9 is 57
			if (ascii >= 48 && ascii <= (57)) {
				numString += (char) ascii;
			}
			
			if(ascii >= 65 && ascii <= (90) || ascii >= 97 && ascii <= (122)) {
				string += (char) ascii;
			}
		}
		// Convert number in string form to
		// an integer value
		int numbers = Integer.parseInt(numString);

		
		
		System.out.println(numbers);
		System.out.println(string.toLowerCase());
	}
}
