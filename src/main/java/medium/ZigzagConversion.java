/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.HashMap;

/**
 *
 * @author hp
 */
public class ZigzagConversion {

    HashMap<Integer, StringBuilder> lookup;

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        if ("".equals(s)) {
            return "";
        }

        if (s.length() <= 2) {
            return s;
        }

        lookup = new HashMap<>();
        int x = 0;
        while (x < s.length()) {
            if ((x + (numRows)) < s.length()) {
                verticals(s.substring(x, x + numRows));
                x += numRows;
            } else {
                verticals(s.substring(x));
                x = s.length();
            }

            if ((x + (numRows - 2)) < s.length()) {
                diagonals(s.substring(x, x + (numRows - 2)), numRows);
                x += numRows - 2;
            } else {
                diagonals(s.substring(x), numRows);
                x = s.length();
            }
        }
        return combine(lookup);
    }

    private void verticals(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (lookup.get(i) != null) {
                lookup.get(i).append(text.charAt(i));
            } else {
                lookup.put(i, new StringBuilder().append(text.charAt(i)));
            }
        }
    }

    private void diagonals(String text, int max) {
        int x = max - 2;
        for (int i = 0; i < text.length(); i++) {
            if (lookup.get(x) != null) {
                lookup.get(x).append(text.charAt(i));
            } else {
                lookup.put(x, new StringBuilder().append(text.charAt(i)));
            }
            x--;
        }
    }

    private String combine(HashMap<Integer, StringBuilder> lookup) {
        StringBuilder result = new StringBuilder();
        lookup.entrySet().forEach(entry -> {
            result.append(entry.getValue());
        });
        return result.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzag = new ZigzagConversion();
        System.out.println(zigzag.convert("PAYPALISHIRING", 4));
    }
}
