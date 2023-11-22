package oppgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class matrise_test {
    public static void main(String[] args) {
        ArrayList<Integer> tabell =  new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        Matrise matrise = new Matrise(tabell, 2,3);

        //tester addisjon av matriser

        ArrayList<Integer> addisjonsTabell =  new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println("Addere resultat:");
        Matrise addereMatrise = matrise.addereMatrise(addisjonsTabell, 2, 3);
        System.out.println(addereMatrise.printMatrise());

        //tester multilpikasjon av matriser

        ArrayList<Integer> tabell2 =  new ArrayList<>(Arrays.asList(5,0, -2, 3, 1, 4));
        Matrise matrise2 = new Matrise(tabell2, 2,3);

        ArrayList<Integer> multiplikasjonTabell =  new ArrayList<>(Arrays.asList(2, 1, 1, 0, 2, 4));

        Matrise sumMatrise = matrise2.multiplisereMatrise(multiplikasjonTabell, 3, 2);
        System.out.println("Multiplisering:");
        System.out.println(sumMatrise.printMatrise());

        //kjører samme matrise igjen bare motsatt
        Matrise matrise3 = new Matrise(multiplikasjonTabell, 3,2);
        ArrayList<Integer> tabell3 =  new ArrayList<>(Arrays.asList(5,0, -2, 3, 1, 4));

        Matrise sumMatrise2 = matrise3.multiplisereMatrise(tabell3, 2, 3);
        System.out.println("Multiplisering:");
        System.out.println(sumMatrise2.printMatrise());

        //tester transponering av matrise

        //ArrayList<Integer> tabell4 =  new ArrayList<>(Arrays.asList(5,0, -2, 3, 1, 4));
        //Matrise matrise4 = new Matrise(tabell3, 2, 3);
        System.out.println("Transponering:");

        System.out.println(sumMatrise2.transponereMatrise().printMatrise());




    }
}
