/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author hp
 */
//class ListNode {
//
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class NthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //using the runner technique
        ListNode pointer = head;
        ListNode runner = head;

        while (runner != null) {
            pointer = pointer.next;
            for (int i = 0; i < n; i++) {
                runner = runner.next;
            }
        }
        
        pointer.next = pointer.next.next;
        return head;
    }
}
