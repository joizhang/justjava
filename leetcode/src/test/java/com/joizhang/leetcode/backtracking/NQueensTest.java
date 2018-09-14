package com.joizhang.leetcode.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

public class NQueensTest {

    @Test
    public void solveNQueens() {
        NQueens nQueens = new NQueens();
        System.out.println(nQueens.solveNQueens(4));
        System.out.println(nQueens.solveNQueens(8));
    }
}