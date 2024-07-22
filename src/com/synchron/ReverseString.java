package com.synchron;

public class ReverseString {
	public static void main(String[] args) {
		String str = "reverse";
		char ch[] = str.toCharArray();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = ch.length - 1; i >= 0; i--) {
			stringBuffer.append(ch[i]);
		}
		System.out.println(stringBuffer);
	}
}
