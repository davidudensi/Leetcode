/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hp
 */
public class LetterCombination3 {

    public List<String> letterCombinations(String digits) {
        String[] lookup = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};
        LinkedList<String> results = new LinkedList<>();
        if (digits.length() == 0) {
            return results;
        }
        results.add("");

        for (int i = 0; i < digits.length(); i++) {
            while (results.peek().length() == i) {
                String permutation = results.remove();
                for (char c : lookup[digits.charAt(i) - '0'].toCharArray()) {
                    results.add(permutation + c);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        LetterCombination3 combination = new LetterCombination3();
        System.out.println(combination.letterCombinations("23"));
    }
}
