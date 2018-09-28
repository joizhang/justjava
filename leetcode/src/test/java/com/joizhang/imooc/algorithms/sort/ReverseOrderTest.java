package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseOrderTest {

    @Test
    public void testReverseOrder() {
        Integer[] integers = {67, 62, 17, 100, 15, 20, 95, 65, 18, 22};
        Sorts.show(integers);
        ReverseOrder reverseOrder = new ReverseOrder(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
        assertEquals(25, reverseOrder.getCount());
    }

}