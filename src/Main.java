// Launch point for Algobrary
// Call Unit Tests from here

import structures.LinkedList;
import utility.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(list, "ONE");
        list.add(list, "TWO");
        list.add(list, "THREE");

        System.out.println(list.toString());
    }
}