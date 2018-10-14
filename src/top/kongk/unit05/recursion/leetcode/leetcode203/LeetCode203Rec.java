package top.kongk.unit05.recursion.leetcode.leetcode203;

/**
 * 描述：递归调用 删除链表中等于给定值 val 的所有节点。
 * https://leetcode-cn.com/problems/remove-linked-list-elements/description/
 *
 * @author kk
 */
public class LeetCode203Rec {

    static class Solution {

        public ListNode removeElements(ListNode head, int val) {

            if (head == null) {
                return null;
            }
            /*
             * 传进去 head.next 才能使问题规模变小
             *
             * 还要假设 removeElements 把 head 后的节点正确处理完毕了
             */
            head.next = removeElements(head.next, val);

            /*
             * 那么接下来开始处理 head
             */
            if (head.val == val) {
                return head.next;
            } else {
                return head;
            }
        }

        public ListNode removeElements(ListNode head, int val, int depth) {

            if (head == null) {
                System.out.println(drawDepth(depth) + "当前节点：" + head);
                return null;
            }

            System.out.println(drawDepth(depth) + "当前节点：" + head);

            head.next = removeElements(head.next, val, ++depth);

            System.out.println(drawDepth(depth - 1) + "返回节点：" + head.next);

            ListNode resultNode;
            /*
             * 那么接下来开始处理 head
             */
            if (head.val == val) {
                resultNode = head.next;
            } else {
                resultNode = head;
            }

            System.out.println(drawDepth(depth - 1) + "最终节点：" + resultNode);
            return resultNode;
        }

        private String drawDepth(int depth) {

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < depth; ++i) {
                stringBuilder.append("----");
            }

            stringBuilder.append("第").append(depth).append("层 ");
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {

        //int[] nums = {6, 1, 2, 6, 3, 4, 5, 6, 6};
        int[] nums = {2, 6, 3};

        int val = 6;

        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println("移除" + val + "之后");
        System.out.println();
        Solution solution = new Solution();

        //ListNode head2 = solution.removeElements(head, val);

        //输出演示
        ListNode head2 = solution.removeElements(head, val, 1);

        System.out.println();
        System.out.println(head2);

        /*
        输出：

         ListNode : [2 -> 6 -> 3 -> Null]
         移除6之后

         ----第1层 当前节点：ListNode : [2 -> 6 -> 3 -> Null]
         --------第2层 当前节点：ListNode : [6 -> 3 -> Null]
         ------------第3层 当前节点：ListNode : [3 -> Null]
         ----------------第4层 当前节点：null
         ------------第3层 返回节点：null
         ------------第3层 最终节点：ListNode : [3 -> Null]
         --------第2层 返回节点：ListNode : [3 -> Null]
         --------第2层 最终节点：ListNode : [3 -> Null]
         ----第1层 返回节点：ListNode : [3 -> Null]
         ----第1层 最终节点：ListNode : [2 -> 3 -> Null]

         ListNode : [2 -> 3 -> Null]
         */

    }
}
