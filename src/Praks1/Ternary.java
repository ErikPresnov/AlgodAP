package Praks1;

public class Ternary {

    public static void main(String[] args) {
        for (int i = 10; i <= 20; i++) {
            int[] massiiv2 = new int[i];

            long s1 = System.nanoTime();
            int tulemus1 = abi1(new int[0], i);
            long e1 = System.nanoTime();

            long s2 = System.nanoTime();
            int tulemus2 = abi2(massiiv2, 0);
            long e2 = System.nanoTime();

            // Kui aegade suhe tuleb mustriga suur väike suur väike siis tuleb inline maha võtta.
            //System.out.printf("Sisend %d Tulemus %d Aega läks %.2fms %.2fms Aegade suhe %.2f%n", i, tulemus1, (e1-s1)/1e6, (e2-s2)/1e6, (1.0*(e1-s1)/(e2-s2)));

            System.out.printf("T1/(n*3^n) => %.2f \t T2/n^3 => %.2f%n", (e1-s1)/(i * Math.pow(3, i)), (e2-s2)/Math.pow(3, i));
        }
    }

    public static int abi1(int[] a, int n) {
        if (n == 0) return 1;
        return abi1(lisa(a, 0), n - 1) + abi1(lisa(a, 1), n - 1) + abi1(lisa(a, 2), n - 1);
    }

    public static int[] lisa(int[] a, int n) {
        int[] uus = new int[a.length + 1];

        int i = 0;
        for (; i < a.length; i++) uus[i] = a[i];
        uus[i] = n;

        return uus;
    }

    public static int abi2(int[] a, int i) {
        if (i == a.length) return 1;
        int summa = 0;

        a[i] = 0;
        summa += abi2(a, i + 1);
        a[i] = 1;
        summa += abi2(a, i + 1);
        a[i] = 2;
        summa += abi2(a, i + 1);
        a[i] = 0;

        return summa;
    }
}
