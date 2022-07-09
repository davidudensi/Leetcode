/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medium;

import java.util.EmptyStackException;

/**
 *
 * @author hp
 * @param <T>
 */
public class ReverseInteger<T> {

    public class StackNode<T> {

        private final T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public void push(char data) {
        StackNode node = new StackNode(data);
        if (top == null) {
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }

        T item = top.data;
        top = top.next;
        return item;
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        String text = (negative ? (x * -1) : x) + "";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            push(text.charAt(i));
        }

        while (top != null) {
            result.append(pop());
        }
        try {
            return Integer.parseInt(result.toString()) * (negative ? -1 : 1);
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    public static void main(String[] args) {
        ReverseInteger stack = new ReverseInteger();
        System.out.println(stack.reverse(1534236469));
    }
}
