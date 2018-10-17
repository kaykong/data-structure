package top.kongk.unit07.setandmap.set;

import top.kongk.unit06.binarysearchtree.BinarySearchTree;

/**
 * 描述：
 *
 * @author kk
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> binarySearchTree;

    public BinarySearchTreeSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public void add(E e) {

        binarySearchTree.add(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }
}
