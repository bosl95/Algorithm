package TREE.이진_검색_트리_5639;

import java.io.*;

public class Main {

    static Node root;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        root = new Node(Integer.parseInt(br.readLine()));

        String n;
        while ((n = br.readLine()) != null) {
            Node nextNode = new Node(Integer.parseInt(n));
            putNode(root, nextNode);
        }

        postOrder(root);
        System.out.println(sb.toString());
    }

    private static void postOrder(Node root) {
        if (root.left != null) postOrder(root.left);
        if (root.right != null) postOrder(root.right);
        sb.append(root.num).append("\n");
    }

    private static void putNode(Node startNode, Node inputNode) {
        if (inputNode.num < startNode.num) {
            if (startNode.left != null) putNode(startNode.left, inputNode);
            else startNode.left = inputNode;
        } else {
            if (startNode.right != null) putNode(startNode.right, inputNode);
            else startNode.right = inputNode;
        }
    }

    static class Node {
        int num;
        Node left;
        Node right;

        public Node(int num) {
            this.num = num;
        }
    }
}
