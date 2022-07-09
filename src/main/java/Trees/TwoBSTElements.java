/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trees;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author hp
 */
public class TwoBSTElements {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        List<Integer> list1 = getList(root1, new LinkedList<>());

        if (list1 != null) {
            if (root2 != null) {
                list1.forEach(value -> {
                    add(root2, value);
                });
                return getList(root2, new LinkedList<>());
            } else {
                return list1;
            }
        }
        return null;
    }

    public List<Integer> getList(TreeNode node, List<Integer> list) {
        if (node != null) {
            getList(node.left, list);
            list.add(node.val);
            getList(node.right, list);
        }
        return list;
    }

    public void add(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        TreeNode newNode = new TreeNode(value);
        if (value < node.val) {
            if (node.left == null) {
                node.left = newNode;
                return;
            }
            add(node.left, value);
        } else {
            if (node.right == null) {
                node.right = newNode;
                return;
            }
            add(node.right, value);
        }
    }
}
