package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joizhang
 */
class LetterCombinations {

    private String[] letterMap = {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
     * 寻找和digits[index]匹配的字母，获得digits[0...index]翻译得到的解
     */
    private void findCombination(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
    }

}
