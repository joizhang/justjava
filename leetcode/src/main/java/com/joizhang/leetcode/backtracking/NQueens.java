package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 51. N-Queens
 *
 * @author joizhang
 */
class NQueens {

    private List<List<String>> res;

    private Boolean[] col;

    private Boolean[] dia1;

    private Boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new Boolean[n];
        Arrays.fill(col, false);
        dia1 = new Boolean[2 * n - 1];
        Arrays.fill(dia1, false);
        dia2 = new Boolean[2 * n - 1];
        Arrays.fill(dia2, false);
        putQueen(n, 0, new ArrayList<>());
        return res;
    }

    /**
     * 尝试在一个 n 皇后问题中，摆放第 index 行的皇后位置
     */
    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 尝试将第 index 行的皇后摆放在第 i 列
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        if (row.size() == n) {
            List<String> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder boardRow = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    boardRow.append(".");
                }
                boardRow.setCharAt(row.get(i), 'Q');
                board.add(boardRow.toString());
            }
            return board;
        }
        return new ArrayList<>();
    }

}
