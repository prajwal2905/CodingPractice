package com.company;

import java.util.HashMap;

class ETwoSum {

    /*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] index = new int[2];
        for(int i=0;i<nums.length; i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                index[0] = map.get(diff);
                index[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return index;
    }
}
