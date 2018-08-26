package com.joizhang.leetcode.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssignCookiesTest {

    @Test
    public void findContentChildren() {
        assertEquals(1, new AssignCookies().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        assertEquals(2, new AssignCookies().findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

}