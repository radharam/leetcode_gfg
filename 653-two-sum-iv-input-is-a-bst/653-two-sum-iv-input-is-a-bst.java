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
    
    List<Integer> list = new ArrayList<>();
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
    public boolean search(List<Integer> list ,int k){
        int start=0;
        int end=list.size()-1;
        while(start<end){
            if(k>list.get(start)+ list.get(end)){
                start++;
            }
            else if(k<list.get(start)+ list.get(end)){
                end--;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        inOrder(root);        
        return search(list , k);
    }
}