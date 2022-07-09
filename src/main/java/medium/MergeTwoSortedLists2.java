/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author hp
 */
public class MergeTwoSortedLists2 {

    private ListNode mergeTwoLists(ListNode one, ListNode two) {
//        Queue q = new PriorityQueue((o1, o2) -> {
//            return 0; //To change body of generated lambdas, choose Tools | Templates.
//        });
//        q.

//tree
        ListNode result = new ListNode(0);
        ListNode current = result;

        while (one != null && two != null) {
            if (one.val < two.val) {
                current.next = one;
                one = one.next;
            } else {
                current.next = two;
                two = two.next;
            }
            current = current.next;
        }
        if (one != null) {
            current.next = one;
            one = one.next;
        }
        if (two != null) {
            current.next = two;
            two = two.next;
        }
        return result.next;
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
        MergeTwoSortedLists2 merge = new MergeTwoSortedLists2();
        System.out.println(merge.mergeTwoLists(one, two));
    }
}
