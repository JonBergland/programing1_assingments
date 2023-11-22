package oppgave1;

import javax.swing.*;
import java.util.ArrayList;

public class arbTaker_test {
    public static void main(String[] args) {
        Person person1 = new Person("Ola", "Nordman", 1980);
        ArbTaker arbTaker1 = new ArbTaker(person1, 1001, 2015, 30000, 0.20);
        /**
         * Tester get-metodene
         */

        System.out.println("Fornavn: " +person1.getFornavn() + ", Etternavn: " + person1.getEtternavn()
        + ", Fødselsår: " + person1.getFodelsaar()); //tester get-metodene i person

        System.out.println(arbTaker1.getPerson().getFornavn() + " " + arbTaker1.getPerson().getEtternavn()
        + " " + arbTaker1.getPerson().getFodelsaar()); //tester get-metodene til person gjennom arbtaker

        System.out.println(arbTaker1.getNavn());

        //tester resten av get-metodene til arbedstaker
        System.out.println("Arbeidstaker nummer: " + arbTaker1.getArbTakerNr() + ", Ansetelsesår: " + arbTaker1.getAnsettelsesAar()
        + ", Månedslønn: " + arbTaker1.getMaanedslonn() + ", Skatteprosent: " + arbTaker1.getSkatteprosent());

        //tester de imutable-metodene
        System.out.println(arbTaker1.getSkatt());

        System.out.println("Alder: " + arbTaker1.getAlder()+ ", Antall år ansatt: " + arbTaker1.getAntallAarIBedrift());


        //tester om personen har vært ansatt i lengre enn x år
        System.out.println("Har " + arbTaker1.getPerson().getFornavn() + " vært i bedriften i mer enn 7 år? "
        + arbTaker1.ansattAntallAar(7));

        System.out.println("Har " + arbTaker1.getPerson().getFornavn() + " vært i bedriften i mer enn 8 år? "
        + arbTaker1.ansattAntallAar(8));

        //tester set-metodene
        arbTaker1.setMaanedslonn(20000);
        System.out.println(arbTaker1.getMaanedslonn());

        arbTaker1.setSkatteprosent(0.1);
        System.out.println(arbTaker1.getSkatteprosent());

        //sjekker de om de andre metodene endrer seg
        System.out.println(arbTaker1.getSkatt());

        //lager nye personer og arbeidstakere
        Person person2 = new Person("Kari", "Karisen", 1989);
        ArbTaker arbTaker2 = new ArbTaker(person2, 1002, 2017, 31000, 0.20);

        Person person3 = new Person("Berit", "Britsen", 1960);
        ArbTaker arbTaker3 = new ArbTaker(person3, 1003, 2020, 29000, 0.15);

        Person person4 = new Person("Beriiit", "Britsen", 1960);
        ArbTaker arbTaker4 = new ArbTaker(person4, 1003, 2020, 29000, 0.15);

        Person person5 = new Person("Beriit", "Britsen", 1960);
        ArbTaker arbTaker5 = new ArbTaker(person5, 1003, 2020, 29000, 0.15);

        //legger alle personene inn i en liste
        ArrayList<ArbTaker> arbTakerArrayList = new ArrayList<>();
        arbTakerArrayList.add(arbTaker1);
        arbTakerArrayList.add(arbTaker2);
        arbTakerArrayList.add(arbTaker3);
        arbTakerArrayList.add(arbTaker4);
        arbTakerArrayList.add(arbTaker5);

        //lager et nytt bruker_objekt
        Bruker_meny bruker_meny = new Bruker_meny(arbTakerArrayList);

        //kjører metoden start i bruker meny som kjører så lenge brukeren vil

        do {
            bruker_meny.start();
        } while (bruker_meny.getFortsette());

    }
}
