package Kuhjad;

class Tipp {
    String info;
    Tipp v;
    Tipp p;
    int x; // abiväli

    Tipp(String info, Tipp v, Tipp p) {
        this.info = info;
        this.v = v;
        this.p = p;
    }

    public Tipp(String info) {
        this.info = info;
    }
}