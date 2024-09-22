package Rekursioon.Praks1;

import java.util.Arrays;
import java.util.Random;

public class Yl5 {

    public static void main(String[] args) {
        Random r = new Random();
        int[] kaalud = r.ints(10, 50, 100).toArray();
        System.out.println(Arrays.deepToString(jaotus(kaalud, 0, 0, new int[0], new int[0])));
    }


    // tagasuse formaat = [[vahe],[vasak],[parem]]
    public static int[][] jaotus(int[] kaalud, int i, int vahe, int[] vasak, int[] parem) {
        if (i == kaalud.length) return new int[][]{{Math.abs(vahe)},vasak,parem};
        int[][] vasakJaotus = jaotus(kaalud, i + 1, vahe - kaalud[i], lisa(vasak, kaalud[i]), parem);
        int[][] paremJaotus = jaotus(kaalud, i + 1, vahe + kaalud[i], vasak, lisa(parem, kaalud[i]));
        if (vasakJaotus[0][0] < paremJaotus[0][0]) return vasakJaotus;
        return paremJaotus;
    }

    private static int[] lisa(int[] arr, int i) {
        int[] uus = new int[arr.length + 1];

        System.arraycopy(arr, 0, uus, 0, arr.length);
        uus[arr.length] = i;

        return uus;
    }
}
