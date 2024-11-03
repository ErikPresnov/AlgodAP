package Puud;

public class Yl4 {
    public static void main(String[] args) {
        Tipp juur = new Tipp("A", new Tipp("B", new Tipp("D"), new Tipp("E")), new Tipp("C", new Tipp("F"), new Tipp("G")));
        margendaKesk(juur, 0);
        Yl1.kuvaKahendpuu(juur, true);
    }

    // 4.1
    public static String sonestaSulgudeta(Tipp juur, String vanemaTehe) {
        if (juur == null) return ""; // teoorias ei tohiks kunagi juhtuda aga intellij rahulduseks las olla siin
        if (juur.v == null && juur.p == null) // leht tippudes on arvud
            return juur.info;

        String vasakAvaldis = sonestaSulgudeta(juur.v, juur.info);
        String paremAvaldis = sonestaSulgudeta(juur.p, juur.info);

        int eelmiseTehtePrioriteet = leiaPrioriteet(vanemaTehe);
        int praegunePrioriteet = leiaPrioriteet(juur.info);
        if (praegunePrioriteet < eelmiseTehtePrioriteet)
            return "(" + vasakAvaldis + " " + juur.info + " " + paremAvaldis + ")";
        return vasakAvaldis + " " + juur.info + " " + paremAvaldis;
    }

    // 4.1 abi
    public static int leiaPrioriteet(String tehe) {
        return switch (tehe) {
            case "+", "-" -> 1;
            case "*" -> 2;
            default -> Integer.MIN_VALUE;
        };
    }

    // 4.2
    public static Tipp peegelda(Tipp juur) {
        if (juur == null) return null;
        Tipp vasak = juur.v;
        juur.v = peegelda(juur.p);
        juur.p = peegelda(vasak);
        return juur;
    }

    // 4.3
    public static Tipp kopeeriLehtedeta(Tipp juur) {
        if (juur == null) return null;
        if (juur.v == null && juur.p == null) // leht tipp kaob ära
            return null;
        return new Tipp(juur.info, kopeeriLehtedeta(juur.v), kopeeriLehtedeta(juur.p));
    }

    public static boolean onSym(Tipp juur) {
        if (juur.v == null && juur.p == null) return true;
        if (juur.v == null || juur.p == null) return false;
        return juur.v.info.equals(juur.p.info) && onSym(juur.v) && onSym(juur.p);
    }

    // 4.5
    public static void prindiVordsedTipud(Tipp juur) {
        if (juur == null) return;
        if (tippe(juur.v) == tippe(juur.p)) System.out.println(juur.info);
        prindiVordsedTipud(juur.v);
        prindiVordsedTipud(juur.p);
    }

    // 4.5 abi
    private static int tippe(Tipp juur) {
        if (juur == null) return 0;
        return tippe(juur.v) + tippe(juur.p) + 1;
    }

    // 4.6
    public static int margendaKesk(Tipp juur, int mitmes) {
        if (juur == null) return mitmes;
        int uus = margendaKesk(juur.v, mitmes);
        juur.x = uus;
        uus = margendaKesk(juur.p, uus + 1);
        return uus;
    }

}
