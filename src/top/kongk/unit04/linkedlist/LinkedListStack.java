package top.kongk.unit04.linkedlist;

import top.kongk.unit03.stackandqueue.stack.Stack;

/**
 * 描述：链表实现的栈
 *
 * @author kk
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
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
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("LinkedListStack: Top of stack ");
        stringBuilder.append(linkedList);
        stringBuilder.append(" end of stack.");

        return stringBuilder.toString();
    }
}
