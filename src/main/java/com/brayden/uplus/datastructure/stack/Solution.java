package com.brayden.uplus.datastructure.stack;

import java.util.Stack;

/**
 * @Description：
 * @Date: Created in 2020/4/7 23:23
 * @Author Brayden
 * @Version 1.0
 */
class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack = new Stack <>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (pop == '(' && c != ')') {
                    return false;
                }
                if (pop == '[' && c != ']') {
                    return false;
                }
                if (pop == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}


