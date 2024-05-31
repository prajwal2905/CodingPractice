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
        
        if(s.length() == 0 || s.length() == 1) return s.length();
        
        Set<Character> seen = new HashSet<>();
        int maxLength = -1;
        int right=0,left=0;
        
        while(right<s.length()) {
            while(seen.contains(s.charAt(right))) {
              seen.remove(s.charAt(left++));
            }
            seen.add(s.charAt(right));
            maxLength = Math.max(seen.size(), maxLength);
            right++;
        }
        
        return maxLength;
        
    }
}
