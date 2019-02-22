package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstUniqueCharacterTest {

    @Test
    public void firstUniqChar() {
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        assertEquals(0, firstUniqueCharacter.firstUniqChar("leetcode"));
        assertEquals(2, firstUniqueCharacter.firstUniqChar("loveleetcode"));
    }
}