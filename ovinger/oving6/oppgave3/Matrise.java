package oppgave3;

import java.util.ArrayList;

public class Matrise {
    //objektsvariabler
    private ArrayList<Integer> matrise = new ArrayList<Integer>();
    private int rader;
    private int kolonner;

    //konstruktør
    public Matrise(ArrayList<Integer> matrise, int rader, int kolonner){
        this.matrise = matrise;
        this.rader = rader;
        this.kolonner = kolonner;
    }
    //objektsmetoder

    public ArrayList<Integer> getMatrise(){
        return matrise;
    }

    public int getRader(){
        return rader;
    }
    public int getKolonner(){
        return kolonner;
    }

    public String printMatrise(){
        String utskrift = "";
        if (matrise.get(0) != null) {
            utskrift = "[";
            for (int i = 0; i < matrise.size(); i += kolonner) { //går igjennom hver rad og skriver ut hvert element
                String radUtskrift = "[";
                for (int j = 0; j < kolonner; j++) {
                    radUtskrift += " " + matrise.get(i + j) + " ";
                }
                radUtskrift += "] \n";
                utskrift += radUtskrift;
            }
            utskrift += "]";
        }
        return utskrift;
    }

    //1: Addere en matrise til denne matrisen
    public Matrise addereMatrise(ArrayList<Integer> addereMatrise, int addereRader, int addereKolonner) {
        ArrayList<Integer> sumMatrise = new ArrayList<Integer>();
        if (rader != addereRader || kolonner != addereKolonner) { //hvis de ikke er samme størelse
            //throw new IllegalArgumentException("Matrisene må være av samme størelse");
            sumMatrise.add(null);
        } else {
            for (int i = 0; i < rader * kolonner; i++) { //addere hvert element med hverandre
                sumMatrise.add(matrise.get(i) + addereMatrise.get(i));
            }
        }
        Matrise utskrift = new Matrise(sumMatrise, addereRader, addereKolonner);
        return utskrift;
    }

    //2: Multiplisere denne matrisen med en annen matrise

    public Matrise multiplisereMatrise(ArrayList<Integer> multiplisereMatrise, int multiRader, int multiKolonner){
        ArrayList<Integer> sumMatrise = new ArrayList<Integer>();
        if(kolonner != multiRader){ //hvis kolonner i A og rader i B ikke er like så blir utskriften null
            sumMatrise.add(null);
            //throw new IllegalArgumentException("Kolonnene i A må være like som radene i B");
        }
        else{
            for (int i = 0; i < matrise.size(); i += kolonner) { //kjører antall rader i A
                for (int j = 0; j < multiKolonner; j ++) { //kjører antall kolonner i B
                    int sum = 0;
                    int aTall = i;
                    int bTall = j;
                    for (int k = 0; k < kolonner; k++) { //kjører antall radelementer i A og koloneelementer i B
                        sum += matrise.get(aTall)*multiplisereMatrise.get(bTall);
                        bTall += multiKolonner;
                        aTall += 1;
                    }
                    sumMatrise.add(sum);
                }
            }
        }
        Matrise utskrift = new Matrise(sumMatrise, rader, multiKolonner);
        return utskrift;
    }

    //3: Transponere matrisen

    public Matrise transponereMatrise(){
        ArrayList<Integer> transMatrise = new ArrayList<Integer>();
        for (int i = 0; i < kolonner; i++) { //lager 2 for-løkker som går igjenomm utgangsmatrisen og henter hvert 3. element
            for (int j = i; j < matrise.size(); j+= kolonner) {
                transMatrise.add(matrise.get(j)); //legger til elementet i den transponerte matrisen
            }
        }
        Matrise utskrift = new Matrise(transMatrise, kolonner, rader);

        return utskrift;

    }
}
