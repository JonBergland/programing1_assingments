package oppgave1;
import java.util.Scanner;

public class NyString_test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn en tekst: ");
        String brukerTekst = in.nextLine();
        //String string = "denne setningen skal forkortes";

        NyString nyString = new NyString(brukerTekst);

        System.out.println("Dette er de første bokstavene i hvert ord: " +nyString.forkorte());

        System.out.println("Skriv inn en bokstav som du vil fjerne fra teksten: ");
        String brukerBokstav = in.nextLine();

        System.out.println(nyString.fjerneTegn(brukerBokstav));



    }
}
