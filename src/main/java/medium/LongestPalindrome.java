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
public class LongestPalindrome {

    HashMap<String, Boolean> lookup;
    int max = 0;
    String max_pal = "";

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        lookup = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            getSubstring(s.substring(i), 0);
        }
        return max_pal;
    }

    public void getSubstring(String s, int index) {
        if (index <= s.length()) {
            String text = s.substring(0, index);
            if (lookup.get(text) == null) {
                lookup.put(text, Boolean.TRUE);
            }
            if (isPalindrome(text)) {
                if (text.length() > max) {
                    max = text.length();
                    max_pal = text;
                }
            }
            getSubstring(s, index + 1);
        }
    }

    private boolean isPalindrome(String text) {
        int mid = text.length() / 2;
        for (int i = 0; i < mid; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
//        String input = "bb";
        String input = "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcows"
                + "kjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsmls"
                + "uacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakzc"
                + "oneuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgwf"
                + "qmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvlsy"
                + "omkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdcoe"
                + "gamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnvl"
                + "btixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcepb"
                + "muwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlbx"
                + "zcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanils"
                + "yyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwzi"
                + "rsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfyt"
                + "fabx";
//        String input = "babad";
        System.out.println(lp.longestPalindrome(input));
    }
}
