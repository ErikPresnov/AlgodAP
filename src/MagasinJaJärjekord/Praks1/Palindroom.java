package MagasinJaJärjekord.Praks1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Palindroom {

    public static void main(String[] args) {
        System.out.println(onPalindroom("kirik"));
        System.out.println(onPalindroom("aduda"));
        System.out.println(onPalindroom("kuulilennuteetunneliluuk"));
        System.out.println(onPalindroom("As I pee, sir, I see Pisa!"));
        System.out.println(onPalindroom("A man, a plan, a canal: Panama!"));
    }

    public static boolean onPalindroom(String s) {
        Deque<Character> magasin = new ArrayDeque<>();
        s = s.toLowerCase().replaceAll("[^a-zA-Z]", "");

        for (int i = 0; i < s.length() / 2; i++)
            magasin.push(s.charAt(i));

        for (int i = s.length() / 2 + s.length() % 2; i < s.length(); i++)
            if (magasin.pop() != s.charAt(i)) return false;

        return true;
    }
}
