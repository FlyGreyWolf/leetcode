package leetcode;

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
