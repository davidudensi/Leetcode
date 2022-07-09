/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import Trees.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author hp
 */
public class NonRepeatSubstr2 {

    TreeNode root = new TreeNode();
    LinkedList<Integer> list;

    public int lengthOfLongestSubstring(String s) {
        TreeNode node = findLength(s, 0, new HashMap<>(), new StringBuilder());
        list = new LinkedList<>();
        inOrderTraverse(node);
        return list.getLast();
    }

    public TreeNode findLength(String s, int count,
            HashMap<Character, Integer> lookup, StringBuilder text) {
        if (count < s.length()) {
            if (lookup.get(s.charAt(count)) != null) {
                text = new StringBuilder(text.substring(
                        text.indexOf("" + s.charAt(count)) + 1));
                text.append(s.charAt(count));
                root.addNode(text.length());
                return findLength(s, count + 1, lookup, text);
            } else {
                lookup.put(s.charAt(count), 1);
                text.append(s.charAt(count));
                root.addNode(text.length());
                return findLength(s, count + 1, lookup, text);
            }
        }
        return root;
    }

    private void inOrderTraverse(TreeNode node) {
        if (node != null) {
            inOrderTraverse(node.left);
            list.add(node.val);
            inOrderTraverse(node.right);
        }
    }

    public static void main(String[] args) {
        NonRepeatSubstr2 xxx = new NonRepeatSubstr2();
        System.out.println(xxx.lengthOfLongestSubstring("pwwkew"));
//        System.out.println(xxx.lengthOfLongestSubstring("dvdf"));
//        System.out.println(xxx.lengthOfLongestSubstring("abcabcbb"));
    }
}
