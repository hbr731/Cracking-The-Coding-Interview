package com.javaTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node<E> {
    protected E data;
    protected Node left, right, parent;
    public Node (E elt) {this.data = elt;}
}
public class Tree<E> {
    private static Node root;

    public Tree() {}

    public boolean isEmpty() {
        return root == null;
    }

    public void inOrderTraversal(Node nd) {
        if (nd == null) return;
        inOrderTraversal(nd.left);
        System.out.println(nd.data);
        inOrderTraversal(nd.right);
    }

    public void preOrderTraversal(Node nd) {
        if (nd == null) return;
        System.out.println(nd.data);
        preOrderTraversal(nd.left);
        preOrderTraversal(nd.right);
    }

    public void postOrderTraversal(Node nd) {
        if (nd == null) return;
        postOrderTraversal(nd.left);
        postOrderTraversal(nd.right);
        System.out.println(nd.data);
    }

    /*
    Given a sorted (increasing order) array with unique integer elements, write
    an algorithm to create a binary search tree with minimal height.
     */
    public static Node constructBST(Integer[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node nd = new Node(arr[mid]);
        nd.left = constructBST(arr, start, mid - 1);
        nd.right = constructBST(arr, mid + 1, end);

        return nd;
    }
    
    /*
    Given a binary tree, design an algorithm which creates a linked list of all the
    nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists.
     */
    public static List<LinkedList<Node>> getDepths(Node treeNode) {
        List<LinkedList<Node>> depths = new ArrayList<>();
        List<Node> current = new LinkedList<>();

        if (treeNode != null) current.add(treeNode);

        while (!current.isEmpty()){
            depths.add((LinkedList<Node>) current);
            LinkedList<Node> parents = (LinkedList<Node>)current;
            current = new LinkedList<>();

            for (Node parent : parents) {
                if (parent.left != null) current.add(parent.left);
                if (parent.right != null) current.add(parent.right);
            }
        }
        return depths;
    }

    public static void main(String[] args) {
        Tree<Integer> t = new Tree<>();
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        t.root = constructBST(arr, 0, arr.length - 1);
        t.preOrderTraversal(t.root);
        System.out.println();
        System.out.println();

        List<LinkedList<Node>> depths = getDepths(t.root);
        for (LinkedList<Node> parent : depths) {
            for (Node nd : parent) {
                System.out.println(nd.data + " ");
            }
            System.out.println();
        }

    }


}
