package top.kongk.unit02.array;

/**
 * 描述：自己创建的动态数组
 *
 * @author kk
 */
public class Array<E> {

    private E[] data;

    private int size;

    /**
     * 根据指定的capacity创建数组
     *
     * @param capacity
     */
    public Array(int capacity) {

        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造函数, 数组初始容量为10
     */
    public Array() {
        this(10);
    }


    /**
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * @return 数组内元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 数组是否是空的
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在索引index处添加元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("数组越界! 提示: index >= 0 && index <= getSize()");
        }

        //如果数组现在满了, 就扩容
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        //将index之后的元素依次向后移动
        for (int i = size; i > index; --i) {
            data[i] = data[i - 1];
        }

        data[index] = e;
        ++size;
    }

    /**
     * 在数组末尾追加 e
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在数组首部添加e
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 根据索引index获取元素
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界! 提示: index >= 0 && index < getSize()");
        }

        return data[index];
    }

    /**
     * 根据索引index修改元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界! 提示: index >= 0 && index < getSize()");
        }

        data[index] = e;
    }

    /**
     * 查找数组中是否有该元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {

        for (int i = 0; i < size; ++i) {

            if (data[i].equals(e)) {
                return true;
            }
        }

        return false;
    }

    /**
     * 查找元素e在数组中的索引, 如果不存在就返回-1
     *
     * @param e
     * @return index or -1
     */
    public int find(E e) {

        for (int i = 0; i < size; ++i) {

            if (data[i].equals(e)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 从数组中删除索引index处的元素, 并返回该元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("数组越界! 提示: index >= 0 && index < getSize()");
        }

        //保存要返回的值
        E e = data[index];

        //把index后的元素, 依次往前挪
        for (int i = index; i < size - 1; ++i) {
            data[i] = data[i + 1];
        }

        //把原数组最后一个元素置为null
        --size;
        data[size] = null;


        /**
         * 缩容: 在size等于数组容量的时候, 不断地add, remove
         * 因为扩容的时候是 2 倍扩容,
         * 如果缩容的条件再为 size == getCapacity() / 2 的话, 就会不断地扩容, 缩容...
         *
         * 出现原因: remove的时候, 缩容太着急了
         *
         * 解决办法: 在 size == getCapacity() / 4 的时候, 再将capacity减半 (注意capacity要大于1)
         */
        if (size == getCapacity() / 4 && getCapacity() > 1) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从数组中删除第一个该元素
     *
     * @param e
     * @return
     */
    public boolean removeElement(E e) {

        //查找元素的位置
        int index = find(e);

        if (index != -1) {
            remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Arrays: size = ").append(size).append(", capacity = ").append(getCapacity()).append("\n");
        stringBuilder.append('[');

        for (int i = 0; i < size; ++i) {

            if (i != size - 1) {
                stringBuilder.append(data[i]).append(", ");
            } else {
                stringBuilder.append(data[i]).append("]");
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 将数组的容量设置为 newCapacity 大小
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {

        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; ++i) {

            newData[i] = data[i];
        }

        data = newData;
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {

        return get(size - 1);
    }

}
