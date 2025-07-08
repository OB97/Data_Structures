// CS-2920
// Call Unit Tests from here

import structures.*;

public class Main {
    public static void main(String[] args) {
        Queue<String> list = new Queue<>();
        list.add(list, "ONE");
        list.add(list, "TWO");
        list.add(list, "THREE");

        System.out.println(list.remove(list));
        System.out.println(list);

    }
}