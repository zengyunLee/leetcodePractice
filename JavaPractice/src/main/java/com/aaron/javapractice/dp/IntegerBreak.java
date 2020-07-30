/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 * translate
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice.dp;

public class IntegerBreak {
    public int integerBreak(int n) {
        int [] dp = new int[n+1];
        for(int i = 2; i <= n ; i++) {
            int temp = 0;
            for (int j = 1; j < i; j++) {
                temp = Math.max(temp,Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = temp;
        }
        return  dp[n];
    }

    public static void main(String[] args) {
        IntegerBreak solu = new IntegerBreak();
        System.out.println("ans is " + solu.integerBreak(10));
    }
}
