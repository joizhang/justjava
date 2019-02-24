package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsomorphicStringsTest {

    @Test
    public void isIsomorphic() {
        assertTrue(new IsomorphicStrings().isIsomorphic("egg", "add"));
        assertFalse(new IsomorphicStrings().isIsomorphic("foo", "bar"));
        assertTrue(new IsomorphicStrings().isIsomorphic("paper", "title"));
        assertTrue(new IsomorphicStrings().isIsomorphic("abc", "cba"));
        assertFalse(new IsomorphicStrings().isIsomorphic("ab", "aa"));
    }
}