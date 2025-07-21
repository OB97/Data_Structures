// CS-2920
// Call Unit Tests from here

import structures.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Define your String arrays
        String[] QU = {"find()", "union()"};
        String[] mergeSort = {"sort()", "merge()"};
        String[] quickSort = {"partition()", "sort()", "exch()"};
        String[] priorityQueue = {"insert()", "delete()", "peek()", "isEmpty()"};
        String[] heapSort = {"swim()", "sink()", "insert()", "delete()"};

        // Use a HashMap to store the names and their corresponding String arrays
        Map<String, String[]> dataStructures = new HashMap<>();
        dataStructures.put("QU", QU);
        dataStructures.put("mergeSort", mergeSort);
        dataStructures.put("quickSort", quickSort);
        dataStructures.put("priorityQueue", priorityQueue);
        dataStructures.put("heapSort", heapSort);

        // Convert the keys (names) to an ArrayList to allow random access
        ArrayList<String> names = new ArrayList<>(dataStructures.keySet());

        Random r = new Random();
        Random q = new Random();

        // Get a random name
        String chosenName = names.get(r.nextInt(names.size()));

        // Retrieve the corresponding String array using the chosen name
        String[] chosenArray = dataStructures.get(chosenName);

        String chosenMethod = chosenArray[q.nextInt(chosenArray.length-1)];

        // Print the name and its contents
        System.out.println(chosenName + " " + chosenMethod);
    }
}