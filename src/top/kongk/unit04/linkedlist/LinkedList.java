package top.kongk.unit04.linkedlist;

/**
 * 描述：链表
 *
 * @author kk
 */
public class LinkedList<E> {

    private class Node {

        public E e;


        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;

    /**
     * 链表的元素的个数
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的长度范围内 [0, getSize()] 添加元素
     *
     * @param index 索引位置
     * @param e     元素
     */
    public void add(int index, E e) {

        if (index < 0 || index > getSize()) {
            throw new IllegalArgumentException("index位置越界");
        }

        /*
         * 找到要插入位置的前一个节点 preNode
         * node = perNode.next
         * preNode.next = node
         */
        Node preNode = dummyHead;

        for (int i = 0; i < index; ++i) {
            preNode = preNode.next;
        }

        Node node = new Node(e);
        node.next = preNode.next;
        preNode.next = node;

        ++size;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(getSize(), e);
    }


    /**
     * 根据index索引获取元素, 不常用, 作练习用
     *
     * @param index
     * @return
     */
    public E get(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Illegal index");
        }

        Node node = dummyHead.next;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }

        return node.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 描述：把索引 index 的元素设为 e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Illegal index");
        }

        Node node = dummyHead.next;
        for (int i = 0; i < index; ++i) {
            node = node.next;
        }

        node.e = e;
    }

    /**
     * 描述：链表是否包含e
     *
     * @param e
     * @return boolean
     */
    public boolean contains(E e) {

        Node node = dummyHead.next;

        while (node != null) {

            if (node.e.equals(e)) {
                return true;
            }

            node = node.next;
        }

        return false;
    }

    /**
     * 描述：删除索引 index 处的元素
     *
     * @param index
     * @return E
     */
    public E remove(int index) {

        if (index < 0 || index >= getSize()) {
            throw new IllegalArgumentException("Illegal index");
        }

        /*
         * 找到要删除元素的前一个节点
         */
        Node preNode = dummyHead;
        for (int i = 0; i < index; ++i) {
            preNode = preNode.next;
        }

        /*
         * 此时 curNode 指向要删除的节点
         */
        Node curNode = preNode.next;
        preNode.next = curNode.next;
        curNode.next = null;

        /*
         * 一定不要忘了把 size 减 1
         */
        --size;

        return curNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {

        /*
         * 使用两个节点更方便理解
         * 1.preNode 指向当前节点的前一个节点
         * 2.curNode 指向当前节点
         */
        Node preNode = dummyHead;
        Node curNode = preNode.next;

        while (curNode != null) {

            if (curNode.e.equals(e)) {

                preNode.next = curNode.next;
                curNode.next = null;
                //一定要把 size 减 1
                --size;
                break;
            }

            preNode = curNode;
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        Node node = dummyHead.next;

        while (node != null) {
            stringBuilder.append(node).append(" -> ");
            node = node.next;
        }

        stringBuilder.append("NULL]");
        return stringBuilder.toString();
    }
}
