package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void groupAnagrams() {
        List<List<String>> res = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> group : res) {
            System.out.println(group);
        }
    }
}