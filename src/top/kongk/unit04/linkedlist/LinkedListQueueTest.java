package top.kongk.unit04.linkedlist;

/**
 * 描述：测试LinkedListQueue
 *
 * @author kk
 */
public class LinkedListQueueTest {

    public static void main(String[] args) {

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();

        System.out.println("将数字 0-3 入队");
        for (int i = 0; i < 4; ++i) {

            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
        }
        System.out.println();

        System.out.println("出队: " + linkedListQueue.getFront());
        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);
    }

    /*
    输出:

     将数字 0-3 入队
     LinkedListQueue : Head [0 -> NULL] tail
     LinkedListQueue : Head [0 -> 1 -> NULL] tail
     LinkedListQueue : Head [0 -> 1 -> 2 -> NULL] tail
     LinkedListQueue : Head [0 -> 1 -> 2 -> 3 -> NULL] tail

     出队: 0
     LinkedListQueue : Head [1 -> 2 -> 3 -> NULL] tail

     */
}
