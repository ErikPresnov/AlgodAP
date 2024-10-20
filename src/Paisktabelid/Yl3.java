package Paisktabelid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Yl3 {

    public static void main(String[] args) {
        int[] arr = new Random().ints(500_000, 0, 100_000_000).toArray();
        long s, e, n;

        n = arr[(int) (Math.random()*500000)] + arr[(int) (Math.random()*500000)];
        System.out.println("Otsime summat " + n);
        int[] v;

        s = System.nanoTime();
        v = summaNT(arr, (int) n);
        e = System.nanoTime();
        System.out.println((e-s)/1e9);
        if (v != null) {
            System.out.println(Arrays.toString(v));
            System.out.println(arr[v[0]] + " " + arr[v[1]]);
        }
        s = System.nanoTime();
        v = summaNH(arr, (int) n);
        e = System.nanoTime();
        System.out.println((e-s)/1e9);
        if (v != null) {
            System.out.println(Arrays.toString(v));
            System.out.println(arr[v[0]] + " " + arr[v[1]]);
        }
    }

    public static int[] summaNT(int[] arvud, int n) {
        for (int i = 0; i < arvud.length; i++)
            for (int j = i + 1; j < arvud.length; j++)
                if (arvud[i] + arvud[j] == n)
                    return new int[]{i,j};

        return null;
    }
    
    public static int[] summaNH(int[] arvud, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arvud.length; i++) {
            if (map.containsKey(n - arvud[i]))
                return new int[]{map.get(n - arvud[i]), i};
            map.put(arvud[i], i);
        }
        
        return null;
    }
}
