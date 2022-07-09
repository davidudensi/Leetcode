/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hp
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = (0 - nums[i]);
            List<Integer> two_sum = twoSum(nums, diff, i);
            if (two_sum.size() > 0) {
                two_sum.add(nums[i]);
                two_sum = two_sum.stream().sorted().collect(Collectors.toList());
//                System.out.println(two_sum + " " + nums[i]);
                if (!alreadyExist(result, two_sum)) {
                    result.add(two_sum);
                }
            }
        }
        return result;
    }

    public boolean alreadyExist(List<List<Integer>> result, List<Integer> input) {
        if (result.size() < 1) {
            return false;
        }
        return result.stream().anyMatch(a -> (a.equals(input)));
    }

    public List<Integer> twoSum(int[] nums, int target, int exempt) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != exempt) {
                int diff = target - nums[i];
                if (lookup.get(diff) != null) {
                    result.add(nums[i]);
                    result.add(nums[lookup.get(diff)]);
                    return result;
                }
                lookup.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        ThreeSum three = new ThreeSum();
        System.out.println(three.threeSum(arr));
//        String input = "David";
//        int x = Integer.parseInt(String.valueOf(input.charAt(input.length())));
//        for(int i = input.length(); i > 0; )
    }
}
