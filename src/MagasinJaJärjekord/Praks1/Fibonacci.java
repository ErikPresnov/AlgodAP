package MagasinJaJärjekord.Praks1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibRek(5));
        System.out.println(fibMagasin(5));
        System.out.println(fibJarjekord(5));
    }

    public static int fibRek(int n) {
        if (n < 2) return n;
        return fibRek(n - 1) + fibRek(n - 2);
    }

    public static int fibMagasin(int n) {
        Deque<Integer> magasin = new ArrayDeque<>();
        magasin.push(n);

        int summa = 0;

        while (!magasin.isEmpty()) {
            int praegune = magasin.pop();
            if (praegune < 2) summa += praegune;
            else {
                magasin.push(praegune - 1);
                magasin.push(praegune - 2);
            }
        }

        return summa;
    }

    public static int fibJarjekord(int n) {
        return 0;
    }
}
