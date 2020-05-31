/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) {
            return res;
        }
        // 层次遍历
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        List<TreeNode> list = new LinkedList();
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            list.add(curr);
            if (queue.isEmpty() && list.size() > 0) {
                // 当前层次遍历完成
                list.forEach((tmpNode) -> {
                    if (tmpNode.left != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.left);
                    }
                    if (tmpNode.right != null) {
                        ((LinkedList<TreeNode>) queue).add(tmpNode.right);
                    }
                });
                List<Integer> oneRes = new ArrayList();
                if (flag) {
                    // 正序
                    while (!list.isEmpty()) {
                        oneRes.add(((LinkedList<TreeNode>) list).pollFirst().val);
                    }
                } else {
                    // 逆序
                    while (!list.isEmpty()) {
                        oneRes.add(((LinkedList<TreeNode>) list).pollLast().val);
                    }
                }
                res.add(oneRes);
                flag = !flag;
                list.clear();
            }
        }
        return res;
    }
}
// @lc code=end

