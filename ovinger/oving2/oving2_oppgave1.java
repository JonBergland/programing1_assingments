import java.util.Scanner;

class oving2Oppgave1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Skriv inn et år for å sjekke om det er et skuddår");
        String brukerInput = in.nextLine();

        try {
            Integer.parseInt(brukerInput);
        }
        catch (NumberFormatException e) {
            System.out.println(brukerInput + " er ikke et år");
            System.exit(0);
        }
        
        int aaret = Integer.valueOf(brukerInput);
        boolean skuddAar = false;

        boolean svar = sjekkOmSkuddaar(aaret, skuddAar);

        if (svar == true) {
            System.out.println(aaret + " er et skuddår!");
        }
        else {
            System.out.println(aaret + " er ikke et skuddår");
        }
        
    }

    public static boolean sjekkOmSkuddaar(int aar, boolean skuddAar) {
        if (aar%400 == 0){
           skuddAar = true;
        } else if (aar%4 == 0) {
            skuddAar = true;
        }
        return skuddAar;
        
    }
}