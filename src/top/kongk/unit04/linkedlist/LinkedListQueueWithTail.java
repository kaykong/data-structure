package top.kongk.unit04.linkedlist;

import top.kongk.unit03.stackandqueue.queue.Queue;

/**
 * 描述：带尾指针的 LinkedListQueue
 *
 * 在不带尾指针的 LinkedListQueue 中, 如果要入队, 需要使用 addLast() O(n) 的时间复杂度
 *
 * 稍加修改, 添加一个尾指针之后, 再入队, 仅需要 O(1)
 *
 * 入队使用尾指针，出队使用头指针，都是O(1)
 *
 * 在 ComparisionLinkedListAndArray 中测试10万次入队,出队, 时间上相差一百倍以上:
 *
 * LinkedListQueue : 9.799170284s
 * LinkedListQueueWithTail : 0.019429545s
 *
 * @author kk
 */
public class LinkedListQueueWithTail<E> implements Queue<E> {

    private class Node {

        public E e;

        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 有一个虚拟头节点
     */
    private Node head;
    /**
     * 尾指针
     */
    private Node tail;

    /**
     * 链表的长度
     */
    private int size;

    public LinkedListQueueWithTail() {
        head = new Node();
        tail = head;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        /*
         * 入队从tail那里入队
         */
        if (!isEmpty()) {
            //如果不是是空队列
            Node node = new Node(e);
            tail.next = node;
            tail = node;
        } else {

            tail.e = e;
        }

        ++size;
    }

    @Override
    public E dequeue() {

        /*
         * 出队要从 head 出队
         */
        if (isEmpty()) {
            throw new IllegalArgumentException("队列是空的");
        } else {

            Node node = head;
            head = node.next;
            node.next = null;
            --size;

            return node.e;
        }
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列是空的");
        } else {
            return head.e;
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("LinkedListQueueWithTail : Head [");

        Node node = head;
        if (size != 0) {
            while (node != null) {
                stringBuilder.append(node.e).append(" -> ");
                node = node.next;
            }
        }
        stringBuilder.append("Null]");

        return stringBuilder.toString();
    }
}
