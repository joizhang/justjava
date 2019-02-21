package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseStringTest {

    @Test
    public void reverseString() {
        char[] s = "hello".toCharArray();
        new ReverseString().reverseString(s);
        assertEquals("olleh", String.valueOf(s));

        s = "ab".toCharArray();
        new ReverseString().reverseString(s);
        assertEquals("ba", String.valueOf(s));
    }
}