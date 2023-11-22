/**
 * Øving 1, Oppgave 3
 * 
 * Omgjøre sekunder om til timer, minutter og sekunder
 */


import java.util.*;

class oving1Oppgave3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Hvor mange sekunder vil du gjøre om til timer, minutter og sekunder?: ");
        int antallSekunder = in.nextInt();

        
        if(antallSekunder >= 0){
            //double midlertidig = antallSekunder;
            int timer = antallSekunder/3600;
            antallSekunder = antallSekunder - timer*3600;
            int minutter = antallSekunder/60;
            antallSekunder = antallSekunder - minutter*60;
            System.out.println(timer + " timer, " + minutter + " minutter og " + antallSekunder + " sekunder");
        }
        else{
            System.out.println("Feilmelding");
        }
    }
}
