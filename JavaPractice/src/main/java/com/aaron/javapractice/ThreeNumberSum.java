/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 *  注意：答案中不可以包含重复的三元组。
 *
 *   
 *
 *  示例：
 *
 *  给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 *  满足要求的三元组集合为：
 *  [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 *  ]
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/3sum
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
package com.aaron.javapractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int first = 0; first < len; ++first) {
            // 需要和上一次枚举的数不相同

            if(first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            int third = len - 1;
            int target = -nums[first];
            for (int second = first + 1; second < len; ++second) {
                // 需要和上一次枚举的数不相同

                if(second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target) {
                    third --;
                }

                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if(second == third) {
                    break;
                }
                if(nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    res.add(list);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int [] testCase = new int[] {-1, 0, 1, 2, -1, -4};
        ThreeNumberSum solution = new ThreeNumberSum();
        List<List<Integer>> res = solution.threeSum(testCase);
        System.out.println(res);
    }
}
