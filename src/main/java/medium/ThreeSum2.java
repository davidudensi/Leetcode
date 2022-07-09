/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hp
 */
public class ThreeSum2 {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  //[-4,-3,-1,-1,0,0,1,2,3,4]
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int current = nums[i];
                int target = 0 - current;

                twoSum(target, nums, i, i + 1, nums.length - 1);
            }
        }
        return result;
    }

    private void twoSum(int target, int[] nums, int current, int start,
            int end) {
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                Integer[] x = {nums[current], nums[start], nums[end]};
                Arrays.sort(x);
                result.add(Arrays.asList(x));

                while (start < end && (nums[start] == nums[start + 1])) {
                    start++;
                }
                while (start < end && (nums[end] == nums[end - 1])) {
                    end--;
                }

                start++;
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        ThreeSum2 three = new ThreeSum2();
        System.out.println(three.threeSum(arr));
    }
}
