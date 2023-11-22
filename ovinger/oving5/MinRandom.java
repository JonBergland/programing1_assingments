package ovinger.oving5;

//import java.util.Random;

class MinRandom {
    java.util.Random randomNr= new java.util.Random();
    //Objektsvariabler
    private int nedreInt;
    private int ovreInt;

    private double nedreDouble;
    private double ovreDouble;

    private boolean like = false;

    //Kontruktør
    public MinRandom(int nedre, int ovre){
        this.nedreInt = nedre;
        this.ovreInt = ovre;

        this.nedreDouble = nedre;
        this.ovreDouble = ovre;

        if (this.nedreInt > this.ovreInt) {
            throw new IllegalArgumentException("Nedre grense må være større enn øvre grense");
        }
        else if (this.nedreInt == this.ovreInt){
            this.like = true;
        }

    }


    //Objektsmetoder:

    public int nesteHeltall(){
        int randomHeltall;
        if (like == false){
            int intervall = this.ovreInt - this.nedreInt;
            randomHeltall = randomNr.nextInt(intervall) + this.nedreInt;
        }
        else {
            randomHeltall = this.nedreInt;
        }

        return randomHeltall;
    }


    public double nesteDesimaltall(){
        double randomDesimaltall;
        if (like == false){
            int heltall = this.nesteHeltall();
            randomDesimaltall = heltall + randomNr.nextDouble();
        }
        else {
            randomDesimaltall = this.nedreInt;
        }

        return randomDesimaltall;
    }

    public int getNedre(){
        return this.nedreInt;
    }

    public int getOvre(){
        return this.ovreInt;
    }
}
