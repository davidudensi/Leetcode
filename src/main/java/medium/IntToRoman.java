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
public class IntToRoman {

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX",
            "V", "IV", "I"};
        
        int result = num;
        StringBuilder roman = new StringBuilder();
        for(int i = 0; i < values.length; i++){
            int divider = result / values[i];
            System.out.println(result);
            if (divider != 0) {
                for (int j = 0; j < divider; j++) {
                    roman.append(roms[i]);
                }
                result = result % values[i];
            }
            if (result == 0) {
                break;
            }
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(58));
    }
}
