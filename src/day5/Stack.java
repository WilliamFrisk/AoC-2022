package day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Stack<T>{

    private Node head;
    private int size;

    class Node {
        private Node next;
        private T value;

        private Node(T value, Node next) {
            this.next = next;
            this.value = value;
        }
    }

    Stack() {
        size = 0;
    }

    Stack(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    public T pop() {
        T result;
        try {
            result = head.value;
            head = head.next;
            size--;
        } catch (NullPointerException e) {
            result = null;
        }

        return result;
    }

    public List<T> pop(int num) {
        List<T> result = new ArrayList<>();

        for (int i = 0; i < num; i ++) {
            result.add(pop());
        }

        return result;
    }

    public void add(T elem) {
        Node node = new Node(elem, head);
        head = node;
        size++;
    }

    public void add(List<T> arr) {
        Collections.reverse(arr);

        for (T elem : arr) {
            add(elem);
        }
    }

    public T peek() {
        return head.value;
    }

    public int size() {
        return size;
    }

}