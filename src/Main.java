// CS-2920
// Call Unit Tests from here

import structures.*;

public class Main {
    public static void main(String[] args) {
        QuickUnionUF uf = new QuickUnionUF(10);
        uf.union(9, 0);
        uf.union(3, 4);
        uf.union(5, 8);
        uf.union(7, 2);
        uf.union(2, 1);
        uf.union(5, 7);
        uf.union(0, 3);
        uf.union(4, 2);

        System.out.println(uf);

    }
}