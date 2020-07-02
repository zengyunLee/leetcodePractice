package com.aaron.javapractice;

import java.util.Arrays;

public class MimumSizeSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= len; i++) {
            int target = s + sums[i - 1];
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound <= len) {
                ans = Math.min(bound - (i - 1), ans);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int doublePointerMinSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        MimumSizeSubArray solution = new MimumSizeSubArray();
        int [] testCase = new int[] {1,2,3,4,5};
        int res = solution.minSubArrayLen(15,testCase);
        System.out.println(" result is " + res);
    }
}
