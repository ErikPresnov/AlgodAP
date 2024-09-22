package Rekursioon.Praks1;

public class Yl2 {
    public static void main(String[] args) {
        int n = 10;
        long s, e;
        double aeg = 0;
        while (aeg < 1e9) {
            s = System.nanoTime();
            long l = lahutused(n, "");
            e = System.nanoTime();
            aeg = e - s;
            System.out.printf("%d -> %d -> %.2f%n", n++, l, aeg/1e9);
        }
    }

    public static long lahutused(int n, String tee) {
        if (n < 0) return 0;
        if (n == 0) {
            //System.out.println(tee.strip());
            return 1;
        }
        return lahutused(n - 1, tee + " " + 1) +
               lahutused(n - 2, tee + " " + 2);
    }
}
