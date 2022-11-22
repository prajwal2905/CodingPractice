 //Longest Substring Without Repeating Characters
//Given a string s, find the length of the longest substring without repeating characters.

//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.

//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.





class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }
        
        String subStr = "";
        int maxLength = -1;
        
        for(int i=0;i<s.length();i++) {
            if(subStr.contains(String.valueOf(s.charAt(i)))) {
                subStr = subStr.substring(subStr.indexOf(String.valueOf(s.charAt(i))) + 1);
            }
            subStr+=s.charAt(i);
            
            maxLength = Math.max(subStr.length(), maxLength);
        }
        
        return maxLength;
        
    }
}
