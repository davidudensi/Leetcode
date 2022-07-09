/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.Arrays;

/**
 *
 * @author hp
 */
public class ThreeSumClosest {

    int sum = Integer.MAX_VALUE;

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            twoSum(nums, target, current, start, end);
        }
        return sum;
    }

    public void twoSum(int[] nums, int target, int current, int start, int end) {
        while (start < end) {
            int total = current + nums[start] + nums[end];
            if (total < target) {
                start++;
            } else {
                end--;
            }
            if (sum == Integer.MAX_VALUE) {
                sum = total;
            }
        }
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
//        int[] nums = {0, 1, 2};
        int[] nums = {1, 1, 1, 1};
//        int[] nums = {-1, 2, 1, -4};    //-4,-1,1,2
//        int[] nums = {-3, -2, -5, 3, -4};
        System.out.println(closest.threeSumClosest(nums, 0));
    }
}
