package oppgave2;

public class Tekstbehandling {
    //objektsvariabler
    String string;
    String[] streng;

    //konstruktør
    public Tekstbehandling(String string){
        this.string = string;
        this.streng = string.split("[.\\s:,]");
    }


    //objektsmetoder
    //Finne antall ord i teksten
    public int antallOrd(){
        //String[] streng = string.split(" ");
        return streng.length;
    }

    //Gjennomsnittlig ordlengde
    public float gjennomsnittOrdlengde(){
        float gjennomsnitt = 0;
        int antallOrd = 0;
        for (int i = 0; i < streng.length; i++) {
            if (!streng[i].isEmpty()) {
                gjennomsnitt += streng[i].length();
                antallOrd += 1;
                //System.out.println(streng[i]);
            }
        }
        gjennomsnitt /= antallOrd;

        return gjennomsnitt;
    }
    //Gjennomsnittlig ordlengde per periode (punktum, utropstegn, kolon og spørretegn markerer enden av en periode

    public float gjennomsnittOrdPerPeriode(){
        float gjennomsnitt = 0;
        String[] perioder = string.split("[.:?!]");
        //System.out.println("Perioder: " + perioder.length);
        for (int i = 0; i < perioder.length; i++) {
            int antallOrd = 0;
            if (perioder[i].charAt(0) == ' '){
                perioder[i] = perioder[i].substring(1);
            }
            String setning = perioder[i];
            //System.out.println(setning);
            //Tekstbehandling setning = new Tekstbehandling(perioder[i]);
            //gjennomsnitt += setning.gjennomsnittOrdlengde();
            String[] ord = setning.split("[\\s]");
            //System.out.println(ord.length);
            gjennomsnitt += ord.length;
        }
        //System.out.println(gjennomsnitt);
        gjennomsnitt /= perioder.length;
        return gjennomsnitt;
    }

    //Skifte et ord ut med et annet
    public void skiftOrd(String orginal, String utskift){
        string = string.replaceAll(orginal, utskift);
        /*while (string.indexOf(orginal) > -1){
            int index = string.indexOf(orginal);
            String forste = string.substring(0, index);
            String siste = string.substring(index + orginal.length());
            string = forste + utskift + siste;
        }*/
    }

    //hente ut teksten slik den står uten endring
    public String getTekst(){
        //String utskrift = "";
        //for (int i< = 0; i < streng.length; i++) {
            //utskrift += streng[i] + " ";
        //}
        return string;
    }

    //Å hente ut teksten, men slik at alle bokstaver er store.
    public String getTekstStor(){
        //String utskrift = string.toUpperCase();
        return string.toUpperCase();
    }
}
