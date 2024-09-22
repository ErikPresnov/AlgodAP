package Rekursioon.Praks1;

public class Yl6 {

    public static void main(String[] args) {
        kkombi(new int[]{1,2,3,4,5}, 3, "", 0);
    }

    public static void kkombi(int[] arvud, int k, String tee, int i) {
        if (k == 0) System.out.println(tee.strip());
        else {
            for (;i < arvud.length; i++)
                kkombi(eemalda(arvud, i), k - 1, tee + " " + arvud[i], i);
        }
    }

    private static int[] eemalda(int[] arvud, int indeks) {
        int[] uus = new int[arvud.length - 1];

        System.arraycopy(arvud,0, uus, 0, indeks);
        System.arraycopy(arvud,indeks + 1, uus, indeks, uus.length - indeks);

        return uus;
    }
}
