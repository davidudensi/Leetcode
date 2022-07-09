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
public class SwapNodes {

    public ListNode swapNodes(ListNode head) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode current = result;

        while (current.next != null && current.next.next != null) {
            ListNode n1 = current.next;
            ListNode n2 = current.next.next;
            
            n1.next = n2.next;
            current.next = n2;
            current.next.next = n1;
            
            current = current.next.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4};
        ListNode one = new ListNode(input1[0]);
        for (int i = 1; i < input1.length; i++) {
            ListNode newNode = new ListNode(input1[i]);
            newNode.next = one;
            one = newNode;
        }

        SwapNodes swap = new SwapNodes();
        System.out.println(swap.swapNodes(one));
//        System.out.println(one);
    }
}
