// Launch point for Algobrary
// Decide what algorithms to run and call them from here

import utility.Node;

public class Main {
    public static void main(String[] args) {
        Node<String> node1 = new Node<>("x");
        Node<String> node2 = new Node<>("y");
        Node<String> node3 = new Node<>("z");

        System.out.println(node1.toString() + " " + node2.toString() + " " + node3.toString());
    }
}