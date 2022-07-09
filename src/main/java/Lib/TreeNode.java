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
public class TreeNode {

    int val;
    ListNode node;
    TreeNode right, left;

    public TreeNode(int val, ListNode node) {
        this.val = val;
        this.node = node;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public void addNode(TreeNode treeNode) {
//        TreeNode treeNode = new TreeNode(val, node);
        if (treeNode.val > this.val) {
            if (right != null) {
                right = treeNode;
            }
            right.addNode(treeNode);
        } else {
            if (left != null) {
                left = treeNode;
            }
            left.addNode(treeNode);
        }
    }
}
