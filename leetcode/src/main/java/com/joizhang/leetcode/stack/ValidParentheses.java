package com.joizhang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author joizhang
 */
class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (c == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                    return false;
                }
                if (c == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                    return false;
                }
                if (c == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

}
