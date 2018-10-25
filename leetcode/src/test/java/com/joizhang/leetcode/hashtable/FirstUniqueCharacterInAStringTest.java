package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterInAStringTest {

    @Test
    public void firstUniqChar() {
        FirstUniqueCharacterInAString firstUniqueCharacterInAString = new FirstUniqueCharacterInAString();

        assertEquals(0, firstUniqueCharacterInAString.firstUniqChar("leetcode"));
        assertEquals(2, firstUniqueCharacterInAString.firstUniqChar("loveleetcode"));
    }
}