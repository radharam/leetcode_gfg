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
    private int targetVal;
    private int targetDepth;
    private int curDepth = 1;
    
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.targetVal = val;
        this.targetDepth = depth;
        
        if(targetDepth == 1) {
            TreeNode newRoot = new TreeNode(targetVal);
            newRoot.left = root;
            
            return newRoot;
        }
        
        traverse(root);
        
        return root;
    }
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        curDepth++;
        
        if(curDepth == targetDepth) {
            TreeNode leftToInsert = new TreeNode(targetVal);
            TreeNode rightToInsert = new TreeNode(targetVal);
            
            leftToInsert.left = root.left;
            rightToInsert.right = root.right;
            
            root.left = leftToInsert;
            root.right = rightToInsert;
        }
        
        traverse(root.left);
        traverse(root.right);
        
        curDepth--;
    }
}