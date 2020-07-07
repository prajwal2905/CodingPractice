package com.company;

import java.util.Stack;

public class EValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.push(currChar);
            } else  {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if(currChar == ')' && c != '(') {
                        return false;
                    } else if(currChar == ']' && c != '[') {
                        return false;
                    } else if(currChar == '}' && c != '{') {
                        return false;
                    }
                }
            }

            /*else if (!stack.empty()) {
                char c = stack.pop();
                if (s.charAt(i) == ')' s.charAt(i) == ']') {
                    if (c != '(') {
                        return false;
                    }
                } else if () {
                    if (c != '[') {
                        return false;
                    }
                } else if (s.charAt(i) == '}') {
                    if (c != '{') {
                        return false;
                    }
                }
            } else if (stack.isEmpty()) {
                return false;
            }*/
        }

        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
