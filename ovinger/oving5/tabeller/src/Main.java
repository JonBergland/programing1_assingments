import java.util.Arrays;
import java.util.Scanner;
import static javax.swing.JOptionPane.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome! \n");
        //int[] maaneder = new int[12];

        int [] maaneder_lengde = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        //maaneder[0] = 31;

        int svar = showConfirmDialog(null, "Er det skuddår?", "År", YES_NO_OPTION);

        if (svar == YES_OPTION) maaneder_lengde[1] = 29;
        for (int i = 0; i < maaneder_lengde.length; i++) {
            System.out.println(maaneder_lengde[i]);
        }

        /*Scanner in = new Scanner(System.in);
        System.out.println("Hvis skuddår skriv 1: ");
        String brukerinput1 = in.nextLine();

        int skuddaar = Integer.parseInt(brukerinput1);*/

        /*for (int i = 0; i < maaneder.length; i++) {
            if (i == 1){
                if (skuddaar == 1){
                    maaneder[i] = 29;
                }
                else {
                    maaneder[i] = 28;
                }
            } else if (i%2 == 0) {
                maaneder[i] = 30
            }
        }*/

        //System.out.println(maaneder.length);


        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        /*for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }*/
    }
}