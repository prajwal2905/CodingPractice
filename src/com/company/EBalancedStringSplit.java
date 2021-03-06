package com.company;


/*
* alanced strings are those who have equal quantity of 'L' and 'R' characters.

Given a balanced string s split it in the maximum amount of balanced strings.

Return the maximum amount of splitted balanced strings.



Example 1:

Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
Example 2:

Input: s = "RLLLLRRRLR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.
Example 3:

Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".
*
* */
public class EBalancedStringSplit {
    public int balancedStringSplit(String s) {
        int count = 0;
        int subStringCount = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == 'R') {
                count+=1;
            } else if(s.charAt(i) == 'L') {
                count-=1;
            }
            if(count == 0) {
                subStringCount+=1;
            }
        }
        return subStringCount;
    }
}
