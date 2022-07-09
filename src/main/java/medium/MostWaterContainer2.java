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
public class MostWaterContainer2 {

    public int maxArea(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }

        int max = 0, max_control;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                if (j != i && height[i] <= height[j]) {
                    if (i > j) {
                        max_control = height[i] * (i - j);
                    } else {
                        max_control = height[i] * (j - i);
                    }
                    max = Math.max(max, max_control);
                }
            }
        }
        return max;
    }
}
