package top.kongk.unit04.linkedlist;

/**
 * 描述：对链表栈进行测试
 *
 * @author kk
 */
public class LinkedListStackTest {

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        System.out.println("将数字 0-4 入栈");
        for(int i = 0 ; i < 5 ; i ++){

            stack.push(i);
            System.out.println(stack);
            System.out.println();
        }

        System.out.println("出栈: " + stack.peek());
        stack.pop();
        System.out.println(stack);
    }

}
