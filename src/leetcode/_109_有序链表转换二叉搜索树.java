package leetcode;

import java.util.ArrayList;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例:
 * 
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 
 * 0 / \ -3 9 / / -10 5
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author FlyGreyWolf
 * @since 2020-08-18
 *
 */
public class _109_有序链表转换二叉搜索树 {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arrList = new ArrayList<>();
        while(head != null) {
        	arrList.add(head.val);
        	head = head.next;
        } 
        
        return process(arrList, 0, arrList.size()-1);
        
        
    }
    
    public TreeNode process(ArrayList<Integer> arrList, int left, int right) {
    	
    	if(left > right) {
    		return null;
    	}
    	
    	int mid = left + ((right - left) >> 1);
    	
    	TreeNode t = new TreeNode(arrList.get(mid));
    	
    	t.left = process(arrList, left, mid-1);
    	t.right = process(arrList, mid+1, right);
    	
    	
    	return t;
    }

}


