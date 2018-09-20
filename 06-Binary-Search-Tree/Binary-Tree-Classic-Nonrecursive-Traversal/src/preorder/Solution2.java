package preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youyusong
 * @date 2018/9/20
 */
public class Solution2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            cur = cur.right;
        }

        return res;
    }

}
