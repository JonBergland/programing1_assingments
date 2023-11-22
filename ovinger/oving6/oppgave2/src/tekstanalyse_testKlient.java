package oppgave2.src;
import java.util.Scanner;

public class tekstanalyse_testKlient {
    public static void main(String[] args) {

        //for løkke som løkker igjennom alle metodene i klassen
        Scanner in = new Scanner(System.in);
        int fortsette = 0;
        do {
            System.out.println("Skriv inn en tekst du vil ha analysert: ");
            String brukerTekst = in.nextLine();

            Tekstanalyse tekstAnalyse = new Tekstanalyse(brukerTekst);
            tekstAnalyse.omgjorTilAntallTegn();

            //skriver ut antall unike bokstaver til bruker
            System.out.println("Antall ulike bokstaver: " + tekstAnalyse.getAntallUnike());

            //antall bokstaver i teksten

            System.out.println("Antall bokstaver: " + tekstAnalyse.getAntallBokstaver());

            //prosent av teksten som ikke er bokstaver

            System.out.println("Prosent ikke bokstaver: " + String.format("%.2f", tekstAnalyse.getProsentIkkeBokstaver()) + "%");

            //antall forekomster av en bokstav
            System.out.println("Skriv en bokstav som du vil se hvor ofte forekommer: ");
            String brukerBokstav = in.nextLine();

            System.out.println("Antall forekomster av " + brukerBokstav + ": " + tekstAnalyse.getAntallAvBokstav(brukerBokstav));


            //bokstaven/bokstavene som forekommer mest


            System.out.println("Bokstaven/ene som forekommer mest: " + tekstAnalyse.getBokstavFlestAv());

            //sjekker om brukeren vil kjøre en gang til
            System.out.println("Skriv inn 1 for å kjøre en gang til: ");
            String brukerSvar = in.nextLine();

            try {
                Integer.parseInt(brukerSvar);
            }
            catch (NumberFormatException e) {
                System.out.println("Det du skrev inn ble ikke akseptert");
                System.exit(0);
            }

            fortsette  = Integer.parseInt(brukerSvar);

        } while (fortsette == 1);


    }
}
