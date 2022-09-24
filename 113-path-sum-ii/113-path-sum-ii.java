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
    List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsToFindTarget(root,targetSum,new ArrayList<>());
        return ans;
    }
    
    private void dfsToFindTarget(TreeNode root, int target,List<Integer> ls){
        if(root == null){
            return;
        }
        ls.add(root.val);
        
        if(target - root.val == 0 && root.left==null && root.right==null){
            
            if(!ls.isEmpty()) ans.add(new ArrayList<>(ls));
        
        }else{
            dfsToFindTarget(root.left,target-root.val,ls);
            dfsToFindTarget(root.right,target-root.val,ls);
        }
        ls.remove(ls.size()-1);
    }
}