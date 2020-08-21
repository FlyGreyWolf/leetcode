package leetcode;

import java.util.LinkedList;

public class _111_二叉树的最小深度 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    public int minDepth(TreeNode root) {
    	
    	if(root == null) {
    		return 0;
    	}
    	LinkedList<TreeNode> queue = new LinkedList<>();
    	
    	queue.add(root);
    	
    	int depth = 0;
    	int size = 1;
    	
    	while(!queue.isEmpty()) {
    		
    		TreeNode node = queue.poll();
    		
    		size--;
    		
    		if(node.left == null && node.right == null) {
    			depth++;
    			break;
    		}
    		
    		if(node.left != null) {
    			queue.add(node.left);
    		}
    		
    		if(node.right != null) {
    			queue.add(node.right);
    		}
    		
    		
    		
    		if(size == 0) {
    			depth++;
    			size = queue.size();
    		}
    		
    		
    	}
    	
    	return depth;
    }
}
