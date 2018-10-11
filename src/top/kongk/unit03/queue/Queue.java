package top.kongk.unit03.queue;

/**
 * 描述：队列的接口
 *
 * @author kk
 */
public interface Queue<E> {

    /**
     * 描述：获取队列元素个数
     *
     * @return int
     */
    int getSize();

    /**
     * 描述：队列是否是空的
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 描述：入队
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 描述：出队
     *
     * @return E
     */
    E dequeue();

    /**
     * 描述：获取队首元素
     *
     * @return E
     */
    E getFront();

}
