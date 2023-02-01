package com.omprakash.palindrome;

public class PalindromeControllerImpl implements PalindromeController{
    @Override
    public boolean isPalindrome(String input) {
       String reverse = "";
       input = input.trim();
       for (int i = input.length() - 1; i >= 0; i--) {
           reverse += input.charAt(i);
       }
       if (input.equals(reverse)) {
           return true;
       } else {
           return false;
       }
    }
}
