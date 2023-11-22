package ovinger.oving4;
import java.util.Scanner;

public class Omregning_Valuta {
    public static void main(String[] args) {
        //Opprette 3 objekter med valuta
        Valuta dollar = new Valuta("Dollar", 10.69);
        Valuta euro = new Valuta("Euro", 11.45);
        Valuta svenskKrone = new Valuta("Svenske kroner", 0.96);

        System.out.println(dollar.getName());

        //Få bruker til å velge valuta
        Scanner in = new Scanner(System.in);
        System.out.println("Velg valuta: \n 1. " + dollar.getName() +" \n 2. " + euro.getName() + "\n 3. " + svenskKrone.getName() + "\n 4. Avbryt" );
        String brukerInput1 = in.nextLine();

        try {
                Integer.parseInt(brukerInput1);
        }
        catch (NumberFormatException e) {
                System.out.println("Det du skrev inn ble ikke akseptert");
                System.exit(0);
        }

        int tall1 = Integer.parseInt(brukerInput1);

        while (tall1 >= 1 && tall1 <= 3) {
            double sum = 0;

            System.out.println("Vil du gjøre om til kroner eller fra kroner (1 for til/ 2 for fra): ");
            String brukerInput2 = in.nextLine();

            System.out.println("Skriv in hvor mye du vil omgjøre: ");
            String brukerInput3 = in.nextLine();


            try {
                Integer.parseInt(brukerInput2);
                Double.parseDouble(brukerInput3);
            }
            catch (NumberFormatException e) {
                System.out.println("Det du skrev inn ble ikke akseptert");
                System.exit(0);
            }

            int tilFra = Integer.parseInt(brukerInput2);
            double mengde = Double.parseDouble(brukerInput3);

            Valuta type;

            //Omgjør brukerens valuta til norske kroner

            //setter typen valuta i en egen object
            if (tall1 == 1){
                type = dollar;
                //sum = dollar.omgjorTilKr(mengde);
            }

            else if (tall1 == 2){
                type = euro;
                //sum = euro.omgjorTilKr(mengde);
            }

            else{
                type = svenskKrone;
                //sum = svensKrone.omgjorTilKr(mengde);
            }

            //sjekker om man vil ha til eller fra kroner og printer ut riktig sum
            if(tilFra == 1){
                sum = type.omgjorTilKr(mengde);
                System.out.println("Du får " + String.format("%.2f", sum) + " kroner");
            }
            else if (tilFra == 2) {
                sum = type.omgjorFraKr(mengde);
                System.out.println("Du får " + String.format("%.2f", sum) + " " + type.getName());
            }

            //System.out.println("Du får " + String.format("%.2f", sum) + " kroner");

            //repeterer programmet

            System.out.println("Velg valuta: \n 1. " + dollar.getName() +" \n 2. " + euro.getName() + "\n 3. " + svenskKrone.getName() + "\n 4. Avbryt" );
            brukerInput1 = in.nextLine();

            try {
                Integer.parseInt(brukerInput1);
            }
            catch (NumberFormatException e) {
                    System.out.println("Det du skrev inn ble ikke akseptert");
                    System.exit(0);
            }

            tall1 = Integer.parseInt(brukerInput1);           
        }
    }
}
    



