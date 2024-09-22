package AjalineKeerukus.Praks1;

public class PermGen {

    public static void main(String[] args) {
        // Minu arvuti -> 10 -> 0.554 sek -> ennustuse järgi 11, 12 on ~100 korda aeglasem ehk ~50 sek
        // Teeta(n * n!) -> n suurendamine 1 võrra ~ nX rohkem tööd
        // Jagatis läbi teha -> n + 2 + 2/n korda suureneb töö
        long aeg = 0, start = 0, end = 0;
        int i = 5;
        while (aeg < 30000) {
            start = System.currentTimeMillis();
            perm("A".repeat(i),"");
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %dms.%n", i++, aeg);
        }
    }

    public static void perm(String s, String olemas) {
        if (s.length() == 0) {
            //System.out.println(olemas);
        } else {
            for (int i = 0; i < s.length(); i++) {
                perm(s.substring(0, i) + s.substring(i + 1), olemas + s.charAt(i));
            }
        }
    }
}
