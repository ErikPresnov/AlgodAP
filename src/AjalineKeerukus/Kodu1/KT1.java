package AjalineKeerukus.Kodu1;

import java.util.Random;

public class KT1 {
    public static void main(String[] args) {
        int n = 6500;
        Random r = new Random();
        for (int i = 1; i <= 10; i++) {
            int[] arr = r.ints(i * n, 0, Integer.MAX_VALUE).toArray();
            long s = System.currentTimeMillis();
            sort(arr);
            long e = System.currentTimeMillis();
            System.out.println((e - s));
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
