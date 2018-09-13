package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * @author joizhang
 */
class RestoreIpAddress {

    private static final int SEGMENT_MIN_LENGTH = 1;

    private static final int SEGMENT_MAX_LENGTH = 3;

    private static final int SEGMENT_NUMBER = 4;

    private List<String> res;

    public List<String> restore(String s) {
        res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        restore(s, 0, "");
        return res;
    }

    private void restore(String s, int segmentCount, String ip) {
        if (s.length() > (SEGMENT_NUMBER - segmentCount) * SEGMENT_MAX_LENGTH
                || s.length() < (SEGMENT_NUMBER - segmentCount) * SEGMENT_MIN_LENGTH) {
            return;
        }
        if (segmentCount == SEGMENT_NUMBER) {
            res.add(ip.substring(0, ip.length() - 1));
            return;
        }
        // 防止 index out of range
        for (int i = 1; i <= Math.min(s.length(), SEGMENT_MAX_LENGTH); i++) {
            String subStr = s.substring(0, i);
            boolean notValid = (subStr.length() > 1 && subStr.charAt(0) == '0') || (subStr.length() == 3 && Integer.valueOf(subStr) > 255);
            if (!notValid) {
                restore(s.substring(i), segmentCount + 1, ip + subStr + '.');
            }
        }
    }

}
