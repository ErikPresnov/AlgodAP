package Praks1;

public class Fibonacci {

    public static void main(String[] args) {
        // A -> suurim i, mille korral tuleb tulemus alla 1 sekundi

        System.out.println("Rekursiivne");
        long aeg = 0, start = 0, end = 0;
        int i = 1, fib = 0;
        while (aeg < 1000) {
            start = System.currentTimeMillis();
            fib = fibo_rek(i);
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %d -> %dms.%n", i++, fib, aeg);
        }

        // B -> optimaalne algoritm, kui kaua võtab eelmise i

        i--;
        start = System.currentTimeMillis();
        fib = fibo_iter(i);
        end = System.currentTimeMillis();
        aeg = end - start;
        System.out.printf("%d -> %d -> %dms.%n", i, fib, aeg);

        // A -> suurim i, mille korral tuleb tulemus alla 1 sekundi

        System.out.println("\nIteratiivne");
        aeg = 0;
        i = 1;
        while (aeg < 1000) {
            start = System.currentTimeMillis();
            fib = fibo_iter(i);
            end = System.currentTimeMillis();
            aeg = end - start;
            System.out.printf("%d -> %d -> %dms.%n", i += 10000, fib, aeg);
        }
    }

    public static int fibo_rek(int n) {
        if (n < 2) return n;
        return fibo_rek(n - 1) + fibo_rek(n - 2);
    }

    public static int fibo_iter(int n) {
        int a = 0, b = 1;
        while (n-- > 1) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
