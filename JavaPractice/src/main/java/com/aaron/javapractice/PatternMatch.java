/**
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pattern-matching-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice;

public class PatternMatch {
    public boolean patternMatching (String pattern,String value) {
        if(value == null || pattern == null) return  false;
        int vlen = value.length();
        int plen = pattern.length();
        if(vlen == 0 || plen == 0 || vlen % plen != 0) {
            return  false;
        }
        int num = vlen / plen;
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba",value = "dogcatcatdog";
        PatternMatch solution = new PatternMatch();
        boolean res = solution.patternMatching(pattern,value);
        System.out.println("String: " + value );
        System.out.println("Pattern: " + pattern );
        System.out.println("result: " + res );
    }
}
