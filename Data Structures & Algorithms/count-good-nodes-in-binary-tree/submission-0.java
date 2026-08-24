/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar){
        if(node == null){
            return 0;
        }

        int goodNodeCount = 0;

        if(node.val >= maxSoFar){
            goodNodeCount = 1;
        }

        int currMax = Math.max(maxSoFar, node.val);

        goodNodeCount += dfs(node.left, currMax);
        goodNodeCount += dfs(node.right, currMax);

        return goodNodeCount;
    }
}
