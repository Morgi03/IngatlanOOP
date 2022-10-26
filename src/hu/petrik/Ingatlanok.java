package hu.petrik;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ingatlanok {

    private List<Ingatlan> ingatlanList;

    public Ingatlanok(String fajl){
        this.ingatlanList = new LinkedList<>();

        try {
            FileReader fr = new FileReader(fajl);
            BufferedReader br = new BufferedReader(fr);

            br.readLine();
            String sor = br.readLine();
            while (sor != null){
                this.ingatlanList.add(new Ingatlan(sor));
                sor = br.readLine();
            }

            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public String toString() {
        String s = String.format("\n%-55s %-10s %11s %14s  %13s\n", "Cím","Típus","Szobaszám","Méret","Ár");
        for (int i = 0; i <107; i++) {
            s += "-";
        }
        s += "\n";

        for (Ingatlan i: this.ingatlanList) {
            s += i + "\n";
        }

        return s;
    }


    public long getIngatlanEladasokSzama(){
        return  this.ingatlanList.stream()
                .count();
    }

    public Ingatlan getLegnagyobbIngatlan(){
        return this.ingatlanList.stream()
                .max((ingA,ingB) -> Integer.compare(ingA.getTerulet(), ingB.getTerulet()))
                .get();

/*        return this.ingatlanList.stream()
                .max(Comparator.comparingInt(Ingatlan::getTerulet))
                .get();*/
    }

    public long getOsszIngatlanErtek(){
        return this.ingatlanList.stream()
//                .distinct()
//                .filter(ing -> ing.getSzobaSzam() >2)
                .mapToInt(ingatlan -> ingatlan.getAr())
                .sum();
    }

    public long getMeretNelkuliIngatlanokSzama(){
        return this.ingatlanList.stream()
                .filter(ingatlan -> ingatlan.getTerulet() == 0)
                .count();
    }

    public boolean getVanEEladasAVarosban(String varos){
        return this.ingatlanList.stream()
                .anyMatch(ing -> ing.getVaros().equals(varos));
    }

    //Városonként csoportosítva adjuk meg, hogy hány tranzakció történt

    public Map<String,Long> getVarosonkentiTranzakciokSzama(){
        return this.ingatlanList.stream()
                .collect(Collectors.groupingBy(Ingatlan::getVaros,Collectors.counting()));
    }

    public long getEladasokSzamaAVarosban(String varos){
        return this.ingatlanList.stream().filter(ing -> ing.getVaros().equals(varos)).count();
    }
    public long getEladasokOsszertekeAVarosban(String varos){
        return this.ingatlanList.stream().filter(ing -> ing.getVaros().equals(varos)).mapToInt(Ingatlan::getAr).sum();
    }

    public List<Ingatlan> getIngatlanEladasokAdataiAVarosban(String varos){
        return this.ingatlanList.stream().filter(ing -> ing.getVaros().equals(varos)).toList();
    }

    public List<String> getVarosokNovekvoSorrendben(){
        return this.ingatlanList.stream().
                map(Ingatlan::getVaros).sorted().distinct().toList();
    }

    public List<String> getIngatlanTipusok(){
        return this.ingatlanList.stream().
                map(Ingatlan::getTipus).distinct().toList();
    }

    public List <Ingatlan> get5MostValuableIngatlan(){
        return this.ingatlanList.stream().sorted((ingA,ingB) -> Integer.compare(ingA.getAr(), ingB.getAr())).limit(5).toList();
    }





}
