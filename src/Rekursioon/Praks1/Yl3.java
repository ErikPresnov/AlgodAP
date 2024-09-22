package Rekursioon.Praks1;

public class Yl3 {
    public static void main(String[] args) {
        int t = BitVekGen(5, 2, "", 1);
    }

    public static int BitVekGen(int n, int k, String tee, int mitmes) {
        if (n == 0) {
            System.out.println(mitmes + " " + tee);
            return mitmes + 1;
        } else {
            if (n - 1 >= k) mitmes = BitVekGen(n - 1, k, tee + "0", mitmes);
            if (k > 0) mitmes = BitVekGen(n - 1, k - 1, tee + "1", mitmes);
            return mitmes;
        }
    }
}
