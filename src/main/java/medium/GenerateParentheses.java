/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author hp
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> main_result = new ArrayList<>();
        if(n == 1){
            main_result.add("()");
            return main_result;
        }
        
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("()");

        while (!queue.isEmpty()) {
            Set<String> opSet = new HashSet<>();
            String current = queue.poll();

            String op = wrap(current);
            if (wrap(current).length() == (n * 2)) {
                result.add(op);
            } else {
                opSet.add(op);
            }

            op = toSide(current, true);
            if (op.length() == (n * 2)) {
                result.add(op);
            } else {
                opSet.add(op);
            }

            op = toSide(current, false);
            if (op.length() == (n * 2)) {
                result.add(op);
            } else {
                opSet.add(op);
            }
            queue.addAll(opSet);
        }
        main_result.addAll(result);
        return main_result;
    }

    public String wrap(String text) {
        return "(" + text + ")";
    }

    public String toSide(String text, boolean left) {
        return left ? "()" + text : text + "()";
    }

//    public boolean isComplete(String text, int n) {
//        int count = 0;
//        for (int i = 0; i < text.length(); i++) {
//            if (text.charAt(i) == '(') {
//                count++;
//            }
//        }
//        return count == n;
//    }

    public static void main(String[] args) {
        GenerateParentheses parenthesis = new GenerateParentheses();
        System.out.println(parenthesis.generateParenthesis(10));
    }
}
