package ovinger.oving4;
import java.util.Scanner;

public class terningSpill {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Navn på spiller 1: ");
        String navnSpiller1 = in.nextLine();

        System.out.println("Navn på spiller 2: ");
        String navnSpiller2 = in.nextLine();


        //oppretter 2 spiller objekter
        Spiller spiller1 = new Spiller(navnSpiller1, 0, 0);
        Spiller spiller2 = new Spiller(navnSpiller2, 0, 0);

        //spiller1.rundenr = 1;
        //spiller2.rundenr = 1;


        //lager en while-løkka som går til summen til en av spillerne er lik 100
        while (spiller1.erFerdig() == false && spiller2.erFerdig() == false){
            //legger til 1 til rundenummeret
            spiller1.getRundenr(1);
            spiller2.getRundenr(1);

            spiller1.kastTerningen();
            spiller2.kastTerningen();



            System.out.println("Runde: " + spiller1.getRundenr(0) + ": \n" + spiller1.getName() + ", Sum: " + spiller1.getSumPoeng());
            System.out.println(spiller2.getName() + ", Sum: " + spiller2.getSumPoeng() + "\n");

            //System.out.println(spiller1.poengSum);
            int ventetid = 400;
            try {
                Thread.sleep(ventetid);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(spiller1.getSumPoeng() == 100 && spiller2.getSumPoeng() == 100){
            System.out.println("Det ble uavgjort");
        }
        else if(spiller2.getSumPoeng() == 100){
            System.out.println(spiller2.getName() + " vant!");
        }
        else{
            System.out.println(spiller1.getName() + " vant!");
        }


    }
}
