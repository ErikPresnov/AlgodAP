package MagasinJaJärjekord.Praks1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Random;

public class QS {

    public static void main(String[] args) {
        int[] arvud = new Random().ints(100_000, 0, 100_000_000).toArray();
        Arrays.sort(arvud);
        quickSortMagasiniga(arvud, 0, arvud.length - 1);
    }

    public static void quickSortMagasiniga(int[] arr, int begin, int end) {
        if (end <= begin) return;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(begin);
        stack.push(end);

        while (!stack.isEmpty()) {
            end = stack.pop();
            begin = stack.pop();
            if (end <= begin) continue;
            int partition = partition(arr, begin, end);
            stack.push(begin);
            stack.push(partition - 1);
            stack.push(partition + 1);
            stack.push(end);
        }
    }

    public static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        int i = (begin-1);

        for (int j = begin + 1; j < end; j++)
            if (arr[j] <= pivot)
                swap(arr, ++i, j);

        swap(arr, i + 1, end);
        return i+1;
    }

    private static void swap(int[] arr, int a, int b) {
        int swapTemp = arr[a];
        arr[a] = arr[b];
        arr[b] = swapTemp;
    }
}
