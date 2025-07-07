// CS-2920
// Call Unit Tests from here

import structures.LinkedList;
import testing.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add(list, "ONE");
        list.add(list, "TWO");
        list.add(list, "THREE");

        System.out.println(list.toString());
    }
}