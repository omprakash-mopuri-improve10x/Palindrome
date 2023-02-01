package com.omprakash.palindrome;

public class PalindromeControllerImpl implements PalindromeController{
    @Override
    public String findPalindrome(String input) {
       String reverse = "";
       for (int i = input.length() - 1; i >= 0; i--) {
           reverse = reverse + input.charAt(i);
       }
       if (input.equalsIgnoreCase(reverse)) {
           return input + " is a Palindrome";
       } else {
           return input + " is not a Palindrome";
       }
    }
}
