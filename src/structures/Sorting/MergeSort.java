package Sorting;

// CS-2920
// Merge Sort ADT

public class MergeSort {

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        for(int k = lo; k <= hi; k++){
            aux[k] = a[k];
        }
        int i = lo;
        int j = mid+1;
        for(int k = lo; k<=hi; k++){
            if(i > mid){a[k] = aux[j++];}
            else if(j > hi){a[k] = aux[i++];} // nothing left in lo-mid
            else if(less(aux[j], aux[i])){a[k] = aux[j++];} // nothing left in (mid+1)-hi
            else {a[k] = aux[i++];} // regular comparison
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        // if(hi <= lo){return;} <- replaced for practical improvement: insertion sort on small subarrays
        int CUTOFF = 10; // cutoff for insertion sort ~10 items
        if(hi <= lo + CUTOFF - 1){
            InsertionSort.sort(a);
            return;
        }
        int mid = lo + (hi-lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if(!less(a[mid+1], a[mid])){ // practical improvement: stop if already sorted
            return;
        }
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }
}

