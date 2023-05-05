import java.util.Random;

import static java.lang.System.arraycopy;

public class SortMain {
    public static void main(String[] args) {
        int size = 1000;
        Integer[] list = new Integer[size];
        Integer[] list2 = new Integer[size];
        Random rnd = new Random();
        MergeSortTask<Integer> ms;

        /*
        for (int i = 0; i < size; i++) {
            list[i] = rnd.nextInt(100);
        }
        */

        for (int i = 0; i < size; i++) {
            list[i] = size - i;
        }

        arraycopy(list,0,list2,0,list.length);

        printList(list);
        ms = new MergeSortTask<>(0,list.length - 1, list);

        ms.insertionSort(list2);
        printList(list2);


        ms.compute();
        printList(list);

        ms.insertionSort(list);
        printList(list);


    }

    public static void printList(Integer[] l) {
        StringBuilder sb = new StringBuilder("[ ");

        for (int i = 0; i < l.length; i++) {
            sb.append(l[i] + " ");
        }

        sb.append("]");

        System.out.println(sb.toString());
    }
}
