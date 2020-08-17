package leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class _110_Æ½ºâ¶þ²æÊ÷ {

	public static void main(String[] args) {

	}
	
	class Info {
		int height;
		boolean isBalanced;
		
		public Info(int h, boolean isB) {
			height = h;
			isBalanced = isB;
		}
	}

	public boolean isBalanced(TreeNode root) {
		return process(root).isBalanced;
	}
	
	public Info process(TreeNode root) {

		if(root == null) {
			return new Info(0, true);
		}
		
		Info left = process(root.left);
		Info right = process(root.right); 
		
		if((int)Math.abs(left.height - right.height) <= 1) {
			return new Info(1+Math.max(left.height, right.height), left.isBalanced && right.isBalanced);
		}
		
		return new Info(1+Math.max(left.height, right.height), false);
	}

}
