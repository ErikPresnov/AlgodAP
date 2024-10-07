package MagasinJaJärjekord.Praks1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BitVek {

    public static void main(String[] args) {
        bitVek(3);
    }

    public static void bitVek(int n) {
        int[] massiiv = new int[n];
        Deque<Integer> indeksid = new ArrayDeque<>();
        indeksid.push(0);

        while (!indeksid.isEmpty()) {
            int indeks = indeksid.pop();
            if (indeks == n) System.out.println(Arrays.toString(massiiv));
            else {
                if (massiiv[indeks] == 0) {
                    massiiv[indeks] = 1;
                    indeksid.push(indeks);
                } else massiiv[indeks] = 0;
                indeksid.push(indeks + 1);
            }
        }
    }
}
