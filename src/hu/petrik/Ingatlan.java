package hu.petrik;

public class Ingatlan {

    private String utca;
    private String varos;
    private int iranyitoSzam;
    private int szobaSzam;
    private int terulet;
    private String tipus;
    private int ar;

    public Ingatlan(String utca, String varos, int iranyitoSzam, int szobaSzam, int terulet, String tipus, int ar) {
        this.utca = utca;
        this.varos = varos;
        this.iranyitoSzam = iranyitoSzam;
        this.szobaSzam = szobaSzam;
        this.terulet = terulet;
        this.tipus = tipus;
        this.ar = ar;
    }

    public Ingatlan(String adatSor){
        String[] adatok = adatSor.split(",");

        this.utca = adatok[0];
        this.varos = adatok[1];
        this.iranyitoSzam = Integer.valueOf(adatok[2]);
        this.szobaSzam = Integer.valueOf(adatok[4]);
        this.terulet = Integer.valueOf(adatok[6]);
        this.tipus = adatok[7];
        this.ar = Integer.valueOf(adatok[9]);
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public int getIranyitoSzam() {
        return iranyitoSzam;
    }

    public void setIranyitoSzam(int iranyitoSzam) {
        this.iranyitoSzam = iranyitoSzam;
    }

    public int getSzobaSzam() {
        return szobaSzam;
    }

    public void setSzobaSzam(int szobaSzam) {
        this.szobaSzam = szobaSzam;
    }

    public int getTerulet() {
        return terulet;
    }

    public void setTerulet(int terulet) {
        this.terulet = terulet;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public String toString() {
        return String.format("%-55s %-12s %8d db %11d nm %12d$",
                String.format("%d %s, %s", this.iranyitoSzam, this.varos, this.utca),
                this.tipus,
                this.szobaSzam,
                this.terulet,
                this.ar
        );
    }
}
