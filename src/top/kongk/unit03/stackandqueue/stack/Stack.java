package top.kongk.unit03.stackandqueue.stack;

/**
 * 描述：栈的接口
 *
 * @author kk
 */
public interface Stack<E> {

    /**
     * 描述：获取栈的元素数量
     *
     * @return int
     */
    int getSize();

    /**
     * 描述：判断栈是否是空的
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 描述：元素e入栈
     *
     * @param e
     */
    void push(E e);

    /**
     * 描述：出栈
     *
     * @return E
     */
    E pop();

    /**
     * 描述：获取栈顶元素
     *
     * @return E
     */
    E peek();

}
