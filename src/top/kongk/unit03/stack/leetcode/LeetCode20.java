package top.kongk.unit03.stack.leetcode;

/**
 * 描述：LeetCode 20 号题目 括号是否匹配
 *
 * @author kk
 */
public class LeetCode20 {

    public boolean isValid(String s) {

        if (s == null) {
            return true;
        }

        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (int i = 0; i < s.length(); ++i) {

            switch (s.charAt(i)) {

                //如果是左括号, 就push进栈中
                case '(':
                case '{':
                case '[':
                    stack.push(s.charAt(i));
                    break;

                //如果是右括号, 就取出栈顶的左括号, 对比是否匹配
                case ')':
                    if (stack.empty() || !stack.pop().equals('(')) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty() || !stack.pop().equals('{')) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty() || !stack.pop().equals('[')) {
                        return false;
                    }
                    break;

                //其他字符跳过
                default:
                    break;
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {

        /**
         * 测试一下
         */
        LeetCode20 solution = new LeetCode20();

        boolean check = solution.isValid("asd[]{f");

        System.out.println(check);
    }
}
