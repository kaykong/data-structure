package top.kongk.unit03.stack;

import top.kongk.unit02.array.Array;

/**
 * 描述：用动态数组实现栈
 *
 * @author kk
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack() {
        array = new Array(10);
    }

    public ArrayStack(int capacity) {
        array = new Array(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.getSize() == 0;
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ArrayStack : Top of stack [");

        for (int i = array.getSize() - 1; i >= 0; --i) {

            if (i != 0) {
                stringBuilder.append(i + ", ");
            } else {
                stringBuilder.append(i + "] end of stack");
            }
        }

        return stringBuilder.toString();
    }
}
