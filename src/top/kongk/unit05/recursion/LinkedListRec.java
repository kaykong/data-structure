package top.kongk.unit05.recursion;

import top.kongk.unit05.recursion.leetcode.leetcode203.ListNode;

/**
 * 描述：递归实现链表 增删改查
 *
 * @author kk
 */
public class LinkedListRec {

    public ListNode getHead() {
        return head;
    }

    private ListNode head;
    private int size;

    public LinkedListRec() {
    }

    public void add(int index, ListNode node) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("越界了");
        }

        /*
         * 设置一个前节点
         */
        ListNode preNode = new ListNode(-1);
        preNode.next = head;
        addRec(index, node, 0, preNode);

        /*
         * 把head 指向原来的前节点.next
         */
        head = preNode.next;
        size++;
    }

    private void addRec(int index, ListNode node, int depth, ListNode preNode) {

        if (index == depth) {
            node.next = preNode.next;
            preNode.next = node;
            return;
        }

        addRec(index, node, depth + 1, preNode.next);
    }

    public static void main(String[] args) {

        LinkedListRec linkedListRec = new LinkedListRec();

        for (int i = 0; i < 5; ++i) {
            linkedListRec.add(i, new ListNode(i + 1));
            System.out.println(linkedListRec.getHead());
        }
        System.out.println();

        System.out.println("在索引2处添加666");
        linkedListRec.add(2, new ListNode(666));
        System.out.println(linkedListRec.getHead());
    }

    /*
    输出：

     ListNode : [1 -> Null]
     ListNode : [1 -> 2 -> Null]
     ListNode : [1 -> 2 -> 3 -> Null]
     ListNode : [1 -> 2 -> 3 -> 4 -> Null]
     ListNode : [1 -> 2 -> 3 -> 4 -> 5 -> Null]

     在索引2处添加666
     ListNode : [1 -> 2 -> 666 -> 3 -> 4 -> 5 -> Null]

     */

}
