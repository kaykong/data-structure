package top.kongk.unit06.binarysearchtree;


import java.util.Random;

/**
 * 描述：测试BST
 *
 * @author kk
 */
public class BinarySearchTreeTest {


    private static double testAdd(BinarySearchTree<Integer> bst, int count) {

        long time1 = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; ++i) {
            bst.add(random.nextInt(Integer.MAX_VALUE));
        }

        long time2 = System.nanoTime();

        return (time2 - time1) / 1000000000.0;
    }

    public static void main(String[] args) {

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int num : nums) {
            bst.add(num);
        }

        System.out.println(bst.contains(1));

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////

        System.out.println("前序遍历:");
        bst.preOrder();

        System.out.println("中序遍历:");
        bst.inOrder();

        System.out.println("后序遍历:");
        bst.postOrder();

        System.out.println("非递归前序遍历:");
        bst.preOrderNonRec();

        System.out.println("层序遍历:");
        bst.levelOrder();

        System.out.print("最小值: ");
        System.out.println(bst.minimum());

        System.out.print("最大值: ");
        System.out.println(bst.maximum());

        bst.minimumAndMaximumNonRec();

        System.out.println("移除最小值:");
        bst.removeMin();
        bst.levelOrder();

        System.out.println("移除最大值:");
        bst.removeMax();
        bst.levelOrder();

        System.out.println("移除6:");
        bst.remove(6);
        bst.levelOrder();

        System.out.println("移除8:");
        bst.remove(8);
        bst.levelOrder();

        System.out.println();


        BinarySearchTree<Integer> bst2 = new BinarySearchTree();
        int count = 100000;

        System.out.println("插入" + count + "个随机数...");

        double time = testAdd(bst2, count);

        System.out.println("用时: " + time + "s");
        System.out.println("此时二分搜索树的大小: " + bst2.size());
    }

    /*
    输出:

     false
     前序遍历:
     5 3 2 4 6 8
     中序遍历:
     2 3 4 5 6 8
     后序遍历:
     2 4 3 8 6 5
     非递归前序遍历:
     5 3 2 4 6 8
     层序遍历:
     5 3 6 2 4 8
     最小值: 2
     最大值: 8
     非递归获取二分搜索树的最大值和最小值
     最小值: 2
     最大值: 8
     移除最小值:
     5 3 6 4 8
     移除最大值:
     5 3 6 4
     移除6:
     5 3 4
     移除8:
     5 3 4

     插入100000个随机数...
     用时: 0.071242476s
     此时二分搜索树的大小: 99998

     */

}
