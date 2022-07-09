/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author hp
 */
public class Tree {

    TreeNode head;

    public Tree(ListNode node) {
        this.head = new TreeNode(node.val, node);
    }
    
    

}
