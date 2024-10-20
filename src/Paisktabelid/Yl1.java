package Paisktabelid;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Yl1 {

    public static void main(String[] args) {
        int[] ar1 = new Random().ints(100_000, 0, 1_000_000).toArray();
        int[] ar2 = new Random().ints(100_000, 0, 1_000_000).toArray();

        long s, e, t;
        s = System.nanoTime();
        t = yhisedT(ar1, ar2);
        e = System.nanoTime();

        System.out.printf("Tsükliga %d %.2f%n", t, (e-s)/1e9);

        s = System.nanoTime();
        t = yhisedH(ar1, ar2);
        e = System.nanoTime();

        System.out.printf("Hulgaga  %d %.2f%n", t, (e-s)/1e9);
    }

    public static int yhisedT(int[] e, int[] t) {
        int loendur = 0;

        for (int i = 0; i < e.length; i++) {
            boolean esimene = true;
            for (int j = 0; j < i && esimene; j++)
                if (e[i] == e[j]) esimene = false;

            if (!esimene) continue;
            for (int k : t) {
                if (e[i] == k) {
                    loendur++;
                    break;
                }
            }
        }

        return loendur;
    }

    public static int yhisedH(int[] e, int[] t) {
        Set<Integer> eH = new HashSet<>();
        for (int i : e) eH.add(i);

        Set<Integer> tH = new HashSet<>();
        for (int i : t) tH.add(i);

        eH.retainAll(tH);

        return eH.size();
    }
}
