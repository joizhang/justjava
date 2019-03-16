package com.joizhang.leetcode.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluteRPNTest {

    @Test
    public void evalRPN() {
        assertEquals(9, new EvaluteRPN().evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, new EvaluteRPN().evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, new EvaluteRPN().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}