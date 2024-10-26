package Paisktabelid;

import java.util.*;

public class BucketSort {

    public static void main(String[] args) {
        Isik[] isikud = new Isik[10];
        for (int i = 0; i < 10; i++) isikud[i] = new Isik(new Random().nextInt(0,100), "", 0, 0);
        System.out.println(Arrays.toString(isikud));
        sort(isikud);
        System.out.println(Arrays.toString(isikud));
    }

    public static int h(int k, int a, int b, int m) {
        return m * (k - a) / (b - a);
    }

    public static void sort(Isik[] isikud) {
        ArrayList<Isik>[] tabel = new ArrayList[isikud.length];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < isikud.length; i++) {
            tabel[i] = new ArrayList<>();
            min = Math.min(min, isikud[i].ID);
            max = Math.max(max, isikud[i].ID);
        }

        for (Isik isik : isikud) tabel[h(isik.ID, min, max + 1, isikud.length)].add(0, isik);

        int ptr = 0;
        for (ArrayList<Isik> kimp : tabel) {
            System.out.println(kimp.size());
            kimp.sort(Comparator.comparingInt(o -> o.ID));
            for (Isik isik : kimp) isikud[ptr++] = isik;
        }
    }
}
