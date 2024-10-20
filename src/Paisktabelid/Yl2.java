package Paisktabelid;

import java.util.*;
import java.util.stream.Collectors;

public class Yl2 {

    public static void main(String[] args) {
        LinkedList<Integer> l = new Random().ints(100_000, 0, 100_000).boxed().collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Integer> koopia = new LinkedList<>(l);


        long s, e;
        s = System.nanoTime();
        eemaldaT(l);
        e = System.nanoTime();
        System.out.printf("Tsükliga %.2f %d%n", (e-s)/1e9, l.size());

        s = System.nanoTime();
        eemaldaH(koopia);
        e = System.nanoTime();
        System.out.printf("Hulgaga  %.2f %d%n", (e-s)/1e9, koopia.size());
    }

    public static void eemaldaT(LinkedList<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        List<Integer> nahtud = new ArrayList<>();
        while (iter.hasNext()) {
            int elem = iter.next();
            if (nahtud.contains(elem)) iter.remove();
            else nahtud.add(elem);
        }
    }

    public static void eemaldaH(LinkedList<Integer> list) {
        Iterator<Integer> iter = list.iterator();
        Set<Integer> nahtud = new HashSet<>();
        while (iter.hasNext()) {
            int elem = iter.next();
            if (nahtud.contains(elem)) iter.remove();
            else nahtud.add(elem);
        }
    }
}
