package com.aaron.javapractice;

public class FindIndex {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if( len == 0 || target <= nums[0]) {
            return 0;
        }
        if(target > nums[len - 1]) {
            return len - 1;
        }
        int left = 0;
        int right = len - 1;
        int cur = 0;
        while(left < right) {
            cur = (left + right ) / 2;
            if(target > nums[cur]) {
                left = cur;
            } else if(target < nums[cur]) {
                 right = cur;
            } else {
                return cur;
            }
            if(right - left == 1) {
                cur = left + 1;
                break;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        FindIndex solution = new FindIndex();
        int [] nums = new int[] {1,3};
        int target = 2;
        System.out.println("the ans is : " + solution.searchInsert(nums,target));
    }
}
