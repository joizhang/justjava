package com.joizhang.leetcode.twopoint;

/**
 * 11. Container With Most Water
 *
 * @author joizhang
 */
class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            if (area > res) {
                res = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
