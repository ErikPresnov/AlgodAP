package Rekursioon.Praks1;

import java.util.Random;

public class Yl8 {
    static int vordlusi;

    public static void main(String[] args) {
        Random r = new Random();
        for (int suurus = 100000; suurus <= 100_000; suurus += 1000) {
            //for (int katse = 0; katse < 10; katse++) {
                int[] arr = r.ints(suurus, 0, 100_000).toArray();
                quickSort(arr, 0, arr.length - 1);
            //}
            System.out.printf("%d -> %d võrdlust%n", suurus, vordlusi);
            vordlusi = 0;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    // Iga väljakutse teeb high - low elementide võrdlust ->
    // ühel ja samal sügavusel oledvad väljakutsed teevad n võrdlust ->
    // kokku n log n võrdlust
    // Sisend 2 x : töö 2.midagi x
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++)
            if (arr[j] < pivot) {
                vordlusi++;
                swap(arr, ++i, j);
            }

        swap(arr, i + 1, high);
        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
