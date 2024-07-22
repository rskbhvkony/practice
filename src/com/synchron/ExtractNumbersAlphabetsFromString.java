package com.synchron;

public class ExtractNumbersAlphabetsFromString {
	public static void main(String[] args) {
		String str1 = "Java234T567point890@#!!";
		String str="Year2023March,";
		splitString(str);
	}

	static void splitString(String str) {
		StringBuffer alpha = new StringBuffer(), num = new StringBuffer(), special = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i)))
				num.append(str.charAt(i));
			else if (Character.isAlphabetic(str.charAt(i)))
				alpha.append(str.charAt(i));
			else
				special.append(str.charAt(i));
		}
		String finalStr = new StringBuffer().append(alpha).append(num).append(special).toString();
		System.out.println("** finalStr*  "+finalStr);
		System.out.println(alpha);
		System.out.println(num);
		System.out.println(special);
		
		main1();
	}
	
	public static void main1(){
        String s = "ABC12";
        boolean isAlphaNumeric = s != null && s.chars().allMatch(Character::isLetterOrDigit);
        System.out.println("IsAlphaNumeric: " + isAlphaNumeric);
    }
}
