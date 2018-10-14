package top.kongk.unit05.recursion;

/**
 * 描述：练习使用递归求数组和
 *
 * @author kk
 */
public class SumRec {

    /**
     * 描述：求数组和
     *
     * @param first 第一个坐标
     * @param array 数组
     * @return int
     */
    public int sumRec(int first, int[] array) {

        /*
         * 1.一定要有一个最小问题 return
         */
        if (array.length <= first) {
            return 0;
        }

        /*
         * 2.传递 first + 1, 让问题规模逐渐变小
         *
         * 3.假设 sumRec 已经计算好了array数组从 first + 1 以后的和
         */
        return array[first] + sumRec(first + 1, array);
    }

    public int sum(int[] array) {
        return sumRec(0, array);
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3};

        System.out.println(new SumRec().sum(array));
    }
}
