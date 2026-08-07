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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxPath;
    }

    public int solve(TreeNode root){
        if(root == null) return 0;
        int L = Math.max(0, solve(root.left));
        int R = Math.max(0, solve(root.right));

        maxPath = Math.max(maxPath, L+R+root.val);
        return root.val + Math.max(L, R);
    }
}
