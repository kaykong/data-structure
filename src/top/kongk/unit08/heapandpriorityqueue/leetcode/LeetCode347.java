package top.kongk.unit08.heapandpriorityqueue.leetcode;

import top.kongk.unit08.heapandpriorityqueue.priorityqueue.PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * 描述：使用自己写的基于MaxHeap的优先队列完成 leetCode 347
 * <p>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author kk
 */
public class LeetCode347 {

    private class Frequent implements Comparable<Frequent> {

        public int key;
        public int value;

        public Frequent(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Frequent other) {

            //把次序反过来就把默认的最大堆改成了最小堆
            return other.value - this.value;
        }
    }

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

        PriorityQueue<Frequent> queue = new PriorityQueue<>(k);

        for (Integer i : treeMap.keySet()) {

            Frequent frequent = new Frequent(i, treeMap.get(i));

            if (queue.getSize() < k) {
                //如果优先队列中还没有K个元素, 就直接入队
                queue.enqueue(frequent);
            } else {
                //获取队首元素, 如果当前元素比队首元素小 (实际value比队首元素value大)
                if (frequent.compareTo(queue.getFront()) < 0) {
                    //把队首元素替换为当前元素(内部堆会执行下沉操作)
                    queue.replace(frequent);
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>(k);

        while (!queue.isEmpty()) {
            list.add(queue.dequeue().key);
        }

        return list;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};

        List<Integer> list = new LeetCode347().topKFrequent(nums, 1);

        System.out.println(list);
    }
}
