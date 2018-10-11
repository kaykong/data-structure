package top.kongk.unit04.linkedlist;

import top.kongk.unit03.queue.Queue;

/**
 * 描述：链表队列
 *
 * @author kk
 */
public class LinkedListQueue<E> implements Queue<E> {

    private LinkedList<E> linkedList;

    public LinkedListQueue() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        linkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return linkedList.removeFirst();
    }

    @Override
    public E getFront() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("LinkedListQueue : Head ");
        stringBuilder.append(linkedList);
        stringBuilder.append(" tail");

        return stringBuilder.toString();
    }
}
