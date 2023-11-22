package ovinger.oving5;

public class MinRandom_testKlient {
    public static void main(String[] args) {

        //tester to forkjellige tall
        MinRandom randomTall1 = new MinRandom(10, 17);

        //System.out.println(randomTall1.nesteHeltall());
        //System.out.println(randomTall1.nesteDesimaltall());

        int randomHeltall  = randomTall1.nesteHeltall();
        double randomDesimaltall = randomTall1.nesteDesimaltall();

        if ((randomHeltall >= randomTall1.getNedre() && randomHeltall < randomTall1.getOvre()) &&
            (randomDesimaltall >= randomTall1.getNedre() && randomDesimaltall < randomTall1.getOvre())) {

            System.out.println("Test 1 var vellykket");
        }

        //tester to like tall
        MinRandom randomTall2 = new MinRandom(10, 10);

        //System.out.println(randomTall2.nesteHeltall());
        //System.out.println(randomTall2.nesteDesimaltall());

        randomHeltall  = randomTall2.nesteHeltall();
        randomDesimaltall = randomTall2.nesteDesimaltall();

        if (randomHeltall == randomTall2.getNedre() &&
            randomDesimaltall == randomTall2.getNedre()) {

            System.out.println("Test 2 var vellykket");
        }

        //tester nedre mindre enn ovre
        /* 
        MinRandom randomTall3 = new MinRandom(10, 9);

        //System.out.println(randomTall3.nesteHeltall());
        //System.out.println(randomTall3.nesteDesimaltall());

        randomHeltall  = randomTall3.nesteHeltall();
        randomDesimaltall = randomTall3.nesteDesimaltall();

        if (randomHeltall == randomTall3.getNedre() &&
            randomDesimaltall == randomTall3.getNedre()) {

            System.out.println("Test 3 var vellykket");
        }
        */

        MinRandom randomTall4 = new MinRandom(-10, 10000);

        System.out.println(randomTall4.nesteHeltall());
        System.out.println(randomTall4.nesteDesimaltall());





    }
}
