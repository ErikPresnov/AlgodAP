package Puud;

import ee.ut.dendroloj.Dendrologist;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Yl3 {
    public static void main(String[] args) {
        //Tipp juur = new Tipp("A", new Tipp("B", null, new Tipp("D")), new Tipp("C", new Tipp("E", new Tipp("G"), null), new Tipp("F", new Tipp("H"), null)));
        Tipp juur = new Tipp("A", new Tipp("B", new Tipp("D"), new Tipp("E")), new Tipp("C", new Tipp("F"), new Tipp("G")));
        kuvaKahendpuu(juur);
        //prindiK(juur, 0);
    }
    static void kuvaKahendpuu(Tipp juurTipp) {
        Dendrologist.drawBinaryTree(juurTipp, t -> t.info, t -> t.v, t -> t.p);
    }
    static Tipp juhuslikPuu(int n) {
        if (n == 0) return null;
        Random juhus = ThreadLocalRandom.current();
        String juhuslikTäht = Character.toString(juhus.nextInt('A', 'Z' + 1));
        int vasakule = juhus.nextInt(n);
        return new Tipp(juhuslikTäht, juhuslikPuu(vasakule), juhuslikPuu(n - 1 - vasakule));
    }

    public static void prindiK(Tipp juur, int s) {
        if (juur == null) return;
        prindiK(juur.p, s + 1);
        System.out.println("\t".repeat(s) + juur.info);
        prindiK(juur.v, s + 1);
    }


}
