/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hp
 */
public class LetterCombination2 {

    StringBuilder output = new StringBuilder();
    Set<String> result = new HashSet<>();

    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> lookup = prepareLookup();
        int length = digits.length();

        //prepare text
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) != '1') {
                String value = lookup.get(digits.charAt(i));
                text.append(value);
            }
        }
        //run combination algorithm
        return new ArrayList<>(combine(text.toString(), length));
    }

    public Set<String> combine(String inputstring, int length) {
        combine(inputstring, 0, length);
        return result;
    }

    private void combine(String inputstring, int start, int length) {
        for (int i = start; i < inputstring.length(); i++) {
            output.append(inputstring.charAt(i));
            if (output.length() == length) {
                result.add(output.toString());
            }
            if (i < inputstring.length()) {
                combine(inputstring, i + 1, length);
            }
            output.setLength(output.length() - 1);
        }
    }

    public HashMap<Character, String> prepareLookup() {
        HashMap<Character, String> lookup = new HashMap<>();
        lookup.put('2', "abc");
        lookup.put('3', "def");
        lookup.put('4', "ghi");
        lookup.put('5', "jkl");
        lookup.put('6', "mno");
        lookup.put('7', "pqrs");
        lookup.put('8', "tuv");
        lookup.put('9', "wxyz");
        return lookup;
    }

    public static void main(String[] args) {
        LetterCombination2 combination = new LetterCombination2();
        System.out.println(combination.letterCombinations("23"));
    }
}
