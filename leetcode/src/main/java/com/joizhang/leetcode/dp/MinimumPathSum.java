package com.joizhang.leetcode.dp;

/**
 * 64. Minimum Path Sum
 *
 * @author joizhang
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        int i = grid.length - 1;
        int j = grid[grid.length - 1].length - 1;
        int res = grid[i][j];
        while (i != 0 && j != 0) {
            int left = grid[i][j-1];
            int top = grid[i - 1][j];
            if (left <= top) {

            }
        }
        return res;
    }

}
