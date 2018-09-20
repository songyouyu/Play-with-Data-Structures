package inorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youyusong
 * @date 2018/9/20
 */
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){

            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

}
