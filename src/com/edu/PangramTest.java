package com.edu;

import java.util.HashSet;
import java.util.Set;

public class PangramTest {
	public static void main(String[] args) {
		String inputString = "Hello World\r\n"
				+ "We are in an interview here\r\n"
				+ "When zombies arrive, quickly fax Judge Pat";
		int count = 0;
		boolean flag = false;
		char[] charArray = inputString.toCharArray();
		// 65 = A 90 = Z a= 97 z = 122
		Set<Character> set = new HashSet();
		for (char ch : charArray) {
			if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
				if (set.contains(ch)) {
					set.add(ch);
				} else {
					flag=set.add(ch);
				}
				count++;
			}
		}
		if (flag) {
			System.out.println("Is not Pangram ");
		}
	}
}
