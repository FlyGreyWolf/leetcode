package leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
  
示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindromic-substrings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author FlyGreyWolf
 * @since 2020-08-19
 *
 */
public class _647_回文子串 {

	
	public static void main(String[] args) {
		countSubstrings("aaa");
	}
	
	public static int countSubstrings(String s) {
	
		char[] arr = s.toCharArray();
		
		int res = 0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				
				if(check(arr, i, j)) {
					res++;
				}
			}
		}
		return res;
	}
	
	public static boolean check(char[] arr, int start, int end) {
		
		while(start < end) {
			if(arr[start] != arr[end]) {
				return false;
			}
			start++;
			end--;
		}
		
		return true;
	}
	
}
