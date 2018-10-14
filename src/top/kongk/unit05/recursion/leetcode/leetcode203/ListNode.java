package top.kongk.unit05.recursion.leetcode.leetcode203;

/**
 * 描述：leetCode 203 用到的节点
 *
 * @author kk
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public ListNode(int[] array) {

        if (array.length == 0) {
            return;
        }

        val = array[0];
        ListNode curNode = this;

        for (int i = 1; i < array.length; ++i) {

            curNode.next = new ListNode(array[i]);
            curNode = curNode.next;
        }
    }

    @Override
    public String toString() {

        ListNode node = this;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ListNode : [");

        while (node != null) {
            stringBuilder.append(node.val).append(" -> ");
            node = node.next;
        }

        stringBuilder.append("Null]");

        return stringBuilder.toString();
    }
}
