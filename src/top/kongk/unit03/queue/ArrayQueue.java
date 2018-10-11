package top.kongk.unit03.queue;

import top.kongk.unit02.array.Array;
/**
 * 描述：数组队列
 *
 * @author kk
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ArrayQueue : Head [");

        for (int i = 0; i < array.getSize(); ++i) {

            if (i != array.getSize() - 1) {
                stringBuilder.append(array.get(i)).append(", ");
            } else {
                stringBuilder.append(array.get(i)).append("] tail");
            }
        }

        return stringBuilder.toString();
    }

}
