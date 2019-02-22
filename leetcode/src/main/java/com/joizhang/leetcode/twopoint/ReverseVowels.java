package com.joizhang.leetcode.twopoint;

/**
 * 345. Reverse Vowels of a String
 *
 * @author joizhang
 */
class ReverseVowels {

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i <= chars.length - 1 && !isVowels(chars[i])) {
                i++;
            }
            while (j >= 0 && !isVowels(chars[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            char c = chars[i];
            chars[i++] = chars[j];
            chars[j--] = c;
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c) {
        char lowerCase = Character.toLowerCase(c);
        return lowerCase == 'a' || lowerCase == 'e' || lowerCase == 'i' || lowerCase == 'o' || lowerCase == 'u';
    }

}
