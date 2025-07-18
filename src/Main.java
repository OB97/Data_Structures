// CS-2920
// Call Unit Tests from here

import structures.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Comparable[] a = new Comparable[5];
        a[0] = 1;
        a[1] = 3;
        a[2] = 2;
        a[3] = 5;
        a[4] = 4;

        System.out.println(Arrays.toString(a));

        MergeSort.sort(a);

        System.out.println(Arrays.toString(a));

    }
}