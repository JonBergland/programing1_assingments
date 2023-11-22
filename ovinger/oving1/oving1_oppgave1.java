/**
 * Øving 1, Oppgave 1
 * Omgjøre tommer til centimeter
 * 
 * Test datasett:
 * 1: 5 --> 12,70
 * 2: -10 --> Feilmelding
 * 3: 0 --> Feilmelding, kan ikke omgjøre 0 antall tommer
 * 4: 5.78 --> 14,68
 */

import java.util.*;

class oving1Oppgave1 {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        System.out.println("Hvor mange tommer vil du gjøre om til cm?: ");
        double antallTommer = in.nextDouble();

        if(antallTommer > 0.0){
            double antallCm = antallTommer*2.54;
            System.out.printf("Du får %.2f cm", antallCm);
        }
        else if(antallTommer == 0) {
            System.out.println("Antallet tommer du skrev inn er 0");
        }
        else {
            System.out.println("Det du satte inn ble ikke akseptert");
        }
    }
}
