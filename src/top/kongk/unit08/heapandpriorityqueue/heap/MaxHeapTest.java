package top.kongk.unit08.heapandpriorityqueue.heap;

/**
 * 描述：对maxHeap进行测试
 *
 * @author kk
 */
public class MaxHeapTest {

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        int[] nums = {3, 1, 6, 4, 12, 9};

        for (int num : nums) {
            maxHeap.add(num);
        }

        System.out.println(maxHeap);
        System.out.println();

        while (!maxHeap.isEmpty()) {
            Integer element = maxHeap.extractFront();
            System.out.println("取出元素: " + element);
            System.out.println(maxHeap);
            System.out.println();
        }
    }
}
