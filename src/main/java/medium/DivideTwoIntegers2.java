/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class DivideTwoIntegers2 {

    public int divide(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend >= 0) == (divisor >= 0);
        int result = 0;

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        while ((dividend - divisor) >= 0) {
            int count = 1;
            while (dividend - (divisor << 1 << count) >= 0) {
                count++;
            }
            result += 1 << count;
            dividend -= dividend << count;
        }
        return sign ? result : -result;
    }

    public static void main(String[] args) {
//        DivideTwoIntegers2 divideTwoIntegers = new DivideTwoIntegers2();
//        System.out.println(divideTwoIntegers.divide(10, 3));
//
//        String[] x1 = new String[]{"Matt", "Dan"};
//        LinkedList<String> dict = new LinkedList<>();
//        dict.add("David");
//        dict.add("David");
//        dict.add("Udensi");
////        xxx.add(Arrays.asList(x1));
//        dict.remove("David");
//        dict.remove("David");
//        System.out.println(dict);
        
        HashMap<Integer, Integer> map = new HashMap<>();
//        for(Map.Entry<Integer, Integer> set : map.values()){
//            
//        }
        
    }
}
