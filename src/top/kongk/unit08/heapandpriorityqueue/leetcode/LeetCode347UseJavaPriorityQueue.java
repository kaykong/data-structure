package top.kongk.unit08.heapandpriorityqueue.leetcode;

import java.util.*;

/**
 * 描述：使用java自带的priorityQueue完成leetCode 347
 *
 * @author kk
 */
public class LeetCode347UseJavaPriorityQueue {

    public List<Integer> topKFrequent(int[] nums, int k) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        /*
         * 遍历数组中的元素, 把元素作为key, 元素出现的次数作为value存入treeMap中
         */
        for (int num : nums) {
            Integer value = treeMap.get(num);
            value = value == null ? 1 : value + 1;
            treeMap.put(num, value);
        }

        /*
         * 取出出现次数最多的前K个元素
         *
         * 使用限制个数的最小堆构成的优先队列, 每次遇到元素个数大于队列的, 就出队, 入队
         */
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                //这个比较器只是在queue内部下沉或上浮操作才用到的
                Comparator.comparingInt(treeMap::get)
        );

        for (Integer i : treeMap.keySet()) {

            if (queue.size() < k) {
                queue.add(i);
            } else if (treeMap.get(i) > treeMap.get(queue.peek())) {
                //队首元素出队
                queue.remove();
                //新元素入队
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            list.add(queue.remove());
        }

        return list;
    }
}