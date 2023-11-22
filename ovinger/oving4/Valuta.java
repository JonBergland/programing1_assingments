package ovinger.oving4;

class Valuta {
    private final String name;
    private final double kurs;
    
    //Konstruktør
    public Valuta(String name, double kurs){
        this.name = name;
        this.kurs = kurs;
        //this.mengde = mengde;
    }
    //Objektsmetoder for omgjøring fra kr til valuta og motsatt
    public double omgjorTilKr(double mengde){
        return kurs*mengde;
    }

    public double omgjorFraKr(double mengde){
        return mengde/kurs;
    }

    //Objektsmetoder for navn
    public String getName(){
        return name;
    }


    
}
