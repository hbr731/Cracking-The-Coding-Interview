package com.javaTwo;

public class LinkedList<E> {

    protected class Node {
        protected E data;
        protected Node next;
        public Node() {}
        public Node(E elt) { data = elt; }
    }

    protected Node head;
}
