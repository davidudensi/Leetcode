/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

/**
 *
 * @author hp
 */
public class MostWaterContainer {

    public int maxArea(int[] height) {
        int max = 0;
        int left_pointer = 0;
        int right_pointer = height.length - 1;

        while (left_pointer < right_pointer) {
            if (height[left_pointer] < height[right_pointer]) {
                max = Math.max(max, height[left_pointer]
                        * (right_pointer - left_pointer));
                left_pointer += 1;
            } else {
                max = Math.max(max, height[right_pointer]
                        * (right_pointer - left_pointer));
                right_pointer -= 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = {1, 0, 0, 0, 0, 0, 0, 2, 2};
//        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        MostWaterContainer water = new MostWaterContainer();
        System.out.println(water.maxArea(input));
    }
}
