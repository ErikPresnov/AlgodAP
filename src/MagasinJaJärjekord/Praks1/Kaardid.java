package MagasinJaJärjekord.Praks1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Kaardid {

    public static void main(String[] args) {
        String[] mastid = {"ruutu", "ärtu", "pada", "risti"};
        String[] numbrid = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] algne = new String[36];
        int i = 0;
        for (String mast : mastid) for (String nr : numbrid) algne[i++] = mast + " " + nr;

        System.out.println(leiaAlgne(algne));
    }

    public static int leiaAlgne(String[] algne) {
        int i = 1;
        String[] koopia = new String[algne.length];
        System.arraycopy(algne, 0, koopia, 0, algne.length);
        paigutaYmber(koopia);

        while (!onSamad(algne, koopia)) {
            paigutaYmber(koopia);
            i++;
        }
        return i;
    }

    public static boolean onSamad(String[] esimene, String[] teine) {
        for (int i = 0; i < esimene.length; i++) if (!esimene[i].equals(teine[i])) return false;

        return true;
    }

    public static void paigutaYmber(String[] arr, int i) {
        for (int j = 0; j < i; j++) paigutaYmber(arr);
    }

    public static void paigutaYmber(String[] arr) {
        Queue<Queue<String>> jrk = new ArrayDeque<>();
        for (int i = 0; i < 9; i++) jrk.add(new ArrayDeque<>());
        int i = 0;
        while (i < 36) {
            Queue<String> vahepealne = jrk.remove();
            vahepealne.add(arr[i++]);
            jrk.add(vahepealne);
        }

        i = 0;
        for (Queue<String> s : jrk) while (!s.isEmpty()) arr[i++] = s.remove();
    }
}
