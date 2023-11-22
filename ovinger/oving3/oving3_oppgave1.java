import java.util.Scanner;
class oving3Oppgave1{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hvilken del av gangetabellen vil du skrive ut? (Fra tall til tall)");
        String brukerInput1 = in.nextLine();
        String brukerInput2 = in.nextLine();


        try {
            Integer.parseInt(brukerInput1);
            Integer.parseInt(brukerInput2);
        }
        catch (NumberFormatException e) {
            System.out.println("Det du skrev inn ble ikke akseptert");
            System.exit(0);
        }

        //int tall1 = Integer.valueOf(brukerInput1);
        //int tall2 = Integer.valueOf(brukerInput2);

        int tall1  = Integer.parseInt(brukerInput1);
        int tall2 = Integer.parseInt(brukerInput2);

        if (tall2 < tall1){
            System.out.println("Det andre tallet må være større enn det første");
            System.exit(0);
        }

        for (int i = tall1; i <=tall2; i++){
            for (int j = 1; j <= 10; j++){
                System.out.println(i + " x " + j + " = " + i * j);
            }
        }
    }
}