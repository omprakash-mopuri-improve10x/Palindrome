package com.omprakash.palindrome;

import junit.framework.TestCase;

public class PalindromeControllerImplTest extends TestCase {

    public void testFindPalindrome() {
        boolean expected = true;
        boolean actual = new PalindromeControllerImpl().isCheckPalindrome("0");
        assertEquals(expected, actual);
    }
}