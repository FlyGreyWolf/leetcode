package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 * @author FlyGreyWolf
 * @since 2020-8-26 11:42:22
 */
public class _17_电话号码的字母组合 {

	public List<String> letterCombinations(String digits) {
        List<String> arrList = new ArrayList<>();
       if(digits.equals("")){
           return arrList;
       }
       HashMap<Character,String> hm = new HashMap();


       hm.put('2',"abc");
       hm.put('3',"def");
       hm.put('4', "ghi");
       hm.put('5', "jkl");
       hm.put('6', "mno");
       hm.put('7', "pqrs");
       hm.put('8', "tuv");
       hm.put('9', "wxyz");


       char[] darr = digits.toCharArray();
      
       String str = "";
       process(hm, arrList, str,darr,0);

       return arrList;
        
   }

   public void process(HashMap<Character,String> hm,List<String> arrList,String str,char[] darr,int index){


       if(index == darr.length){
           arrList.add(str);
           return;
       }
       Character c = darr[index];
       
       String s = hm.get(c);
       char[] sarr = s.toCharArray();
       for(Character c1 : sarr){
           process(hm, arrList, str + c1,darr,index +1 );
       }
           
        
   }
}
