package com.company;


import java.util.*;


/*
* Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.



Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
* */
public class EUniqueOccurance {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();
        for(int i=0;i<arr.length;i++) {
            int occur = 0;
            if(occurMap.containsKey(arr[i])) {
                occur = occurMap.get(arr[i]);
            }
            occurMap.put(arr[i], occur+1);
        }
        Collection<Integer> collection = occurMap.values();
        Set<Integer> set = new HashSet<Integer>();
        for(int element : collection) {
            if(!set.add(element)) {
                return false;
            }
        }
        return true;
    }
}
