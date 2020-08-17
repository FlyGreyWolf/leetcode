package leetcode;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/**
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
示例 1:
给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/balanced-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 
 * @author FlyGreyWolf
 * @since 2020-08-17
 *
 */
public class _110_平衡二叉树 {

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
