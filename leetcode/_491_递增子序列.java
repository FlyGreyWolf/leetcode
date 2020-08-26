package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class _491_递增子序列 {
	
    public List<List<Integer>> findSubsequences(int[] nums) {
    	
    	LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    	
    	LinkedList<Integer> tmp = new LinkedList<>();
    	HashSet<String> set = new HashSet();
    	
    	process(res, tmp, nums, 0, set);
    	
    	return (List)res;
    	
    }	
    
    public void process(LinkedList<LinkedList<Integer>> res, LinkedList<Integer> tmp, int[] nums, int index, HashSet<String> set) {
    	
    	int last = -101;
    	for(int i=index; i<nums.length; i++) {
    		if(tmp.size() == 0) {
    			tmp.addLast(nums[i]);
    			process(res, tmp, nums, i+1, set);
    			tmp.pollLast();
    		} else {
    			
    			if(nums[i] >= tmp.peekLast() && nums[i] != last) {
    				tmp.addLast(nums[i]);
    				
    				if(!handle(set, tmp)) {
    					res.addLast(new LinkedList<>(tmp));
    				}
    				
    				process(res, tmp, nums, i+1, set);
    				last = tmp.peekLast();
    				tmp.pollLast();
    			}
    		}
    		
    	}
    }
    public boolean handle(HashSet<String> set, LinkedList<Integer> tmp) {
    	 
    	String s = "";
    	for(Integer val : tmp) {
    		s = val + "_";
    	}
    	
    	if(!set.contains(s)) {
    		set.add(s);
    		return false;
    	}else {
    		return true;
    	} 
    }
}
