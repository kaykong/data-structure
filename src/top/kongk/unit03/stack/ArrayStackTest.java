package top.kongk.unit03.stack;

/**
 * 描述：测试 ArrayStack
 *
 * @author kk
 */
public class ArrayStackTest {

    public static void main(String[] args) {

        //给定初始容量为 5
        ArrayStack<Integer> arrayStack = new ArrayStack(5);

        System.out.println("将数字 0-6 入栈");
        for (int i = 0; i < 7; ++i) {

            arrayStack.push(i);
            System.out.println(arrayStack);
        }
        System.out.println();


        System.out.println("出栈3个元素");
        for (int i = 0; i < 3; ++i) {

            System.out.println("出栈: " + arrayStack.pop());

            System.out.println(arrayStack);
            System.out.println();
        }

        System.out.println("获取栈顶元素");
        System.out.println(arrayStack.peek());
    }

    /*
     输出:

     将数字 0-6 入栈
     ArrayStack : Top of stack [0] end of stack

     ArrayStack : Top of stack [1, 0] end of stack

     ArrayStack : Top of stack [2, 1, 0] end of stack

     ArrayStack : Top of stack [3, 2, 1, 0] end of stack

     ArrayStack : Top of stack [4, 3, 2, 1, 0] end of stack

     ArrayStack : Top of stack [5, 4, 3, 2, 1, 0] end of stack

     ArrayStack : Top of stack [6, 5, 4, 3, 2, 1, 0] end of stack

     出栈3个元素
     ArrayStack : Top of stack [5, 4, 3, 2, 1, 0] end of stack

     ArrayStack : Top of stack [4, 3, 2, 1, 0] end of stack

     ArrayStack : Top of stack [3, 2, 1, 0] end of stack

     获取栈顶元素
     3

     Process finished with exit code 0
     */
}
