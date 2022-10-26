package hu.petrik;

public class Main {

    public static void main(String[] args) {

        Ingatlanok I = new Ingatlanok("realestatetransactions.csv");

//        System.out.println(I);

        System.out.println("legnagyobb");
        System.out.println(I.getLegnagyobbIngatlan());

        System.out.println("összeg");
        System.out.println(I.getOsszIngatlanErtek());


        System.out.println("Méret nélkül:");
        System.out.println(I.getMeretNelkuliIngatlanokSzama());

        System.out.println("Város");
        System.out.println(I.getVanEEladasAVarosban("SACRAMENTO"));
    }
}
