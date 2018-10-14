package top.kongk.unit05.recursion.leetcode.leetcode203;

/**
 * 描述：使用
 *
 * 203. Remove Linked List Elements
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 *
 * @author kk
 */
public class LeetCode203WithDummyHead {


    static class Solution {

        public ListNode removeElements(ListNode head, int val) {

            ListNode preNode = new ListNode(0);
            preNode.next = head;

            ListNode returnNode = preNode;

            while (preNode.next != null) {

                if (preNode.next.val == val) {
                    //需要删除此节点
                    ListNode delNode = preNode.next;
                    //preNode.next.next 最多为null，不会报空指针异常
                    preNode.next = preNode.next.next;
                    delNode.next = null;
                } else {
                    preNode = preNode.next;
                }
            }

            return returnNode.next;
        }
    }

    public static void main(String[] args) {

        int[] nums = {6, 1, 2, 6, 3, 4, 5, 6, 6};

        int val = 6;

        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println("移除" + val + "之后");
        Solution solution = new Solution();

        ListNode head2 = solution.removeElements(head, val);

        System.out.println(head2);

    }

}
