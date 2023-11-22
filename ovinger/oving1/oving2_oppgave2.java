import java.util.Scanner;

class oving2_oppgave2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Sammenlign to produkter");
        System.out.println("Hvor mye koster og veier (i gram) produkt A?:");
        String TekstPrisA = in.nextLine();
        String TekstVektA = in.nextLine();

        System.out.println("Hvor mye koster og veier (i gram) produkt B?:");
        String TekstPrisB = in.nextLine();
        String TekstVektB = in.nextLine();

        try { //tester om inputt er et tall
            Double.parseDouble(TekstPrisA);
            Double.parseDouble(TekstVektA);
            Double.parseDouble(TekstPrisB);
            Double.parseDouble(TekstVektB);
        }
        catch (NumberFormatException e) {
            System.out.println("Noe av det du satte inn var ikke et tall");
            System.exit(0);
        }

        Double prisA = Double.parseDouble(TekstPrisA);
        Double vektA = Double.parseDouble(TekstVektA);
        Double prisB = Double.parseDouble(TekstPrisB);
        Double vektB = Double.parseDouble(TekstVektB);

        double vareA = prisPerGram(prisA, vektA);
        double vareB = prisPerGram(prisB, vektB);

        if (vareA < vareB){
            System.out.println("Vare A er billigst");
        }
        else if (vareA == vareB) {
            System.out.println("De er like dyre");
        }
        else {
            System.out.println("Vare B er billigst");
        }

        /*if (vareA == vareB){
            System.out.println("De er like dyre");
        }
        else {
            System.out.println(Math.min(vareA, vareB) + " er minst");
        }**/



    }

    public static double prisPerGram(double pris, double vekt){
        return pris/vekt;
    }

}
