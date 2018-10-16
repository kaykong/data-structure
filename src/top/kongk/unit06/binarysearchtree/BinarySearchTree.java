package top.kongk.unit06.binarysearchtree;

import top.kongk.unit04.linkedlist.LinkedListQueueWithTail;
import top.kongk.unit04.linkedlist.LinkedListStack;

/**
 * 描述：二叉搜索树(Binary Search Tree)，二分搜索树，二分排序树(Binary Sort Tree)
 * 统称：BST
 *
 * @author kk
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private class Node {

        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在BST中插入不为null的元素
     *
     * @param e
     * @return void
     */
    public void add(E e) {

        /*
         * 插入的元素不能为null
         */
        if (e == null) {
            return;
        }
        root = add(root, e);
    }

    /**
     * 描述：递归调用，插入元素e, 返回该节点被插入后的新节点
     *
     * @param node
     * @param e
     * @return Node
     */
    private Node add(Node node, E e) {

        /*
         * 递归最小的情况
         */
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        /*
         * 其他情况下
         * 1.要把问题规模逐渐变小(调用的时候传入 node.right node.left)
         * 2.忘记你在递归, 假设调用的是一个平常的方法, 而且它会成功处理
         */
        if (node.e.compareTo(e) < 0) {

            // 当前节点 小于 e
            node.right = add(node.right, e);

        } else if (node.e.compareTo(e) > 0) {

            // 当前节点 大于 e
            node.left = add(node.left, e);
        }

        /*
         * 也是递归最小的情况: 当前节点等于 e
         */
        return node;
    }

    public boolean contains(E e) {

        if (e == null) {
            return false;
        }

        return contains(root, e);
    }

    private boolean contains(Node node, E e) {

        /*
         * 递归的最小情况 false
         */
        if (node == null) {
            return false;
        }

        /*
         * 递归的最小情况 true
         *
         * 这个最小情况放在了下面的 if-else 中
         */

        if (node.e.compareTo(e) < 0) {

            //当前节点小于 e, 那么就传递node的右孩子
            return contains(node.right, e);

        } else if (node.e.compareTo(e) > 0) {

            //当前节点大于 e, 那么就传递node的左孩子
            return contains(node.left, e);

        } else {

            //递归的最小情况 当前节点等于 e
            return true;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder() {

        preOrder(root);
        System.out.println();
    }

    /**
     * 递归实现前序遍历
     * <p>
     * 遍历顺序: 根节点, 左孩子, 右孩子
     *
     * @param node
     * @return void
     */
    private void preOrder(Node node) {

        /*
         * 递归的最小情况
         */
        if (node == null) {
            return;
        }

        //前序遍历
        System.out.print(node + " ");

        /*
         * 其他情况:
         *  1.每次调用都让问题规模变小
         *  2.忘记你在递归, 而是在调用一个平常的, 能正常处理的你需求的方法
         */
        if (node.left != null) {
            preOrder(node.left);
        }
        if (node.right != null) {
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder() {

        inOrder(root);
        System.out.println();
    }

    /**
     * 递归实现中序遍历
     * <p>
     * 遍历顺序: 左孩子, 根节点, 右孩子
     *
     * @param node
     * @return void
     */
    private void inOrder(Node node) {

        /*
         * 递归的最小情况
         */
        if (node == null) {
            return;
        }

        /*
         * 其他情况:
         *  1.每次调用都让问题规模变小
         *  2.忘记你在递归, 而是在调用一个平常的, 能正常处理的你需求的方法
         */
        if (node.left != null) {
            inOrder(node.left);
        }

        //中序遍历
        System.out.print(node + " ");

        if (node.right != null) {
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder() {

        postOrder(root);
        System.out.println();
    }

    /**
     * 递归实现后序遍历
     * <p>
     * 遍历顺序: 左孩子, 右孩子, 根节点
     *
     * @param node
     * @return void
     */
    private void postOrder(Node node) {

        /*
         * 递归的最小情况
         */
        if (node == null) {
            return;
        }

        /*
         * 其他情况:
         *  1.每次调用都让问题规模变小
         *  2.忘记你在递归, 而是在调用一个平常的, 能正常处理的你需求的方法
         */
        if (node.left != null) {
            postOrder(node.left);
        }

        if (node.right != null) {
            postOrder(node.right);
        }

        //后序遍历
        System.out.print(node + " ");
    }

    public void preOrderNonRec() {
        /*
         * 前序遍历, 要首先保留遍历的节点, 再保留它的左右孩子.
         * 而且, 遍历是从上向下进行的, 而输出的时候除了父节点外, 其他父节点的孩子节点的输出都是从下往上进行的.
         * 在这里采用栈 后进先出的结构刚好符合
         */


        /*
         * 逻辑:
         * root 入栈
         *
         * while (栈不是空的) {
         *     node 出栈
         *     node.right, node.left 入栈
         * }
         */

        if (root == null) {
            return;
        }
        LinkedListStack<Node> stack = new LinkedListStack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node node = stack.pop();
            System.out.print(node.e + " ");

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }

        System.out.println();
    }

    /**
     * 层序遍历
     */
    public void levelOrder() {

        /*
         * 层序遍历, 从上向下一层一层的输出
         * 在输出父节点后, 要把父节点的不为null的孩子节点从左向右保存起来
         * 然后取出上一层保存的节点作为父节点
         * 每一层都是这样
         *
         * 所以, 在这里使用队列来存储节点是很合适的, 先进先出
         */
        if (root == null) {
            return;
        }

        //带头尾指针的链表queue, 入队出队都是 O(1)
        LinkedListQueueWithTail<Node> queue = new LinkedListQueueWithTail<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {

            Node node = queue.dequeue();

            System.out.print(node.e + " ");

            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }

        System.out.println();
    }

    /**
     * 获取二分搜索树的最小元素
     *
     * @return E
     */
    public E minimum() {
        /*
         * 二分搜索树的最小元素在最靠近左边的节点
         */
        if (root == null) {
            throw new IllegalArgumentException("二分搜索树是空的");
        }

        return minimum(root);
    }

    private E minimum(Node node) {
        if (node.left == null) {
            return node.e;
        }

        return minimum(node.left);
    }

    /**
     * 获取二分搜索树的最大元素
     *
     * @return E
     */
    public E maximum() {
        /*
         * 二分搜索树的最小元素在最靠近左边的节点
         */
        if (root == null) {
            throw new IllegalArgumentException("二分搜索树是空的");
        }

        return maximum(root);
    }

    private E maximum(Node node) {
        if (node.right == null) {
            return node.e;
        }

        return maximum(node.right);
    }

    /**
     * 非递归获取二分搜索树的最大值和最小值
     *
     * @return E
     */
    public void minimumAndMaximumNonRec() {
        /*
         * 二分搜索树的最小元素在最靠近左边的节点
         */
        if (root == null) {
            throw new IllegalArgumentException("二分搜索树是空的");
        }

        System.out.println("非递归获取二分搜索树的最大值和最小值");

        /*
         * 非递归获取元素的 最小值
         */
        Node mini = root;

        while (mini.left != null) {
            mini = mini.left;
        }

        System.out.println("最小值: " + mini.e);

        /*
         * 非递归获取元素的 最大值
         */
        Node max = root;

        while (max.right != null) {
            max = max.right;
        }

        System.out.println("最大值: " + max.e);
    }

    /**
     * 获取以node为根的最小值所在的节点
     *
     * @param node
     * @return top.kongk.unit06.binarysearchtree.BinarySearchTree<E>.Node
     */
    private Node minimumNode(Node node) {

        if (node.left == null) {
            return node;
        }

        return minimumNode(node.left);
    }

    /**
     * 获取以node为根的最大值所在的节点
     *
     * @param node
     * @return top.kongk.unit06.binarysearchtree.BinarySearchTree<E>.Node
     */
    private Node maximumNode(Node node) {

        if (node.right == null) {
            return node;
        }

        return maximumNode(node.right);
    }

    /**
     * 从二分搜索树中删除最小值所在节点, 返回最小值
     *
     * @return E 最小值
     */
    public E removeMin() {

        //获取最小值
        E e = minimum();

        //递归删除最小值所在的节点
        root = removeMin(root);

        return e;
    }

    /**
     * 移除以node为根的二分搜索树的最小值节点, 并返回当前二分搜索树的根节点
     *
     * @param node
     * @return top.kongk.unit06.binarysearchtree.BinarySearchTree<E>.Node
     */
    private Node removeMin(Node node) {

        /*
         * 递归的最小情况: 如果node的左孩子是null, 那么就说明它是最小值所在的节点, 那么就把null返回(删除了它)
         */
        if (node.left == null) {

            --size;

            /*
             * 1.如果该node不是叶子, 它还有右孩子, 那么需要把右孩子返回
             * 2.如果该node为叶子, 那么直接返回null就可以
             */
            if (node.right != null) {
                return node.right;
            }

            return null;
        }

        /*
         * 假设removeMin(node.left)会 删除以node.left为根的二分搜索树的最小值所在的节点, 并返回根节点
         */
        node.left = removeMin(node.left);

        return node;
    }

    /**
     * 从二分搜索树中删除最大值所在节点, 返回最大值
     *
     * @return E 最小值
     */
    public E removeMax() {

        //获取最小值
        E e = maximum();

        //递归删除最小值所在的节点
        root = removeMax(root);

        return e;
    }

    /**
     * 移除以node为根的二分搜索树的最大值节点, 并返回当前二分搜索树的根节点
     *
     * @param node
     * @return top.kongk.unit06.binarysearchtree.BinarySearchTree<E>.Node
     */
    private Node removeMax(Node node) {

        /*
         * 递归的最小情况:
         * 如果node的左孩子是null, 那么就说明它是最小值所在的节点, 那么就把null返回(删除了它)
         */
        if (node.right == null) {

            --size;

            /*
             * 1.如果该node不是叶子, 它还有左孩子, 那么需要把左孩子返回
             * 2.如果该node为叶子, 那么直接返回null就可以
             */
            if (node.left != null) {
                return node.left;
            }

            return null;
        }

        /*
         * 假设removeMax(node.right)会 删除以node.right为根的二分搜索树的最大值所在的节点, 并返回根节点
         */
        node.right = removeMax(node.right);

        return node;
    }

    /**
     * 移除元素e 所在的节点
     * 如果该节点不存在, 就什么也不做
     *
     * @param e
     * @return void
     */
    public void remove(E e) {

        if (root == null) {
            throw new IllegalArgumentException("二分搜索树是空的");
        }

        root = remove(root, e);
    }


    /**
     * 移除以node为根的二分搜索树中值为e的节点, 返回当前二分搜索树的根节点
     * 如果该节点不存在, 就什么也不做
     *
     * @param node 根节点
     * @param e
     * @return top.kongk.unit06.binarysearchtree.BinarySearchTree<E>.Node
     */
    private Node remove(Node node, E e) {

        if (node == null) {
            return null;
        }

        if (node.e.compareTo(e) > 0) {

            node.left = remove(node.left, e);
            return node;

        } else if (node.e.compareTo(e) < 0) {

            node.right = remove(node.right, e);
            return node;

        } else {
            /*
             * 1. 此node左孩子为null
             */
            if (node.left == null) {

                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }

            /*
             * 2. 此node右孩子为null
             */
            if (node.right == null) {

                Node leftNode = node.left;
                node.left = null;
                return leftNode;
            }

            /*
             * 4. 此node左右孩子都有
             * 一种情况: 取node右孩子的最小值, 替代此node的值, 并把node右孩子的最小值节点移除
             * 一种情况: 取node左孩子的最大值, 替代此node的值, 并把node左孩子的最大值节点移除
             */
            node.e = maximum(node.right);
            removeMin(node.right);
            return node;
        }
    }
}
