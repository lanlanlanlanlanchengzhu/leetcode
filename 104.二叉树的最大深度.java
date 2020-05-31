/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {return 0;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<TreeNode> set = new HashSet();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = queue.poll();
            set.add(currNode);
            if (queue.isEmpty() && set.size() > 0) {
                depth++;
                set.forEach((tmpNode) -> {
                    if (tmpNode.left != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.right);
                    }
                });
                set.clear();
            }
        }
        return depth;
    }
}
// @lc code=end

