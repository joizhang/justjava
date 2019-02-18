package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindTest {

    @Test
    public void test() {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(1, 3);
        quickFind.union(3, 9);
        quickFind.union(9, 7);
        quickFind.union(7, 5);
        assertEquals(5, quickFind.find(1));
        assertTrue(quickFind.isConnected(1, 5));
    }

}