package com.omprakash.palindrome;

public interface PalindromeView {

    void checkPalindrome();
    void showErrorMessage();
    void showDialog(String text, int imageResourceId, int textColor);
}
