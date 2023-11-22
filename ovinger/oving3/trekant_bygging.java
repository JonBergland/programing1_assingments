import java.util.Scanner;

class trekantLaging {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Skriv inn antall linjer du ønsker");
        String brukerInput1 = in.nextLine();

        int antall_stjerner  = Integer.parseInt(brukerInput1);

        String stjerne = "*";
        String mellomrom = " ";

        if(antall_stjerner <= 0){
            System.out.println("Du skrev inn et tall mindre enn 1");
        }
        /**else{
            for(int i = 1; i <= antall_stjerner; i++){
                int antall_mellomrom = antall_stjerner - i;
                System.out.println(mellomrom.repeat(antall_mellomrom) + stjerne.repeat(i) + mellomrom.repeat(antall_mellomrom));
            }**/
        else {
            for(int i = 1; i <= antall_stjerner; i++){
                int antall_mellomrom = antall_stjerner - i;
                String a = "a";
                String b = "b";

                System.out.print(mellomrom.repeat(antall_mellomrom));

                for(int j = 1; j <= i; j++){
                    System.out.print(stjerne + " ");
                }
                System.out.println(mellomrom.repeat(antall_mellomrom));
            }
        }
    }
}
