package top.kongk.unit07.setandmap.map;

/**
 * 描述：基于二分搜索树实现的map
 *
 * @author kk
 */
public class BinarySearchTreeMap<K extends Comparable<K>, V> implements Map<K, V>{

    private class Node {

        public K key;

        public V value;

        public Node left;

        public Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;

    /**
     * 节点个数
     */
    private int size;

    public BinarySearchTreeMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {

        root = put(root, key, value);

    }

    /**
     * 向node中添加key-value, 返回node作为节点
     *
     * @param node
     * @param key
     * @param value
     * @return top.kongk.unit07.setandmap.map.BinarySearchTreeMap<K,V>.Node
     */
    private Node put(Node node, K key, V value) {

        /*
         * 递归的最小情况: map中不存在该key
         */
        if (node == null) {

            Node putNode = new Node(key, value);

            ++size;

            return putNode;
        }

        /*
         * 其他情况
         */
        if (node.key.compareTo(key) > 0) {

            //当前节点的key比该key要大, 那就把key-value放入node的左边
            node.left = put(node.left, key, value);

        } else if (node.key.compareTo(key) < 0) {

            //当前节点的key比该key要小, 那就把key-value放入node的右边
            node.right = put(node.right, key, value);

        } else {

            //当前节点的key和key相等
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {

        root = remove(root, key);

        return null;
    }

    /**
     * 移除以node为根节点的二分搜索树中节点值为key的节点
     *
     * @param node
     * @param key
     * @return top.kongk.unit07.setandmap.map.BinarySearchTreeMap<K,V>.Node
     */
    private Node remove(Node node, K key) {

        if (node == null) {
            return null;
        }


        if (node.key.compareTo(key) > 0) {

            //node 大于 key
            node.left = remove(node.left, key);
            return node;

        } else if (node.key.compareTo(key) < 0) {

            //node 大于 key
            node.left = remove(node.left, key);
            return node;

        } else {

            /*
             * node 等于 key, 此时需要删除此 node
             * 基于BST实现的map, 移除元素有3种情况
             *
             * 1.要移除的节点没有左孩子
             * 2.要移除的节点没有右孩子
             * 3.要移除的节点左孩子,右孩子都有
             */

            //1.要移除的节点没有左孩子
            if (node.left == null) {

                Node rightNode = node.right;
                node.right = null;
                --size;
                return rightNode;
            }

            //2.要移除的节点没有右孩子
            if (node.right == null) {

                Node leftNode = node.left;
                node.left = null;
                --size;
                return leftNode;
            }

            /*
             * 3.要移除的节点左孩子,右孩子都有, 此时有两种选择
             *
             *  3.1 找到左孩子的最大值并替换为node的key, 移除左孩子的最大值节点
             *  3.2 找到右孩子的最小值并替换为node的key, 移除右孩子的最小值节点
             */

            node.value = getMinimum(node.right);

            node.right = removeMin(node.right);

            return node;
        }
    }

    /**
     * 移除以node为根的二分搜索树的最小值节点
     *
     * @param node
     * @return top.kongk.unit07.setandmap.map.BinarySearchTreeMap<K,V>.Node
     */
    private Node removeMin(Node node) {

        if (node == null) {
            return null;
        }

        /*
         * 如果此节点是最左边的节点了, 那么就把他的右节点返回
         */
        if (node.left == null) {

            //右节点是否是null都无所谓
            Node rightNode = node.right;
            node.right = null;
            --size;

            return rightNode;
        }

        node.left = removeMin(node.left);

        return node;
    }

    /**
     * 获取以node为根的二分搜索树的最小值
     *
     * @param node
     * @return V
     */
    private V getMinimum(Node node) {

        if (node == null) {
            return null;
        }

        if (node.left != null) {

            //node还有左孩子
            getMinimum(node.left);
        }

        return node.value;
    }

    @Override
    public boolean contains(K key) {

        Node node = getNode(root, key);
        return node != null;
    }

    /**
     * 获取以node为根的二分搜索树中是否包含值为key的节点
     *
     * @param node
     * @param key
     * @return top.kongk.unit07.setandmap.map.BinarySearchTreeMap<K,V>.Node
     */
    private Node getNode(Node node, K key) {

        if (node == null) {
            return null;
        }

        if (node.key.compareTo(key) > 0) {

            //当前节点的值比key大, 那么就去node的左孩子去找
            return getNode(node.left, key);

        } else if (node.key.compareTo(key) < 0) {

            //当前节点的值比key小, 那么就去node的右孩子去找
            return getNode(node.right, key);

        }

        //当前节点的值和key相等
        return node;
    }



    @Override
    public V get(K key) {

        Node node = getNode(root, key);

        return node == null ? null : node.value;
    }
}
