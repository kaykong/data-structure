package top.kongk.unit04.linkedlist;

/**
 * 描述：测试
 *
 * @author kk
 */
public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();

        System.out.println("在首部添加数字 1-3");
        for (int i = 1; i < 4; ++i) {

            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
        System.out.println();


        System.out.println("在尾部添加数字 4-7");
        for (int i = 4; i < 8; ++i) {

            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        System.out.println();


        System.out.println("删除索引为 1 的元素: " + linkedList.get(1));
        linkedList.remove(1);
        System.out.println(linkedList);


        System.out.println("删除值为 7 的元素: ");
        linkedList.removeElement(7);
        System.out.println(linkedList);
        System.out.println();


        System.out.println("清空链表");
        int i = 0;
        while (!linkedList.isEmpty()) {

            if (i % 2 == 0) {
                System.out.println("删除头结点");
                linkedList.removeFirst();
                System.out.println(linkedList);
            } else {
                System.out.println("删除尾结点");
                linkedList.removeLast();
                System.out.println(linkedList);
            }

            ++i;
        }
    }

    /*
    输出:

    在首部添加数字 1-3
    [1 -> NULL]
    [2 -> 1 -> NULL]
    [3 -> 2 -> 1 -> NULL]

    在尾部添加数字 4-7
    [3 -> 2 -> 1 -> 4 -> NULL]
    [3 -> 2 -> 1 -> 4 -> 5 -> NULL]
    [3 -> 2 -> 1 -> 4 -> 5 -> 6 -> NULL]
    [3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7 -> NULL]

    删除索引为 1 的元素: 2
    [3 -> 1 -> 4 -> 5 -> 6 -> 7 -> NULL]
    删除值为 7 的元素:
    [3 -> 1 -> 4 -> 5 -> 6 -> NULL]

    清空链表
    删除头结点
    [1 -> 4 -> 5 -> 6 -> NULL]
    删除尾结点
    [1 -> 4 -> 5 -> NULL]
    删除头结点
    [4 -> 5 -> NULL]
    删除尾结点
    [4 -> NULL]
    删除头结点
    [NULL]

     */

}
