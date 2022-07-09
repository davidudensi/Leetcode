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
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        ListNode node = this;
        output.append(node.val);
        while (node.next != null) {
            output.append("->");
            output.append(node.next.val);
            node = node.next;
        }
        return output.toString();
    }
}
