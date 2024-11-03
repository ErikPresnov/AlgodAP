package Puud;

import ee.ut.dendroloj.Dendrologist;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Yl2 {

    static void kuvaKahendpuu(Tipp juurTipp) {
        Dendrologist.drawBinaryTree(juurTipp, t -> t.info, t -> t.v, t -> t.p);
    }
    static Tipp juhuslikAvaldis(int n) {
        Random juhus = ThreadLocalRandom.current();
        if (n == 0) {
            return new Tipp(Integer.toString((juhus.nextBoolean() ? 1 : -1) * juhus.nextInt(1, 40)));
        }
        String tehe = switch (juhus.nextInt(3)) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            default -> throw new AssertionError("Võimatu juhuarv");
        };
        int vasakule = juhus.nextInt(n);
        return new Tipp(tehe, juhuslikAvaldis(vasakule), juhuslikAvaldis(n - 1 - vasakule));
    }

    public static void main(String[] args) {
        Tipp avaldis = juhuslikAvaldis(5);
        kuvaKahendpuu(avaldis);
        System.out.println(sonesta(avaldis));
        System.out.println(eval(avaldis));
    }

    /**
     * Naiivne lahendus, igal alluval on sulud ümber
     * Annab korrektse lahenduse aga sisaldab üleliigseid sulge
     * @param juur avaldisele vastav puu
     * @return avaldisele vastav sõneesitus
     */
    public static String sonesta(Tipp juur) {
        if (juur == null) return ""; // teoorias ei tohiks kunagi juhtuda aga intellij rahulduseks las olla siin
        if (juur.v == null && juur.p == null) // leht tippudes on arvud
            return juur.info;

        String vasakAvaldis = sonesta(juur.v);
        String paremAvaldis = sonesta(juur.p);
        return "(" + vasakAvaldis + ") " + juur.info + " (" + paremAvaldis + ")";
    }


    public static int eval(Tipp juur) {
        if (juur == null) throw new RuntimeException(); // ei tohiks kunagi juhtuda aga intellij rahulduseks las olla siin
        if (juur.v == null && juur.p == null) return Integer.parseInt(juur.info);
        return switch (juur.info) {
            case "+" -> eval(juur.v) + eval(juur.p);
            case "-" -> eval(juur.v) - eval(juur.p);
            case "*" -> eval(juur.v) * eval(juur.p);
            default -> throw new RuntimeException();
        };
    }
}
