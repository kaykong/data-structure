package top.kongk.unit04.linkedlist;

import top.kongk.unit03.queue.ArrayQueue;
import top.kongk.unit03.queue.LoopQueue;
import top.kongk.unit03.queue.Queue;
import top.kongk.unit03.stack.Stack;

import java.util.Random;

/**
 * 描述：对数组实现的栈, 队列 和 链表实现的栈, 队列进行对比
 *
 * @author kk
 */
public class ComparisionLinkedListAndArray {

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

    private static double testStack(Stack stack, int count) {

        /*
         * System.nanoTime() 纳秒, 一秒的10亿分之一, 常用作 内存读写速度的单位
         */
        long startTime = System.nanoTime();

        //入栈
        Random random = new Random();
        for (int i = 0; i < count; ++i) {
            stack.push(i);
        }

        //出栈
        for (int i = 0; i < count; ++i) {
            stack.pop();
        }

        long endTime = System.nanoTime();

        //纳秒的时间差, 转化为秒
        return (endTime - startTime) / 1000000000.0;
    }


    public static void main(String[] args) {

        int count = 100000;

        System.out.println("入队, 出队" + count + "次");
        System.out.println();

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("LinkedListQueue : " + testQueue(linkedListQueue, count) + 's');
        System.out.println();

        LinkedListQueueWithTail<Integer> linkedListQueueWithTail = new LinkedListQueueWithTail<>();
        System.out.println("LinkedListQueueWithTail : " + testQueue(linkedListQueueWithTail, count) + 's');
        System.out.println();

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(count);
        System.out.println("ArrayQueue : " + testQueue(arrayQueue, count) + 's');
        System.out.println();

        LoopQueue<Integer> loopQueue = new LoopQueue<>(count);
        System.out.println("LoopQueue : " + testQueue(loopQueue, count) + 's');
        System.out.println();
    }

    /*
    输出:

     入队, 出队100000次

     LinkedListQueue : 9.799170284s

     LinkedListQueueWithTail : 0.019429545s

     ArrayQueue : 4.402325748s

     LoopQueue : 0.008202317s


     Process finished with exit code 0

     */

}
