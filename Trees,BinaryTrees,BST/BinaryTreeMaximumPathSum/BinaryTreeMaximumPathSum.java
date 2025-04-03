
// Definition for a binary tree node.
// public class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
// }
 
class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root  == null ) return 0;
        int res = dfs(root);
        return maxValue;
    }

    public int dfs(TreeNode root){
        if(root == null) return 0;

            int longestPathLeft = Math.max(0, dfs(root.left));
            int longestPathRight = Math.max(0, dfs(root.right));
            maxValue= Math.max(maxValue,longestPathLeft+longestPathRight+root.val);
            int longestPath = Math.max(root.val+longestPathLeft,root.val+longestPathRight); 

        return longestPath;
         
    }
}