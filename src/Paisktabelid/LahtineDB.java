package Paisktabelid;

import java.util.Arrays;

public class LahtineDB {
    private int n;
    private int kompeSamm = 1;
    private Isik[] andmed;
    private static final double T = (Math.sqrt(5) - 1)/2;

    public LahtineDB(int n) {
        this.n = n;
        this.andmed = new Isik[n];
    }

    private int hash(int id) {
        return (int) (n*(id * T - Math.floor(id * T)));
    }

    public void lisa(Isik isik) {
        int hash = hash(isik.ID);
        while (andmed[hash] != null) {
            System.out.printf("Isik IDga %d sattus kohale %d, kus on isik IDga %d%n", isik.ID, hash, andmed[hash].ID);
            hash = (hash + kompeSamm) % n;
        }
        andmed[hash] = isik;
    }

    public Isik otsi(int id) {
        int hash = hash(id);
        while (andmed[hash] != null) {
            if (andmed[hash].ID == id) return andmed[hash];
            else hash = (hash + kompeSamm) % n;
        }
        return null;
    }

    public Isik eemalda(int id) {
        int hash = hash(id);
        while (andmed[hash] != null) {
            if (andmed[hash].ID == id) {
                Isik tulemus = andmed[hash];
                andmed[hash] = null;
                hash = (hash + kompeSamm) % n;;
                while (andmed[hash] != null) {
                    Isik ajutine = andmed[hash];
                    andmed[hash] = null;
                    lisa(ajutine);
                    hash = (hash + kompeSamm) % n;;
                }
                return tulemus;
            } else hash = (hash + kompeSamm) % n;;
        }
        return null;
    }

    public static void main(String[] args) {
        // Testimine
        LahtineDB db = new LahtineDB(10);
        System.out.println(Arrays.toString(db.andmed));

        db.lisa(new Isik(1,"", 1, 1));
        db.lisa(new Isik(2,"", 1, 1));
        db.lisa(new Isik(3,"", 1, 1));
        db.lisa(new Isik(4,"", 1, 1));
        db.lisa(new Isik(5,"", 1, 1));
        db.lisa(new Isik(6,"", 1, 1));
        db.lisa(new Isik(7,"", 1, 1));
        db.lisa(new Isik(8,"", 1, 1));
        db.lisa(new Isik(11,"", 1, 1));
        System.out.println(Arrays.toString(db.andmed));

        System.out.println(db.otsi(11));
        System.out.println(db.otsi(12));

        System.out.println(db.eemalda(3));
        System.out.println(Arrays.toString(db.andmed));
    }
}
