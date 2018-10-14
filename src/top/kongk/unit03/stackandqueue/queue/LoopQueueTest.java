package top.kongk.unit03.stackandqueue.queue;

/**
 * 描述：测试 LoopQueue
 *
 * @author kk
 */
public class LoopQueueTest {

    public static void main(String[] args) {

        LoopQueue<Integer> loopQueue = new LoopQueue<>(2);

        for (int i = 10; i < 15; ++i) {

            loopQueue.enqueue(i);

            System.out.println(loopQueue);
        }

        for (int i = 0; i < 4; ++i) {

        }

        System.out.println();
        while (!loopQueue.isEmpty()) {
            System.out.println(loopQueue.dequeue() + "出队列 : ");
            System.out.println(loopQueue);
            System.out.println();
        }
    }

    /*
     输出:

     LoopQueue : front = 0 , tail = 1
     [10]
     LoopQueue : front = 0 , tail = 2
     [10, 11]
     LoopQueue : front = 0 , tail = 3
     [10, 11, 12]
     LoopQueue : front = 0 , tail = 4
     [10, 11, 12, 13]
     LoopQueue : front = 0 , tail = 5
     [10, 11, 12, 13, 14]

     10出队列 :
     LoopQueue : front = 1 , tail = 5
     [11, 12, 13, 14]

     11出队列 :
     LoopQueue : front = 2 , tail = 5
     [12, 13, 14]

     12出队列 :
     LoopQueue : front = 3 , tail = 5
     [13, 14]

     13出队列 :
     LoopQueue : front = 0 , tail = 1
     [14]

     14出队列 :
     LoopQueue : front = 1 , tail = 1
     []


     Process finished with exit code 0

     */

}
