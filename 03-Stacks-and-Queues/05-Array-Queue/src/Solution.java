import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 102
 * 用队列实现二叉树的层序遍历
 * @author youyusong
 * @date 2018/9/18
 */
public class Solution {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayQueue<Pair<TreeNode, Integer>> queue = new ArrayQueue<>();
        queue.enqueue(new Pair<>(root, 0));

        while (! queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.dequeue();
            TreeNode node = pair.getKey();
            int level = pair.getValue();

            if (level == res.size()) {
                res.add(new ArrayList<>());
            }

            res.get(level).add(node.val);
            if (node.left != null) {
                queue.enqueue(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.enqueue(new Pair<>(node.right, level + 1));
            }
        }
        return res;
    }
}
