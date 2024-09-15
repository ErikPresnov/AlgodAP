package Praks2;

public class Jagatised {

    public static void main(String[] args) {
        /*
        int n = 1000;
        System.out.println("\t\t\t\tT(n)/n\t\tT(n)/n^2\tT(n)/n^3\tT(n)/n^4\tT(n)/2^n");
        while (n <= 5000) {
            long s = System.nanoTime();
            long t = kuup(n);
            long e = System.nanoTime();

            double aeg = (e - s);
            System.out.printf("%d -> %.2f\t%.4f\t%.4f\t\t%.4f\t\t%.4f\t\t%.4f%n", n, aeg/1e9, aeg/n, aeg/Math.pow(n, 2), aeg/Math.pow(n, 3), aeg/Math.pow(n, 4), aeg/Math.pow(2, n));
            // Ül point ->
            //      Kui me alahindame (st jagame nt N või N^2), siis on tulemuseks kasvav jada
            //      kui me jagame konstandi täpsusega õige funktisooniga siis on tulemused mingist lõigust
            //      kui me ülehindame (st jagame nt 2^N), siis on tulemuseks hääbuv (või 0) jada
            n += 250;
        }*/

        // 3900 -> 1.027s --> n et aeg oleks 30s? --> sisend peaks suurenema 3.07x --> sisend peaks olema 12000
        /*
        long aeg = 0, start = 0, end = 0, n;
        int i = 1000;
        while (aeg < 30000) {
            start = System.currentTimeMillis();
            n = kuup(i);
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %dms.%n", i, aeg);
            i += 1000;
        }*/

        int n = 7;
        while (n <= 20) {
            long s = System.nanoTime();
            int t = tundmatu(n);
            long e = System.nanoTime();

            double aeg = (e - s);
            System.out.printf("%d ->\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f\t%.4f%n", n, aeg/n, aeg/Math.pow(n, 2), aeg/Math.pow(n, 3), aeg/Math.pow(n, 4), aeg/Math.pow(2, n), aeg/Math.pow(3, n), aeg/fakt(n));
            n++;
        }
    }

    public static double fakt(int n) {
        double result = 1;
        int i = 2;
        while (i <= n) result *= i++;
        return result;
    }

    public static long kuup(int n) {
        long s = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    s++;

        return s;
    }

    public static int tundmatu(int n) {
        if (n == 0) return 1;

        int sum = 0;
        for (int i = 0; i < n; i++) sum += tundmatu(n - 1);
        return sum;
    }
}
