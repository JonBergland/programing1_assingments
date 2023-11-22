package oppgave2;
import oppgave1.NyString;

import java.util.Scanner;

public class Tekstbehandling_test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn en tekst: ");
        String brukerTekst = in.nextLine();
        //String brukerTekst = "det er kult å være hubert. Jeg har kontroll kult";

        Tekstbehandling tekst = new Tekstbehandling(brukerTekst);

        //tester antall ord
        System.out.println("Antall ord i teksten: " + tekst.antallOrd());

        //tester gjennomsnittslengden på ordene
        System.out.println("Gjennomsnittslengden på ordene: " + String.format("%.2f", tekst.gjennomsnittOrdlengde()));

        //tester gjennomsnittet på antall ord per periode
        System.out.println("Gjennomsnittet på antall ord per periode: " + String.format("%.2f", tekst.gjennomsnittOrdPerPeriode()));

        //skifte et ord ut med et annet
        System.out.println("Skriv inn et ord du vil skifte: ");
        String orginaltOrd = in.nextLine();
        System.out.println("Skriv inn ordet du skifte med: ");
        String utskiftningsOrd = in.nextLine();

        //String orginaltOrd = "kult";
        //String utskiftningsOrd = "fætt";

        tekst.skiftOrd(orginaltOrd, utskiftningsOrd);
        System.out.println(tekst.getTekst());

        //henter ut teksten bare med store bokstaver
        System.out.println(tekst.getTekstStor());

    }
}