package Paisktabelid;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KimbugaDB {
    private int n;
    private List<Isik>[] andmed;
    private static final double T = (Math.sqrt(5) - 1)/2;

    public KimbugaDB(int n) {
        this.n = n;
        this.andmed = new List[n];
        for (int i = 0; i < n; i++) andmed[i] = new LinkedList<>();
    }

    private int hash(int id) {
        return (int) (n*(id * T - Math.floor(id * T)));
    }

    public void lisa(Isik isik) {
        int hash = hash(isik.ID);
        andmed[hash].add(isik);
    }

    public Isik otsi(int id) {
        int hash = hash(id);
        for (Isik isik : andmed[hash]) if (isik.ID == id) return isik;
        return null;
    }

    public Isik eemalda(int id) {
        int hash = hash(id);
        Iterator<Isik> iter = andmed[hash].iterator();
        while (iter.hasNext()) {
            Isik praegune = iter.next();
            if (praegune.ID == id) {
                iter.remove();
                return praegune;
            }
        }
        return null;
    }
}
