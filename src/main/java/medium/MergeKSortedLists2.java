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
public class MergeKSortedLists2 {

    private ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];

        ListNode result = new ListNode(0);
        ListNode current = result;

        for (int i = 1; i < lists.length; i++) {
            ListNode one = head;
            ListNode two = lists[i];
            while (one != null && two != null) {
                if (one.val < two.val) {
                    current.next = one;
                    one = one.next;
                } else {
                    current.next = two;
                    two = two.next;
                }
            }
            while (one != null) {
                current.next = one;
                one = one.next;
            }
            while (two != null) {
                current.next = two;
                two = two.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 4, 5};
        int[] input2 = {1, 3, 4};
        int[] input3 = {2, 6};

        ListNode one = new ListNode(input1[0]);
        ListNode two = new ListNode(input2[0]);
        ListNode three = new ListNode(input3[0]);
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

        for (int i = 1; i < input3.length; i++) {
            ListNode newNode = new ListNode(input3[i]);
            newNode.next = three;
            three = newNode;
        }

        ListNode lists[] = {one, two, three};
        MergeKSortedLists2 merge = new MergeKSortedLists2();
        System.out.println(merge.mergeKLists(lists));
    }
}
