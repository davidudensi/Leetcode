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
public class NonRepeatSubstr {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        if (s.length() < 2) {
            return 1;
        }

        char[] xters = s.toCharArray();
        HashMap<Character, Integer> lookup = new HashMap<>();
        StringBuilder substr = new StringBuilder();
        int max = 0;

//        for (int i = 0; i < s.length(); i++) {
//            char u = s.charAt(i);
//            if (lookup.get(u) == null) {
//                lookup.put(u, i);
//                substr.append(u);
//                max = substr.length();
//            } else {
//                max = (substr.length() <= max ? max : substr.length());
//                substr = new StringBuilder(s.substring(lookup.get(u) + 1, i));
//                lookup = new HashMap<>();
//                System.out.println("Substring is: " + substr);
//                lookup.put(u, i);
//                substr.append(u);
//            }
//        }
        for (char u : xters) {
            if (lookup.get(u) == null) {
                lookup.put(u, 1);
                substr.append(u);
                max = substr.length();
            } else {
                max = substr.length() - 1;
//                System.out.println("Max is: " + max + " at " + u);
//                max = (substr.length() <= max ? max : substr.length()) - 1;
//                lookup = new HashMap<>();
//                substr = new StringBuilder();
//                lookup.put(u, 1);
//                substr.append(u);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        String name = "David";
//        System.out.println(name.substring(5));
        NonRepeatSubstr xxx = new NonRepeatSubstr();
        System.out.println(xxx.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(xxx.lengthOfLongestSubstring("dvdf"));
//        System.out.println(xxx.lengthOfLongestSubstring("pwwkew"));
    }
}
