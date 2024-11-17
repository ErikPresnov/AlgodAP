package Kuhjad;

import ee.ut.dendroloj.Dendrologist;

public class Praks1 {
    public static void main(String[] args) {
        int[] arvud = {1,2,3,4,5,6,7,8,9,10};
        Tipp puuna = teePuu(arvud,0);
        kuvaKahendpuu(puuna);
    }

    static void kuvaKahendpuu(Tipp juurTipp) {
        Dendrologist.drawBinaryTree(juurTipp, t -> t.info, t -> t.v, t -> t.p);
    }

    public static int vasak(int l, int k) {
        int i = 2 * k + 1;
        return i < l ? i : -1;
    }

    public static int parem(int l, int k) {
        int i = 2 * k + 2;
        return i < l ? i : -1;
    }

    public static int ylem(int k) {
        return k <= 0 ? -1 : (k - 1) / 2;
    }

    public static Tipp teePuu(int[] kuhi, int i) {
        if (i >= kuhi.length || i == -1) return null;
        Tipp praegune = new Tipp(String.valueOf(kuhi[i]));

        praegune.v = teePuu(kuhi, vasak(kuhi.length, i));
        praegune.p = teePuu(kuhi, parem(kuhi.length, i));

        return praegune;
    }

    public static void yles(int[] kuhi, int i) {
        int ylem = ylem(i);
        while (ylem != -1 && kuhi[ylem] < kuhi[i]) {
            int ajutine = kuhi[ylem];
            kuhi[ylem] = kuhi[i];
            kuhi[i] = ajutine;
            i = ylem;
            ylem = ylem(i);
        }
    }

    public static void alla(int[] kuhi, int i) {
        int vasak = vasak(kuhi.length, i), parem = parem(kuhi.length, i);
        while (vasak != -1 && parem != -1) { // kuni on mõlemad alluvad
            int max = i;

            if (kuhi[vasak] > kuhi[max]) max = vasak;
            if (kuhi[parem] > kuhi[max]) max = parem;

            if (max != i) {
                int ajutine = kuhi[i];
                kuhi[i] = kuhi[max];
                kuhi[max] = ajutine;
                i = max;
                vasak = vasak(kuhi.length, i);
                parem = parem(kuhi.length, i);
            } else break;
        }
    }
}
