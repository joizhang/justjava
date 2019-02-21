package com.joizhang.leetcode.twopoint;

/**
 * 125. Valid Palindrome
 *
 * @author joizhang
 */
class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < s.length() - 1 && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i > j) {
                break;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

}
