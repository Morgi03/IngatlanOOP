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

        System.out.println("\n-------------\n");

        System.out.println("Város");
        System.out.println(I.getVanEEladasAVarosban("SACRAMENTO"));

        System.out.println("\n-------------\n");

        System.out.println("Eladások száma a városban");
        System.out.println(I.getEladasokSzamaAVarosban("CAMERON PARK"));

        System.out.println("\n-------------\n");

        System.out.println("Eladások összértéke a városban");
        System.out.println(I.getEladasokOsszertekeAVarosban("CAMERON PARK"));

        System.out.println("\n-------------\n");

        System.out.println("Eladások adatai a városban");
        for (var f : I.getIngatlanEladasokAdataiAVarosban("CAMERON PARK")) {
            System.out.println(f);
        }

        System.out.println("\n-------------\n");

        System.out.println("A városok");
        for (var f : I.getVarosokNovekvoSorrendben()) {
            System.out.println(f);
        }

        System.out.println("\n-------------\n");

        System.out.println("Különböző ingatlan típusok:");
        for (var f : I.getIngatlanTipusok()) {
            System.out.println(f);
        }

        System.out.println("\n-------------\n");

        System.out.println("5 legdrágább ingatlan:");
        for (int i = I.get5MostValuableIngatlan().size()-1; i > 0 ; i--) {
            System.out.println(I.get5MostValuableIngatlan().get(i));
        }

        System.out.println("\n-------------\n");


    }
}
