package top.kongk.unit03.queue;

import java.util.Random;

/**
 * 描述：比较循环队列与数组队列的性能差异
 *
 *
 * @author kk
 */
public class ComparisionLoopQueueAndArrayQueue {

    private static double testQueue(Queue queue, int count) {

        /*
         * System.nanoTime() 纳秒, 一秒的10亿分之一, 常用作 内存读写速度的单位
         */
        long startTime = System.nanoTime();

        //count次入队
        Random random = new Random();
        for (int i = 0; i < count; ++i) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        //count次出队
        for (int i = 0; i < count; ++i) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        //纳秒的时间差, 转化为秒
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int count = 100000;

        //数组队列10万次入队, 出队
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double t1 = testQueue(arrayQueue, count);
        System.out.println("ArrayQueue<Integer> :" + t1);

        //循环队列10万次入队, 出队
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double t2 = testQueue(loopQueue, count);
        System.out.println("LoopQueue<Integer>  :" + t2);
    }

    /*
     输出:
     ArrayQueue<Integer> :4.795742217
     LoopQueue<Integer>  :0.015645123
     */

}
