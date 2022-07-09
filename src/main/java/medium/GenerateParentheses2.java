/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hp
 */
public class GenerateParentheses2 {
    
    private List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateParentheses(result, "", 0, 0, n);
        return result;
    }
    
    private void generateParentheses(List<String> result, String text, 
            int open, int close, int max){
        if(text.length() == max * 2){
            result.add(text);
            return;
        }
        if(open < max){
            generateParentheses(result, text + "(", open + 1, close, max);
        }
        if(close < open){
            generateParentheses(result, text + ")", open, close + 1, max);
        }
    }
    
    public static void main(String[] args) {
        GenerateParentheses2 parenthesis = new GenerateParentheses2();
        System.out.println(parenthesis.generateParentheses(3));
    }
}
