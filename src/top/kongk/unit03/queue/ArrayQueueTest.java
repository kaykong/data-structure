package top.kongk.unit03.queue;

/**
 * 描述：对ArrayQueue的测试
 *
 * @author kk
 */
public class ArrayQueueTest {

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(5);

        System.out.println("将数字0-6入队");

        for (int i = 0; i < 7; ++i) {

            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
        }

        System.out.print("获取队首元素: ");
        System.out.println(arrayQueue.getFront());
        System.out.println();

        System.out.println("----------出队------------");

        for (int i = 0; i < 3; ++i) {

            System.out.print("队首元素: ");
            System.out.println(arrayQueue.dequeue());

            System.out.println(arrayQueue);
            System.out.println();
        }

        /*
         输出:

         将数字0-6入队
         ArrayQueue : Head [0] tail
         ArrayQueue : Head [0, 1] tail
         ArrayQueue : Head [0, 1, 2] tail
         ArrayQueue : Head [0, 1, 2, 3] tail
         ArrayQueue : Head [0, 1, 2, 3, 4] tail
         ArrayQueue : Head [0, 1, 2, 3, 4, 5] tail
         ArrayQueue : Head [0, 1, 2, 3, 4, 5, 6] tail
         获取队首元素: 0

         ----------出队------------
         队首元素: 0
         ArrayQueue : Head [1, 2, 3, 4, 5, 6] tail

         队首元素: 1
         ArrayQueue : Head [2, 3, 4, 5, 6] tail

         队首元素: 2
         ArrayQueue : Head [3, 4, 5, 6] tail
         */
    }
}
