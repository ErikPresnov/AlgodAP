package AjalineKeerukus.Praks1;

public class BitGen {
    public static void main(String[] args) {
        // Minu arvuti -> 25 -> 0.862 sek -> ennustuse järgi 30, reaalselt võtab 30 natuke liiga palju või oleneb jooksutusest idk
        // Teeta(n * 2^n) -> n suurendamine 1 võrra ~ 2X rohkem tööd
        // Jagatis läbi teha -> 2 + 2/n korda suureneb töö
        long aeg = 0, start = 0, end = 0;
        int i = 20, n = 0;
        while (aeg < 30000) {
            start = System.currentTimeMillis();
            n = bitgen(i, "");
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %d -> %dms.%n", i++, n, aeg);
        }
    }

    public static int bitgen(int n, String s) {
        if (s.length() == n) return 1;
        return bitgen(n, s + "0") + bitgen(n, s + "1");
    }
}
