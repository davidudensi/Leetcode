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
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // if(divisor == 1) return dividend;
        if(divisor == 0 || dividend == 0) return 0;
        if(dividend == divisor) return 1;
        
        int signed = 1, num_signed = 1, denum_signed = 1;
        if(dividend < 0) num_signed = -1;
        if(divisor < 0) denum_signed = -1;
        
        boolean negatives = (num_signed == 1 && denum_signed == -1) 
            || (num_signed == -1 && denum_signed == 1);
        if(negatives) signed = -1;
        
        int num = Math.abs(dividend);
        int denum = Math.abs(divisor);
        if(denum == 1) return num * signed;
        int result = 0;
        int counter = 0;
        for(int i = 0; i < dividend; i++){
            counter++;
            if(counter == divisor) {
                result++;
                counter = 0;
            }
        }
        result = negatives ? result * signed : result;
        return result;
    }
    
    public static void main(String[] args) {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        System.out.println(divideTwoIntegers.divide(10, 3));
    }
}
