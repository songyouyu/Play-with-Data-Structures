import java.util.Stack;

/**
 * leetcode 括号匹配问题
 * @author youyusong
 * @date 2018/9/18
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character ret = stack.pop();
                if (c == ')' && ret != '(' ) {
                    return false;
                }
                if (c == ']' && ret != '[') {
                    return false;
                }
                if (c == '}' && ret != '{') {
                    return false;
                }
            }
        }
        // 匹配完成后, 确保栈中不再有元素
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([)]"));
    }

}
