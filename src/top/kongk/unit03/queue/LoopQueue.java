package top.kongk.unit03.queue;

/**
 * 描述：循环队列
 * <p>
 * 循环队列的好处就是, 在出队的时候不必挪动队伍, 由原来的 O(n) 降到 O(1)
 * <p>
 * 1.循环队列需要一个头指针 front, 一个尾指针 tail
 * <p>
 * 2.front 与 tail 递增的时候要与队列的容量取余, 这样才能起到循环的效果
 * <p>
 * 3.为了判断队列是空的还是满的, 还有空出一格
 * <p>
 * 4.当数组满的时候, 再进行扩容, 所以这里不能采用之前写的动态数组
 *
 * @author kk
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    /**
     * 头指针和尾指针
     */
    private int front, tail;

    /**
     * 在这里多加一个size是因为循环队列中, array的size不好使了
     */
    private int size;

    public LoopQueue(int capacity) {

        //因为要留出一个空白, 所以+1
        data = (E[]) new Object[capacity + 1];

        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        //头指针和尾指针相等的时候也即是空
        return front == tail;
    }

    @Override
    public void enqueue(E e) {

        //先判断队列是否满了
        if ((tail + 1) % data.length == front) {
            resize(data.length * 2);
        }

        //赋值
        data[tail] = e;
        //计算下一个队尾元素的位置
        tail = (tail + 1) % data.length;

        ++size;
    }

    @Override
    public E dequeue() {

        //出队之前先判断队是不是空的
        if (isEmpty()) {
            throw new IllegalArgumentException("队列是空的");
        }

        //取出队首元素, 并把该位置设为 null
        E e = data[front];
        data[front] = null;

        //front 向后移动一位
        front = (front + 1) % data.length;
        --size;

        //判断是否需要缩容
        if (size == data.length / 4 && getCapacity() > 0) {
            resize(getCapacity() / 2);
        }

        return e;
    }

    @Override
    public E getFront() {

        if (!isEmpty()) {
            return data[front];
        } else {
            throw new IllegalArgumentException("队列是空的");
        }
    }

    private void resize(int capacity) {

        E[] data2 = (E[]) new Object[capacity + 1];

        //把原数组中的元素取出来放在新数组里
        int j = 0;
        for (int i = front; i != tail; i = (i + 1) % data.length, ++j) {
            data2[j] = data[i];
            data[i] = null;
        }

        front = 0;
        tail = j;
        data = data2;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("LoopQueue : front = ").append(front).append(" , tail = ").append(tail).append("\n");
        stringBuilder.append("[");


        for (int i = front; i != tail; i = (i + 1) % data.length) {

            stringBuilder.append(data[i]);

            if ((i + 1) % data.length != tail) {
                stringBuilder.append(", ");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
