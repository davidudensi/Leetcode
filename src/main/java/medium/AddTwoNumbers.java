/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import Lib.ListNode;

/**
 *
 * @author hp
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sum_text = new StringBuilder();
//        sum_text.l
        ListNode first = l1;
        ListNode second = l2;
        int exp = 0;
        int carry = 0;

        while (first != null || second != null) {
            int first_num = 0, second_num = 0;
            if (first != null) {
                first_num = first.val;
                first = first.next;
            }

            if (second != null) {
                second_num = second.val;
                second = second.next;
            }

            int current_sum = first_num + second_num + carry;
            String curr_sum_text = current_sum + "";
            if (curr_sum_text.length() > 1) {
                sum_text.append(curr_sum_text.charAt(1));
                carry = Integer.parseInt(String.valueOf(curr_sum_text.charAt(0)));
            } else {
                sum_text.append(curr_sum_text);
                carry = 0;
            }
            exp++;
        }
        return convert(sum_text.append(carry < 1 ? "" : carry));
    }

    public ListNode convert(StringBuilder input) {
        if (input.isEmpty()) {
            return null;
        }

        int value = Integer.parseInt(String.valueOf(input.charAt(0)));
        ListNode root = new ListNode((int) value);
        ListNode node = root;

        for (int i = 1; i < input.length(); i++) {
            value = Integer.parseInt(String.valueOf(input.charAt(i)));
            node.next = new ListNode(value);
            node = node.next;
        }
        return root;
    }

    public static void main(String[] args) {
        int[] arr1 = {9};
//        int[] arr1 = {2, 4, 3};

        ListNode root1 = new ListNode(arr1[0]);
        ListNode node = root1;
        for (int i = 1; i < arr1.length; i++) {
            ListNode n = new ListNode(arr1[i]);
            node.next = n;
            node = node.next;
        }

        int[] arr2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
//        int[] arr2 = {5, 6, 4};
        ListNode root2 = new ListNode(arr2[0]);
        node = root2;

        for (int i = 1; i < arr2.length; i++) {
            ListNode n = new ListNode(arr2[i]);
            node.next = n;
            node = node.next;
        }

        AddTwoNumbers two_numbers = new AddTwoNumbers();
        ListNode result_root = two_numbers.addTwoNumbers(root1, root2);
        while (result_root != null) {
            System.out.println(result_root);
            result_root = result_root.next;
        }
    }
}
