/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author hp
 */
public class MergeTwoSortedLists {

    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        List<Integer> container = new ArrayList<>();
        int arr_size = 0;
        
        ListNode node = new ListNode(list1.val);
        node.next = list1.next;
        boolean merged = false;

        while (node != null) {
            container.add(node.val);
            node = node.next;
            arr_size += 1;
            if (node == null && !merged) {
                node = list2;
                merged = true;
            }
        }

        int[] arr = new int[arr_size];
        for (int i = 0; i < container.size(); i++) {
            arr[i] = container.get(i);
        }
        Arrays.sort(arr);

        ListNode head = new ListNode(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            ListNode y = new ListNode(arr[i]);
            y.next = head;
            head = y;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] input1 = {-9, 3};
        int[] input2 = {5, 7};

        ListNode one = new ListNode(input1[0]);
        ListNode two = new ListNode(input2[0]);
        for (int i = 1; i < input1.length; i++) {
            ListNode newNode = new ListNode(input1[i]);
            newNode.next = one;
            one = newNode;
        }

        for (int i = 1; i < input2.length; i++) {
            ListNode newNode = new ListNode(input2[i]);
            newNode.next = two;
            two = newNode;
        }
        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        System.out.println(merge.mergeTwoLists(one, two));
    }
}
