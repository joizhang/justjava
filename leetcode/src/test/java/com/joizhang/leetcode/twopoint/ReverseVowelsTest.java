package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseVowelsTest {

    @Test
    public void reverseVowels() {
        assertEquals("holle", new ReverseVowels().reverseVowels("hello"));
        assertEquals("leotcede", new ReverseVowels().reverseVowels("leetcode"));
        assertEquals("EO", new ReverseVowels().reverseVowels("OE"));
        assertEquals(".,", new ReverseVowels().reverseVowels(".,"));
    }
}