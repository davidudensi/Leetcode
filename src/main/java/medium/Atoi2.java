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
public class Atoi2 {

    public int myAtoi(String s) {
        if (s.isBlank()) {
            return 0;
        }
        boolean sign = false;
//        StringBuilder word = new StringBuilder();

        int count = 0;
        while (s.charAt(count) == ' ') {
            count++;
        }
        if (s.charAt(count) == '-' || s.charAt(count) == '+') {
            if (s.charAt(count) == '-') {
                sign = true;
            }
            count += 1;
        }
        char x = s.charAt(count);
        if (x < 48 && x > 57) {
            return 0;
        }

        int result = 0;
        while (count < s.length() && s.charAt(count) >= 48
                && s.charAt(count) <= 57) {
//            System.out.println(count);
            result = (result * 10) + (s.charAt(count) - '0');
            count++;
        }
        return sign ? -result : result;
//        if (s.isBlank()) {
//            return 0;
//        }
//
//        int i = 0, sign = 1; 
//        long total = 0;
//        while (i < s.length() && s.charAt(i) == ' ') {
//            i++;
//        }
//
//        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
//            if (s.charAt(i++) == '-') {
//                sign = -1;
//            }
//        }
//
//        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
//            if (total > Integer.MAX_VALUE || (total
//                    == Integer.MAX_VALUE && s.charAt(i) - '0' > '7')) {
//                if (sign == -1) {
//                    return Integer.MIN_VALUE;
//                }
//                return Integer.MAX_VALUE;
//            }
//            total = (total * 10) + (s.charAt(i++) - '0');
//        }
//        System.out.println("here");
//        return (int)(total * sign);

//        if (s.isBlank()) return 0;
//        boolean sign = false;
//        StringBuilder word = new StringBuilder();
//        for(int i = 0; i < s.length(); i++){
//            char x = s.charAt(i);
//            if((x >= 48 && x <= 57) || x == 46 || x == 45){
//                if(x == 45) {
//                    sign = true;
//                }else{
//                    word.append(x);
//                }
//            }
//        }
//        int result = 0;
//        String w = word.toString();
//        for(int i = 0; i < w.length(); i++){
//            result = (result * 10) + (w.charAt(i) - '0');
//        }
//        return sign ? -result : result;
    }

    public static void main(String[] args) {
        Atoi2 atoi = new Atoi2();
//        System.out.println(atoi.myAtoi("21474836460"));
        System.out.println(atoi.myAtoi("42"));
    }
}
