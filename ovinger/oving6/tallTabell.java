public class tallTabell {
    public static void main(String[] args) {
        java.util.Random random = new java.util.Random();

        long [] antall = new long[10];
        String stjerne = " *";

        for (int i = 0; i < 1000; i++) {
            int tall = random.nextInt(10);

            antall[tall] ++;
        }

        for (int j = 0; j < antall.length; j ++){
            int avrundet = (int) Math.round(antall[j]/10.0);

            System.out.println(j + ": " + antall[j] + " " + stjerne.repeat(avrundet));
            System.out.println("\n");
        }
    }
}
