package com.joizhang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * @author joizhang
 */
class EvaluteRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : tokens) {
            if ("+".equals(s)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(s)) {
                int n = stack.pop();
                stack.push(stack.pop() - n);
            } else if ("*".equals(s)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(s)) {
                int n = stack.pop();
                stack.push(stack.pop() / n);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }

}
