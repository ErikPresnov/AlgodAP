package Puud;

import ee.ut.dendroloj.Dendrologist;

public class Yl5 {

    public static void main(String[] args) {
        KOTipp juur = genePuu(3);
        int tippe = tippe(juur);
        int[] massiiv = new int[tippe];
        for (int i = 0; i < tippe; i++) massiiv[i] = i;
        taida(massiiv, juur, 0);
        kuvaKahendotsimispuu(juur);
    }

    // abi
    private static int tippe(KOTipp juur) {
        if (juur == null) return 0;
        return tippe(juur.v) + tippe(juur.p) + 1;
    }

    // 5
    public static KOTipp genePuu(int h) {
        if (h == 0) return null;
        if (h == 1) return new KOTipp(0);
        KOTipp vasak = genePuu(Math.random() < 0.5 ? h - 1 : h - 2);
        KOTipp parem = genePuu(Math.random() < 0.5 ? h - 1 : h - 2);
        return new KOTipp(0, vasak, parem);
    }

    // 6
    public static int taida(int[] massiiv, KOTipp juur, int i) {
        if (juur == null) return i;
        i = taida(massiiv, juur.v, i);
        juur.väärtus = massiiv[i++];
        return taida(massiiv, juur.p, i);
    }

    // 7
    public static int min(KOTipp juur) {
        while (juur.v != null) juur = juur.v;
        return juur.väärtus;
    }

    // 8.1 otsimine
    public static KOTipp otsi(KOTipp juur, int otsitav) {
        if (juur == null) return null;
        if (otsitav == juur.väärtus) return juur;
        else if (otsitav > juur.väärtus) return otsi(juur.p, otsitav);
        return otsi(juur.v, otsitav);
    }

    // 8.2 lisamine
    public static KOTipp lisa(KOTipp juur, int lisatav) {
        if (juur == null) return new KOTipp(lisatav);

        if (lisatav > juur.väärtus) juur.v = lisa(juur.v, lisatav);
        else juur.p = lisa(juur.p, lisatav);

        return juur;
    }

    // 8.3
    public static KOTipp eemalda(KOTipp juur, int eemaldatav) {
        if (juur == null) return null;
        if (juur.v == null && juur.p == null) { // leht
            if (juur.väärtus == eemaldatav) return null;
            return juur;
        }
        if (juur.v == null) // sisetipp millel on ainult parem alluv
            return juur.p;
        if (juur.p == null) // sisetipp millel on ainult vasak alluv
            return juur.v;

        // molemad alluvad on olemas
        int min = min(juur.p);
        juur.väärtus = min;
        juur.p = eemalda(juur.p, min);
        return juur;
    }

    static void kuvaKahendotsimispuu(KOTipp juurTipp) {
        Dendrologist.drawBinaryTree(juurTipp, t -> Integer.toString(t.väärtus), t -> t.v, t -> t.p);
    }
}
