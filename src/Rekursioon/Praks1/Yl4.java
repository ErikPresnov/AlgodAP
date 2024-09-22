package Rekursioon.Praks1;

import java.util.Arrays;

public class Yl4 {

    // Masiivi elementide arvu saab välja arvutada aga see vajaks indeksite tagastamist, mis teeks selle massiivi sisuliselt globaalseks
    public static void main(String[] args) {
        long s, e;
        int[] hinnad = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, t;
        s = System.nanoTime();
        t = voimalikudSummad(hinnad);
        e = System.nanoTime();
        System.out.println("Stringidena -> " + (e - s)/1e9);

        s = System.nanoTime();
        t = voimalikudSummad1(hinnad);
        e = System.nanoTime();
        System.out.println("Masiiivina -> " + (e - s)/1e9);
    }

    public static int[] voimalikudSummad1(int[] hinnad) {
        int[] t = abi1(hinnad, 0, 0);
        Arrays.sort(t);
        return t;
    }

    public static int[] abi1(int[] hinnad, int i, int summa) {
        if (i == hinnad.length) return new int[]{summa};
        return liida(abi1(hinnad, i + 1, summa), abi1(hinnad, i + 1, summa + hinnad[i]));
    }

    public static int[] liida(int[] arr, int[] arr1) {
        int[] uus = new int[arr.length + arr1.length];
        System.arraycopy(arr, 0, uus, 0, arr.length);
        System.arraycopy(arr1, 0, uus, arr.length, arr1.length);
        return uus;
    }

    public static int[] voimalikudSummad(int[] hinnad) {
        int[] t = Arrays.stream(abi(hinnad, 0, 0).strip().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(t);
        return t;
    }

    public static String abi(int[] hinnad, int i, int summa) {
        if (i == hinnad.length) return String.valueOf(summa);
        return abi(hinnad, i + 1, summa + hinnad[i]) + " " + abi(hinnad, i + 1, summa);
    }
}
