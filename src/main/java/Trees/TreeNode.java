/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

/**
 *
 * @author hp
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addNode(int newData) {
        TreeNode newNode = new TreeNode(newData);
        if (newData > this.val) {
            if (this.right == null) {
                this.right = newNode;
                return;
            }
            this.right.addNode(newData);

        } else if (newData < this.val) {
            if (this.left == null) {
                this.left = newNode;
                return;
            }
            this.left.addNode(newData);
        } else {
        }
    }

    @Override
    public String toString() {
        return "Data is " + this.val;
    }
}
