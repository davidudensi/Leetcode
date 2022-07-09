/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hp
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int newTarget = target - nums[i];
                threeSum(nums, i, newTarget, result);
            }
        }
        return result;
    }

    public void threeSum(int[] nums, int idx, int target,
            List<List<Integer>> result) {
        for (int i = idx + 1; i < nums.length; i++) {
            if (i == (idx + 1) || (i > (idx + 1) && nums[i] != nums[i - 1])) {
                int newTarget = target - nums[i];
                int[] indices = {idx, i};
                twoSum(nums, i + 1, nums.length - 1, newTarget, indices,
                        result);
            }
        }
    }

    public void twoSum(int[] nums, int start, int end, int target,
            int[] indices, List<List<Integer>> result) {
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                Integer[] res = {nums[indices[0]], nums[indices[1]],
                    nums[start], nums[end]};
                Arrays.sort(res);
                result.add(Arrays.asList(res));

                while (start < end && nums[start] == nums[start + 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end - 1]) {
                    end--;
                }

                start++;
                end--;
            } else {
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] input = {2, 2, 2, 2, 2};
        System.out.println(fourSum.fourSum(input, 8));
        
        LinkedList<Integer> list = new LinkedList<>();
//        list.
    }
}
