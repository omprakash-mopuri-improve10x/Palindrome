package com.omprakash.palindrome;

import junit.framework.TestCase;

public class PalindromeControllerImplTest extends TestCase {

    public void testFindPalindrome() {
        String expected = "0 is a Palindrome";
        String actual = new PalindromeControllerImpl().findPalindrome("0");
        assertEquals(expected, actual);
    }
}