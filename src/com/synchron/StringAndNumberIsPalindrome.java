package com.synchron;

public class StringAndNumberIsPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("12321".toLowerCase()));
        System.out.println(isPalindrome("12345".toLowerCase()));
        
        
      //variables initialization
      //  int num = 12021, reverse = 0;
        // palindrome if num and reverse are equal
		/*
		 * if (getReverse(num, reverse) == num) System.out.println (num +
		 * " is Palindrome"); else System.out.println (num + " is not Palindrome");
		 */
        int number = 12451, reversedNum = 0, reminder ;
        
        int original = number;
        
        while (number != 0) {
        reminder = number% 10;
        reversedNum = reversedNum*10+reminder;
        number /=10;
        }
        if (original == reversedNum) {
            System.out.println(original + " is Palindrome.");
          }
          else {
            System.out.println(original + " is not Palindrome.");
          }
        
	}
	
	private static boolean isPalindrome(String original) {

        String reversed = "";

        int len = original.length();

        for (int i = len - 1; i >= 0; i--) {

            reversed = reversed + original.charAt(i);
        }

        return original.equals(reversed);
    }
	
	/*
	 * static int getReverse(int num, int rev){ if(num == 0) return rev;
	 * 
	 * int rem = num % 10; rev = rev * 10 + rem;
	 * 
	 * return getReverse(num / 10, rev); }
	 */
	
	
}
