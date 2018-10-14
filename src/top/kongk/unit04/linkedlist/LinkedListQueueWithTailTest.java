package top.kongk.unit04.linkedlist;

/**
 * 描述：
 *
 * @author kk
 */
public class LinkedListQueueWithTailTest {

    public static void main(String[] args) {

        LinkedListQueueWithTail<Integer> linkedListQueueWithTail = new LinkedListQueueWithTail<>();
        System.out.println(linkedListQueueWithTail);

        System.out.println("将数字 0-3 入队");
        for (int i = 0; i < 4; ++i) {

            linkedListQueueWithTail.enqueue(i);
            System.out.println(linkedListQueueWithTail);
        }
        System.out.println();

        System.out.println("出队: " + linkedListQueueWithTail.getFront());
        while (!linkedListQueueWithTail.isEmpty()) {
            linkedListQueueWithTail.dequeue();
            System.out.println(linkedListQueueWithTail);
        }
    }

    /*
    输出:

     将数字 0-3 入队
     LinkedListQueueWithTail : Head [0 -> Null]
     LinkedListQueueWithTail : Head [0 -> 1 -> Null]
     LinkedListQueueWithTail : Head [0 -> 1 -> 2 -> Null]
     LinkedListQueueWithTail : Head [0 -> 1 -> 2 -> 3 -> Null]

     出队: 0
     LinkedListQueueWithTail : Head [1 -> 2 -> 3 -> Null]

     */

}
