/******************************************************************************
 *
 *  Sorts a sequence of strings from standard input using heapsort.
 *
 ******************************************************************************/

package PQ;
import java.util.Scanner; // Import the Scanner class for input
import java.util.ArrayList; // For dynamic array to store input strings
import java.util.List;      // For the List interface

/**
 *  The {@code Heap} class provides a static method to sort an array
 *  using <em>heapsort</em>.
 *  <p>
 *  This implementation takes &Theta;(<em>n</em> log <em>n</em>) time
 *  to sort any array of length <em>n</em> (assuming comparisons
 *  take constant time). It makes at most
 *  2 <em>n</em> log<sub>2</sub> <em>n</em> compares.
 *  <p>
 *  This sorting algorithm is not stable.
 *  It uses &Theta;(1) extra memory (not including the input array).
 *  <p>
 *  For additional documentation, see
 *  <a href="https://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class Heap {

    // This class should not be instantiated.
    private Heap() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param pq the array to be sorted
     */
    public static void sort(Comparable[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n/2; k >= 1; k--)
            sink(pq, k, n);

        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(Comparable[] pq, int k, int n) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    /**
     * Helper method to print the array.
     */
    private static void show(String[] a) {
        for (String s : a) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputStrings = new ArrayList<>();

        System.out.println("--- Interactive HeapSort ---");
        System.out.println("Enter strings to be sorted. Press Enter on an empty line to finish input.");
        System.out.println("--------------------------");

        // Collect input strings
        while (true) {
            System.out.print("Enter string (or empty line to sort): ");
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break; // Exit loop if an empty line is entered
            }
            inputStrings.add(line);
        }

        // Convert the List to a String array
        String[] a = inputStrings.toArray(new String[0]);

        System.out.println("\n--- Original Input Array ---");
        show(a); // Show the array before sorting

        // Perform the HeapSort
        // Assuming Heap.sort() takes a Comparable[] or String[]
        Heap.sort(a); // Call your Heap.sort method

        System.out.println("\n--- Sorted Array ---");
        show(a); // Show the sorted array

        scanner.close(); // Close the scanner
    }
}
