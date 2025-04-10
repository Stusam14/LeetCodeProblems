/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

   
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null) return "X";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder serialized = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode popped = queue.remove();
            if(popped == null){
                serialized.append("X,");
                continue;
            }
            serialized.append(popped.val+",");
            queue.add(popped.left);
            queue.add(popped.right);

            
            
        }
        return serialized.toString();
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == null || data.equals("X")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] dataArr = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(dataArr[0]));
        queue.offer(root);

        int dataArrLength = dataArr.length;
        int i= 1;
        while(i < dataArrLength){

            TreeNode newNode = queue.poll();

            if(!dataArr[i].equals("X")){
                newNode.left =new  TreeNode(Integer.parseInt(dataArr[i]));
                queue.offer(newNode.left);
            }
            i++;

            if(i < dataArrLength && !dataArr[i].equals("X")){
                newNode.right =new  TreeNode(Integer.parseInt(dataArr[i]));
                queue.offer(newNode.right);
            }
            i++;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));