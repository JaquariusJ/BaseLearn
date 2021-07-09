package com.wujian.common.tree;


public class BinaryTree {

    public Node root;

    private Node addNode(Node current,int value){
        if(current == null){
            return new Node(value);
        }
        if(value < current.data){
            current.left = addNode(current.left,value);
        }else if(value > current.data){
            current.right = addNode(current.right,value);
        }else{
            return current;
        }
        return current;
    }

    public Node addNode(int value){
        root = addNode(root,value);
        return root;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(6);
        binaryTree.addNode(4);
        binaryTree.addNode(8);
        binaryTree.addNode(10);
        System.out.println(binaryTree);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}


