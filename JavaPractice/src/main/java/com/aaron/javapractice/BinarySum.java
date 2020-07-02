/**
 *
 给你两个二进制字符串，返回它们的和（用二进制表示）。

 输入为 非空 字符串且只包含数字 1 和 0。

 示例 1:

 输入: a = "11", b = "1"
 输出: "100"
 示例 2:

 输入: a = "1010", b = "1011"
 输出: "10101"


 提示：

 每个字符串仅由字符 '0' 或 '1' 组成。
 1 <= a.length, b.length <= 10^4
 字符串如果不是 "0" ，就都不含前导零。
 */
package com.aaron.javapractice;

public class BinarySum {
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        String res = "";
        if(len1 <= len2) {
            char carry = '0';
            for(int i = len1 - 1; i >= 0; i--) {
                char curBit = '0';
                char bitOfa = a.charAt(i);
                char bitOfb = b.charAt(i + len2 - len1);
                if(bitOfa == '0') {
                    if(carry == '0') {
                        curBit = bitOfb;

                    } else {
                        if(bitOfb == '1') {
                            curBit = '0';
                        } else {
                            carry = '0';
                            curBit = '1';
                        }
                    }
                } else {
                    if(carry == '0') {
                        if(bitOfb == '1') {
                            carry = '1';
                            curBit = '0';
                        } else {
                            curBit = '1';
                        }
                    } else {
                        curBit = bitOfb;
                    }
                }
                res = curBit + res;
            }
            int index = len2 - len1 - 1;

            if(carry == '1') {
                while (index > 0 && b.charAt(index) == '1') {
                    res = '0' + res;
                    index --;
                }
            }
            if(index == 0 ) {
                if(carry == '1')
                    res = "10" + res;
                else
                    res = '1' + res;
            } else if(index > 0) {
                if(carry == '1') {
                    res = b.substring(0,index ) + carry + res;
                } else {
                    res = b.substring(0,index + 1) + res;
                }
            } else if(index == -1 && carry == '1') {
                res = '1' + res;
            }
            return res;
        } else {
            return addBinary(b,a);
        }
    }

    public static void main(String[] args) {
        String a = "101";
        String b = "10";
        BinarySum solution = new BinarySum();
        System.out.println("String a is: " + a);
        System.out.println("String b is: " + b);
        String res = solution.addBinary(a,b);
        System.out.println("res is :" + res);
    }
}
