package ovinger.oving5;

public class brok_regning {
    public static void main(String[] args) {
        //lager en test-klient

        System.out.println("Total number of tests: 6");


        Brok brok1 = new Brok(2, 3);
        
        //test 1: tester om get funksjonene fungerer
        if (brok1.getTeller() == 2 &&
        brok1.getNevner() == 3){
            System.out.println("Test 1 var vellykket");
        }

        //test 2: tester om sumering funker
        brok1.summere(1, 3);
        //System.out.println(brok1.getTeller());
        //System.out.println(brok1.getNevner());
        if (brok1.getTeller() == 9 &&
            brok1.getNevner() == 9){
                System.out.println("Test 2 var vellykket");
            }

        
        Brok brok2 = new Brok(2, 3);

        //test 3: tester om  det funker å subrathere
        brok2.subrathere(5, 4);
        if (brok2.getTeller() == -7 &&
            brok2.getNevner() == 12){
                System.out.println("Test 3 var vellykket");
            }

        //test 4: tester multiplikasjonen
        Brok brok3 = new Brok(2, 3);

        brok3.multiplisere(2, 3);

        if (brok3.getTeller() == 4 &&
            brok3.getNevner() == 9){
                System.out.println("Test 4 var vellykket");
            }
        
        //test 5: tester divisjon

        Brok brok4 = new Brok(2, 3);
        brok4.dividere(2,3);

        if (brok4.getTeller() == 6 &&
            brok4.getNevner() == 6){
                System.out.println("Test 5 var vellykket");
            }

        //test 6: tester om brok med en parameter blir brøk med 1 som nevner
        Brok brok5 = new Brok(3);

        //System.out.println(brok5.getTeller());
        //System.out.println(brok5.getNevner());


        if (brok5.getTeller() == 3 &&
            brok5.getNevner() == 1){
                System.out.println("Test 6 var vellykket");
            }

        //test 7: tester forkort brok

        Brok brok6 = new Brok(9, 18);
        brok6.forkorteBrok();

        //System.out.println(brok6.getTeller());
        //System.out.println(brok6.getNevner());

         if (brok6.getTeller() == 1 &&
            brok6.getNevner() == 2){
                System.out.println("Test 7 var vellykket");
            }

        Brok brok7 = new Brok(18, 10);

        //brok7.subrathere(-5, 4);
        brok7.forkorteBrok();
        System.out.println(brok7.getTeller() + "/" + brok7.getNevner());

    }


}
/* 
Lag en klasse for å regne med brøk.

Klassen skal ha to konstruktører:
• Den ene konstruktøren tar teller og nevner som argument. Hvis nevneren er 0, skal et unntaksobjekt av typen IllegalArgumentException kastes.
• Den andre konstruktøren tar kun telleren som argument. Da skal nevneren settes lik 1.

Klassen skal ha get-metoder, men ikke set-metoder.
Klassen skal ha metoder for å summere, subtrahere, multiplisere og dividere en brøk (this) med en annen brøk (parameter til metoden). Metodene har ikke returverdi, men etter at operasjonen er utført, ligger resultatet i this.

Du kan se bort fra at resultatet av operasjonen bør forkortes.

Lag testklient som del av klassen.
*/