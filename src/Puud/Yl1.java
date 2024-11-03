package Puud;

import ee.ut.dendroloj.Dendrologist;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Yl1 {

    public static void main(String[] args) {

    }

    static void kuvaKahendpuu(Tipp juurTipp, boolean x) {
        if (x)
            Dendrologist.drawBinaryTree(juurTipp, t -> t.info + " " + t.x, t -> t.v, t -> t.p);
        else
            Dendrologist.drawBinaryTree(juurTipp, t -> t.info, t -> t.v, t -> t.p);
    }

    static Tipp juhuslikPuu(int n) {
        if (n == 0) return null;
        Random juhus = ThreadLocalRandom.current();
        String juhuslikTäht = Character.toString(juhus.nextInt('A', 'Z' + 1));
        int vasakule = juhus.nextInt(n);
        return new Tipp(juhuslikTäht, juhuslikPuu(vasakule), juhuslikPuu(n - 1 - vasakule));
    }

    public static int tippe(Tipp juur) {
        if (juur == null) return 0;
        int tippe = 1;
        tippe += tippe(juur.v);
        tippe += tippe(juur.p);
        return tippe;
    }

    public static int korgus(Tipp juur) {
        if (juur == null) return 0;
        return Math.max(korgus(juur.v), korgus(juur.p)) + 1;
    }

    public static void keskjarjestuses(Tipp juur) {
        if (juur == null) return;
        keskjarjestuses(juur.v);
        System.out.println(juur.info);
        keskjarjestuses(juur.p);
    }

    public static void lehed(Tipp juur) {
        if (juur == null) return;
        if (juur.v == null && juur.p == null) System.out.println(juur.info);
        else {
            lehed(juur.v);
            lehed(juur.p);
        }
    }
}
