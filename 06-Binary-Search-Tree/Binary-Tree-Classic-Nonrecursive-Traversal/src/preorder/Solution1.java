package preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youyusong
 * @date 2018/9/20
 */
public class Solution1 {

    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (! stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);

            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }

        return res;
    }

}
