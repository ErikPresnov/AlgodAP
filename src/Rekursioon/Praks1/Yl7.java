package Rekursioon.Praks1;

public class Yl7 {
    public static void main(String[] args) {
        System.out.println(hanoi(3));
    }

    public static int hanoi(int n) {
        if (n == 1) return 1;
        return 2 * hanoi(n - 1) + 1;
    }
}
