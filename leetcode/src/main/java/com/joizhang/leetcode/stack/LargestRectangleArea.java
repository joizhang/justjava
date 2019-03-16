package com.joizhang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author joizhang
 */
class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        // 栈中存放索引
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        // 在数组最后填充一个0
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (stack.isEmpty() || h >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int curArea = heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek());
                maxArea = Math.max(maxArea, curArea);
                i--;
            }
        }
        return maxArea;
    }

}
