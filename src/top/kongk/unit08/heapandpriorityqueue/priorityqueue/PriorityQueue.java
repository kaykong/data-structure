package top.kongk.unit08.heapandpriorityqueue.priorityqueue;

import top.kongk.unit03.stackandqueue.queue.Queue;
import top.kongk.unit08.heapandpriorityqueue.heap.MaxHeap;

/**
 * 描述：使用MaxHeap实现优先队列
 *
 * @author kk
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E >{

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        this.maxHeap = new MaxHeap();
    }

    public PriorityQueue(int capacity) {
        this.maxHeap = new MaxHeap(capacity);
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.getSize() == 0;
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractFront();
    }

    @Override
    public E getFront() {
        return maxHeap.getFront();
    }

    public E replace(E e) {
        return maxHeap.replace(e);
    }


}
