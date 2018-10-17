package top.kongk.unit07.setandmap.leetcode;

import java.util.*;

/**
 * 描述： 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author kk
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        /*
         * 遍历nums1, 然后放进 TreeMap<Integer, Integer>里 (第一个放元素, 第二个放元素个数)
         * new 一个动态数组
         * 遍历nums2, 判断数组元素是否在 TreeMap 中,
         * 如果在 TreeMap 中, 就将TreeMap中该元素的value减1, 减到0就移除该元素. 并把该元素放入动态数组中
         * 返回动态数组
         */

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : nums1) {

            //获取key对应的value, 没有该key返回的是null
            Integer value = map.get(i);

            //如果是null, 就赋值为1, 否则赋值为 integer + 1
            value = value == null ? 1 : (value + 1);

            map.put(i, value);
        }

        ArrayList<Integer> integers = new ArrayList<>();

        for (int i : nums2) {

            //在map中查找该元素, 查不到返回null
            Integer value = map.get(i);

            if (value != null) {

                //如果查到了, 就把元素添加到动态数组中
                integers.add(i);

                //更新map这种该元素的value值
                if (value == 1) {
                    map.remove(i);
                } else {
                    map.put(i, value - 1);
                }
            }
        }

        int[] nums = new int[integers.size()];

        for (int i = 0; i < integers.size(); ++i) {

            nums[i] = integers.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        /*
          给定两个数组，编写一个函数来计算它们的交集。

            示例 1:
            输入: nums1 = [1,2,2,1], nums2 = [2,2]
            输出: [2,2]

            示例 2:
            输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
            输出: [4,9]

            说明：
            输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
            我们可以不考虑输出结果的顺序。
         */

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] ints = new LeetCode350().intersect(nums1, nums2);

        for (int i : ints) {
            System.out.print(i + " ");
        }

    }

}
