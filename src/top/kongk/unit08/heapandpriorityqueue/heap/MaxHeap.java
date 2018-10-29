package top.kongk.unit08.heapandpriorityqueue.heap;

import top.kongk.unit02.array.Array;

/**
 * 描述：最大堆
 * <p>
 * 堆的性质:
 * <li>1.完全二叉树, 但不一定是满的二叉树
 * <li>2.父节点总是比孩子节点大, 但节点值的大小和层级并没有确定的关系
 *
 * @author kk
 */
public class MaxHeap<E extends Comparable<E>> {

    /**
     * 使用自己写的动态数组作为堆存储数据
     */
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array(capacity);
    }

    public MaxHeap() {
        data = new Array();
    }

    /**
     * 将传来的 data heapify(堆化)成一个堆
     *
     * @param data Array<E>
     */
    public MaxHeap(Array<E> data) {

        this.data = data;
        /*
         * 对非叶子节点依次执行下沉操作
         */

        /*
         * 方式1
         */
        for (int i = getParent(data.getSize() - 1); i >= 0; --i) {
            siftDown(i);
        }

        /*
         * 方式2
         */

        /*for (int i = 0; i < data.getSize(); ++i) {
            //如果不是叶子节点
            if (getLeftChild(i) < data.getSize()) {
                siftDown(i);
            }
        }*/
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.getSize() == 0;
    }

    /**
     * 根据index获取其父节点的索引
     *
     * @param index
     * @return int
     */
    private int getParent(int index) {

        if (index <= 0) {
            throw new IllegalArgumentException("Require index > 0");
        }

        return (index - 1) / 2;
    }

    /**
     * 根据index获取其左孩子的索引
     *
     * @param index
     * @return int
     */
    private int getLeftChild(int index) {

        if (index < 0) {
            throw new IllegalArgumentException("Require index >= 0");
        }

        return index * 2 + 1;
    }

    /**
     * 根据index获取其右孩子的索引
     *
     * @param index
     * @return int
     */
    private int getRightChild(int index) {

        if (index < 0) {
            throw new IllegalArgumentException("Require index >= 0");
        }

        return index * 2 + 2;
    }

    /**
     * 添加元素
     *
     * @param e
     * @return void
     */
    public void add(E e) {

        /*
         * 在树的末尾添加元素, 添加了之后要和其父节点比较
         * 如果比父节点大, 就上移.... 一直上移到根节点为止
         */
        data.addLast(e);

        int index = data.getSize() - 1;

        siftUp(index);
    }

    private void siftUp(int index) {
        //如果当前节点不是根节点, 并且比父节点大
        while (index > 0 && data.get(index).compareTo(data.get(getParent(index))) > 0) {

            int parent = getParent(index);
            swap(index, parent);
            index = parent;
        }
    }

    private void swap(int index, int index2) {

        if (index != index2) {
            E current = data.get(index);
            E parent = data.get(index2);

            data.set(index, parent);
            data.set(index2, current);
        }
    }

    public E getFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }

        return data.get(0);
    }


    public E extractFront() {

        if (isEmpty()) {
            throw new IllegalArgumentException("MaxHeap is empty");
        }

        //保留第一个元素
        E e = getFront();

        //将二叉树中最后一个元素和第一个元素交换
        swap(data.getSize() - 1, 0);
        //移除最后一个元素
        data.removeLast();
        //对新交换来的第一个元素执行下沉操作
        siftDown(0);

        return e;
    }

    public void siftDown(int index) {

        int leftIndex = getLeftChild(index);

        //至少要有左孩子才能执行下沉
        while (leftIndex < data.getSize()) {

            //下沉交换用的索引 初始为左孩子
            int swapIndex = leftIndex;
            int rightIndex = getRightChild(index);

            //有右孩子, 且右孩子比左孩子大
            if (rightIndex < data.getSize()
                    && data.get(rightIndex).compareTo(data.get(leftIndex)) > 0) {
                swapIndex = rightIndex;
            }

            //如果当前元素不小于它的最大孩子, 就结束下沉
            if (data.get(index).compareTo(data.get(swapIndex)) >= 0) {
                break;
            }

            //当前元素大于它的最大孩子, 交换当前元素和最大孩子
            swap(index, swapIndex);

            //重置index和index的左孩子索引
            index = swapIndex;
            leftIndex = getLeftChild(index);
        }
    }

    /**
     * 将最大元素取出并返回, 把元素e放入maxHeap中
     *
     * @param e
     * @return E
     */
    public E replace(E e) {

        E front = getFront();

        //将data[0] 设置为要替换的元素
        data.set(0, e);

        //对data[0]下沉
        siftDown(0);

        return front;
    }


    @Override
    public String toString() {
        return "MaxHeap \n" +
                "data = " + data;
    }
}















