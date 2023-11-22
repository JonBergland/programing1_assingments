package ovinger.oving5;

class Brok {
    //Objektsvariabler
    private int teller;
    private int nevner;

    //Konstruktør x2

    //Konstruktør 1:

    /* Tar inn teller og nevner som argument
     * Hvis nevneren er 0, skal et unntaksobjekt av typen IllegalArgumentException kastes
     */

    public Brok(int teller, int nevner){
        this.teller = teller;
        this.nevner = nevner;

        if (this.nevner == 0) {
            throw new IllegalArgumentException("Nevner må være over null");
        }

     }

    //Konstruktør 2:

    /*Tar kun teller som argument, nevner settes like 1 */

    public Brok(int teller){
        this.teller = teller;
        this.nevner = 1;
    }


    //Objektsmetoder

    //get brok

    public int getTeller(){
        return teller;
    }

    public int getNevner(){
        return nevner;
    }
    
    //metode for å summere
    public void summere(int p_teller, int p_nevner){
        this.teller = this.teller*p_nevner + p_teller*this.nevner;
        this.nevner = this.nevner*p_nevner;
    }

    //metode for å subrathere

    public void subrathere(int p_teller, int p_nevner){
        this.teller = this.teller*p_nevner - p_teller*this.nevner;
        this.nevner = this.nevner*p_nevner;

    }

    //mulitplisere
    public void multiplisere(int p_teller, int p_nevner){
        this.teller *= p_teller;
        this.nevner *= p_nevner;
    }

    //dividere
    public void dividere(int p_teller, int p_nevner){
        this.teller *= p_nevner;
        this.nevner *= p_teller;
    }

    //metode for å forkorte brøken

    public void forkorteBrok(){
        for (int i = 2; i < this.nevner; i++) {
            if (this.nevner%i == 0 && this.teller%i == 0){
                this.nevner /= i;
                this.teller /= i;

                i--;
            }
        }
    }


}
