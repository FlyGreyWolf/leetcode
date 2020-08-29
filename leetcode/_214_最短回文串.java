package leetcode;

/**
 * 214. 最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 *
 * 示例 1:
 *
 * 输入: "aacecaaa"
 * 输出: "aaacecaaa"
 * 示例 2:
 *
 * 输入: "abcd"
 * 输出: "dcbabcd"
 *
 *
 * @author FlyGreyWolf
 * @since 2020-08-29
 */
public class _214_最短回文串 {

    public String shortestPalindrome(String s) {
        char[] sarr = s.toCharArray();
        int index = 0;
        for(int i=sarr.length-1;i>=0;i--) {
            if(checkHui(sarr, 0, i)) {
                index = i;
                break;
            }
        }
        String res = s;
        for(int i=index+1;i<sarr.length;i++) {
            res = sarr[i] + res;
        }
        return res;

    }

    public boolean checkHui(char[] arr, int start, int end) {
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
