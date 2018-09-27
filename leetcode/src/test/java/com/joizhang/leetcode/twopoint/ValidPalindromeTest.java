package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {

    @Test
    public void isPalindrome() {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        assertTrue(validPalindrome.isPalindrome(""));
        assertTrue(validPalindrome.isPalindrome("  a  "));
        assertTrue(validPalindrome.isPalindrome("aba"));
        assertTrue(validPalindrome.isPalindrome("a b a"));
        assertTrue(validPalindrome.isPalindrome("a,b,a"));
        assertTrue(validPalindrome.isPalindrome("  aba"));
        assertTrue(validPalindrome.isPalindrome("aba  "));

        assertTrue(validPalindrome.isPalindrome(".,"));

        assertFalse(validPalindrome.isPalindrome("0P"));
    }
}