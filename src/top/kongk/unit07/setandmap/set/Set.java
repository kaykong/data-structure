package top.kongk.unit07.setandmap.set;

/**
 * 描述：Set 集合
 *
 * @author kk
 */
public interface Set<E> {

    /**
     * 获取集合元素的数量
     *
     * @return int
     */
    int getSize();

    /**
     * 集合是否是空的
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 添加集合中不存在的元素
     *
     * @param e
     */
    void add(E e);

    /**
     * 集合中是否包含元素e
     *
     * @param e
     * @return boolean
     */
    boolean contains(E e);

    /**
     * 移除集合中的元素e
     *
     * @param e
     */
    void remove(E e);

}
