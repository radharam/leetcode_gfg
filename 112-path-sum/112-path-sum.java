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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        
        return checkPathSum(root, targetSum, 0);
    }
    
    public boolean checkPathSum(TreeNode root, int targetSum, int pathSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null 
                        && targetSum == pathSum + root.val) {
            return true;
        } 
        
        return checkPathSum(root.left, targetSum, pathSum + root.val) ||
                checkPathSum(root.right, targetSum, pathSum + root.val);
    }
}