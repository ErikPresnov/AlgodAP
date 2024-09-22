package AjalineKeerukus.Praks1;

public class DnaGen {

    public static void main(String[] args) {
        // Minu arvuti -> 12 -> 0.462 sek -> ennustuse järgi 15 v 16
        // Teeta(n * 4^n) -> n suurendamine 1 võrra ~ 4X rohkem tööd
        // Jagatis läbi teha -> 4 + 4/n korda suureneb töö
        long aeg = 0, start = 0, end = 0;
        int i = 5;
        while (aeg < 30000) {
            start = System.currentTimeMillis();
            dna(i, "");
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %dms.%n", i++, aeg);
        }
    }

    public static void dna(int n, String dna) {
        if (n == 0) return;
        else {
            dna(n - 1, dna + "A");
            dna(n - 1, dna + "T");
            dna(n - 1, dna + "C");
            dna(n - 1, dna + "G");
        }
    }

}
