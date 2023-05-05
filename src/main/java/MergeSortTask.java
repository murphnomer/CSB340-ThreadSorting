import com.sun.scenario.effect.Merge;

import java.util.concurrent.*;

public class MergeSortTask<T extends Comparable> extends RecursiveAction {
    static final int THRESHOLD = 100;

    private int begin;
    private int end;
    private T[] array;

    public MergeSortTask(int begin, int end, T[] array) {
        this.begin = begin;
        this.end = end;
        this.array = array;
    }

    public void insertionSort(int begin,int end, T[] array) {
        T current;
        int j;

        for (int i = begin + 1; i < end; i++) {
            current = array[i];

            j = i;
            while (j >= begin + 1 && current.compareTo(array[j-1]) < 0) {
                array[j] = array[--j];
            }
            array[j] = current;
        }
    }

    public void compute() {
        if (end - begin < THRESHOLD) {
            insertionSort(begin, end, array);
        } else {
            int mid = (begin + end) / 2;

            MergeSortTask left = new MergeSortTask(begin, mid, array);
            MergeSortTask right = new MergeSortTask(mid + 1, end, array);

            left.fork();
            right.fork();

            merge(begin, mid, end, array);
        }
    }

    public void merge(int begin, int mid, int end, T[] array) {
        T leftBuffer;
        T rightBuffer;
        int lPtr = begin;
        int rPtr = mid + 1;
        int ptr = begin;
        boolean cmp;

        while (lPtr < mid && rPtr < end) {
            cmp = array[lPtr].compareTo(array[rPtr]) <= 0;
            if (cmp) {

            }
        }

    }


}
