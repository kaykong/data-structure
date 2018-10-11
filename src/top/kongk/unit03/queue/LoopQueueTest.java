package top.kongk.unit03.queue;

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

}
