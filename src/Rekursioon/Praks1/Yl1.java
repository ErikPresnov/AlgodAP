package Rekursioon.Praks1;

import java.util.Arrays;

public class Yl1 {

    public static void main(String[] args) {
        long s, e;
        double[] ajad = new double[2];
        s = System.nanoTime();
        BitVekGen1(30, 2, "");
        e = System.nanoTime();
        ajad[0] = (e - s)/1e9;

        s = System.nanoTime();
        BitVekGen2(30, 2, "");
        e = System.nanoTime();
        ajad[1] = (e - s)/1e9;

        System.out.println(Arrays.toString(ajad));
    }

    public static void BitVekGen1(int n, int k, String tee) {
        if (n == 0) {
            if (k == 0)
                System.out.println(tee);
        } else {
            BitVekGen1(n - 1, k, tee + "0");
            BitVekGen1(n - 1, k - 1, tee + "1");
        }
    }

    public static void BitVekGen2(int n, int k, String tee) {
        if (n == 0) {
            System.out.println(tee);
        } else {
            if (n - 1 >= k) BitVekGen2(n - 1, k, tee + "0");
            if (k > 0) BitVekGen2(n - 1, k - 1, tee + "1");
        }
    }
}
