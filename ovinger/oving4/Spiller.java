package ovinger.oving4;
//import java.util.random;


class Spiller{
    java.util.Random terning= new java.util.Random();
    private final String name;
    private int rundenr;
    private int poengSum;    

    //Konstruktør
    public Spiller(String name, int rundenr, int poengSum){
        this.name = name;
        this.rundenr = rundenr;
        this.poengSum = poengSum;
    }

    //Henter summen til spilleren
    public int getSumPoeng(){
        return poengSum;
    }

    //Henter spiller navn
    public String getName(){
        return name;
    }

    //Henter rundenummeret
    public int getRundenr(int x){
        rundenr += x;
        return rundenr;
    }

    //Simulerer et terningskast
    public int kastTerningen(){
        int resultat = terning.nextInt(6) + 1;
        if(resultat == 1){
            poengSum = 0;
        }
        else if(poengSum > 100){
            poengSum -= resultat;
        }
        else{
            poengSum += resultat;
        }
        return resultat;
    }

    //sjekker om objektet har nådd 100
    public boolean erFerdig(){
        if (poengSum == 100){
            return true; //hvis summen er over 100 så retuneres true
        }
        else{
            return false; //hvis summer ikke er over 100 så retuneres false
        }
    }
}
