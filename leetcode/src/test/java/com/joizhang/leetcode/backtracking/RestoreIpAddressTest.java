package com.joizhang.leetcode.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class RestoreIpAddressTest {

    @Test
    public void restoreIpAddresses() {
        RestoreIpAddress restoreIpAddress = new RestoreIpAddress();
        assertEquals(Arrays.asList("255.255.11.135", "255.255.111.35"), restoreIpAddress.restore("25525511135"));
        assertEquals(Collections.singletonList("1.1.1.1"), restoreIpAddress.restore("1111"));
        assertEquals(Arrays.asList("12.70.0.1", "127.0.0.1"), restoreIpAddress.restore("127001"));
        assertEquals(new ArrayList<>(), restoreIpAddress.restore("213"));
    }
}