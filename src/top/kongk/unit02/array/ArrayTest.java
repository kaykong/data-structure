package top.kongk.unit02.array;

/**
 * 描述：测试动态数组
 *
 * @author kk
 */
public class ArrayTest {

    public static void main(String[] args) {

        Array<Integer> array = new Array<>();

        System.out.println("增加数字 0-9");
        for (int i = 0; i < 10; ++i) {

            array.addLast(i);
            System.out.println(array);
        }
        System.out.println();

        System.out.println("在首部添加666");
        array.addFirst(666);
        System.out.println(array);
        System.out.println();

        System.out.println("在索引为2处添加999");
        array.add(2, 999);
        System.out.println(array);
        System.out.println();

        System.out.println("删除999");
        array.removeElement(999);
        System.out.println(array);
        System.out.println();

        System.out.println("删除数字 0-7");
        for (int i = 0; i < 8; ++i) {
            array.removeElement(i);
            System.out.println(array);
        }

        System.out.println("删除第一个");
        array.removeFirst();
        System.out.println(array);
    }

    /*
        输出结果:

        增加数字 0-9
        Arrays: size = 1, capacity = 10
                [0]
        Arrays: size = 2, capacity = 10
                [0, 1]
        Arrays: size = 3, capacity = 10
                [0, 1, 2]
        Arrays: size = 4, capacity = 10
                [0, 1, 2, 3]
        Arrays: size = 5, capacity = 10
                [0, 1, 2, 3, 4]
        Arrays: size = 6, capacity = 10
                [0, 1, 2, 3, 4, 5]
        Arrays: size = 7, capacity = 10
                [0, 1, 2, 3, 4, 5, 6]
        Arrays: size = 8, capacity = 10
                [0, 1, 2, 3, 4, 5, 6, 7]
        Arrays: size = 9, capacity = 10
                [0, 1, 2, 3, 4, 5, 6, 7, 8]
        Arrays: size = 10, capacity = 10
                [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        在首部添加666
        Arrays: size = 11, capacity = 20
                [666, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        在索引为2处添加999
        Arrays: size = 12, capacity = 20
                [666, 0, 999, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        删除999
        Arrays: size = 11, capacity = 20
                [666, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        删除数字 0-7
        Arrays: size = 10, capacity = 20
                [666, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        Arrays: size = 9, capacity = 20
                [666, 2, 3, 4, 5, 6, 7, 8, 9]
        Arrays: size = 8, capacity = 20
                [666, 3, 4, 5, 6, 7, 8, 9]
        Arrays: size = 7, capacity = 20
                [666, 4, 5, 6, 7, 8, 9]
        Arrays: size = 6, capacity = 20
                [666, 5, 6, 7, 8, 9]
        Arrays: size = 5, capacity = 10
                [666, 6, 7, 8, 9]
        Arrays: size = 4, capacity = 10
                [666, 7, 8, 9]
        Arrays: size = 3, capacity = 10
                [666, 8, 9]
        删除第一个
        Arrays: size = 2, capacity = 5
                [8, 9]

        Process finished with exit code 0*/

}
