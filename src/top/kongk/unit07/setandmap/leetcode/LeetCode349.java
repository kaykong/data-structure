package top.kongk.unit07.setandmap.leetcode;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 描述：两个数组的交集
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 *
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * @author kk
 */
public class LeetCode349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        /*
         * 遍历nums1, 然后放进set里
         * new 一个动态数组
         * 遍历nums2, 判断数组元素是否在set中, 如果在set中, 就删除set中的该元素, 并把该元素放入动态数组中
         * 返回动态数组
         */

        Set<Integer> set = new TreeSet();

        for (int i : nums1) {
            set.add(i);
        }

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i : nums2) {
            if (set.remove(i)) {
                integers.add(i);
            }
        }

        int[] nums = new int[integers.size()];

        for (int i = 0; i < integers.size(); ++i) {

            nums[i] = integers.get(i);
        }
        return nums;

    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ints = new LeetCode349().intersection(nums1, nums2);

        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}

















