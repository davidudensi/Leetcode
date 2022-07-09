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
public class LongestPalindrome2 {

    private String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = getPalindrome(s, i, i);
            int len2 = getPalindrome(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int getPalindrome(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }
        while (left >= 0 && right < s.length() && s.charAt(left)
                == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindrome2 lp = new LongestPalindrome2();
        String input = "jrjnbctoqgzimtoklkxcknwmhiztomaofwwzjnhrijwkgmwwuazcow"
                + "skjhitejnvtblqyepxispasrgvgzqlvrmvhxusiqqzzibcyhpnruhrgbzsml"
                + "suacwptmzxuewnjzmwxbdzqyvsjzxiecsnkdibudtvthzlizralpaowsbakz"
                + "coneuwwpsqynaxqmgngzpovauxsqgypinywwtmekzhhlzaeatbzryreuttgw"
                + "fqmmpeywtvpssznkwhzuqewuqtfuflttjcxrhwexvtxjihunpywerkktbvls"
                + "yomkxuwrqqmbmzjbfytdddnkasmdyukawrzrnhdmaefzltddipcrhuchvdco"
                + "egamlfifzistnplqabtazunlelslicrkuuhosoyduhootlwsbtxautewkvnv"
                + "lbtixkmxhngidxecehslqjpcdrtlqswmyghmwlttjecvbueswsixoxmymcep"
                + "bmuwtzanmvujmalyghzkvtoxynyusbpzpolaplsgrunpfgdbbtvtkahqmmlb"
                + "xzcfznvhxsiytlsxmmtqiudyjlnbkzvtbqdsknsrknsykqzucevgmmcoanil"
                + "syyklpbxqosoquolvytefhvozwtwcrmbnyijbammlzrgalrymyfpysbqpjwz"
                + "irsfknnyseiujadovngogvptphuyzkrwgjqwdhtvgxnmxuheofplizpxijfy"
                + "tfabx";
        System.out.println(lp.longestPalindrome(input));
    }
}
