package com.joizhang.leetcode.heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * @author joizhang
 */
class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        // 获得数字出现频率
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (int key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(key);
            } else if (map.get(key) > map.get(priorityQueue.element())) {
                priorityQueue.remove();
                priorityQueue.add(key);
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove());
        }
        return res;
    }

}
