/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice.str;

import java.util.Stack;

public class BracketMatch {
    private static String [] testCase = new String[]{"()","()[]{}","(]","([)]","{[]}"};

    public boolean isValid(String s) {
        if(s == null || s== "") {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '(' || cur == '[' || cur == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char prev = stack.pop();
                    boolean curMatch = false;
                    switch (prev) {
                        case '(':
                            curMatch = cur == ')';
                            break;
                        case '[':
                            curMatch = cur == ']';
                            break;
                        case '{':
                            curMatch = cur =='}';
                    }
                    if(!curMatch) {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }
    public static void main(String[] args) {
        BracketMatch solu = new BracketMatch();
        for(int i = 0 ; i < 5; i++) {
            System.out.println(solu.isValid(testCase[i]));
        }
    }
}