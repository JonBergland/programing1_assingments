import java.util.Scanner;
class oving3Oppgave2{
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String svar;
        do{
            System.out.println("Skriv et tall for å sjekke om det er et primtall");
            String brukerInput1 = in.nextLine();

            try {
                Integer.parseInt(brukerInput1);
            }
            catch (NumberFormatException e) {
                System.out.println("Det du skrev inn ble ikke akseptert");
                System.exit(0);
            }

            int tall1 = Integer.parseInt(brukerInput1);
            if(tall1 <= 0){
                System.out.println("Det du satte inn er 0 eller mindre");
            }
            else if(tall1 == 1){
                System.out.println(tall1 + " er et primtall");
            }

            for(int i = 2; i <=tall1; i++){
                if(tall1%i == 0 && tall1 != i){
                    System.out.println(tall1 + " er ikke et primtall");
                    break;
                }
                else if(tall1%i == 0 && tall1 == i){
                    System.out.println(tall1 + " er et primtall");
                    break;
                }
            }
            System.out.println("Hvis du vil skrive inn et nytt tall, skriv 1");
            svar = in.nextLine();

            try {
                Integer.parseInt(svar);
            }
            catch (NumberFormatException e) {
                //System.out.println("Det du skrev inn ble ikke akseptert");
                System.exit(0);
            }

        } while(Integer.parseInt(svar) == 1);
    }
}