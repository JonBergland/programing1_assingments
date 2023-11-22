package oppgave1;

public class NyString {
    //objekstvariabler
    private String string;

    //konstruktør
    public NyString(String string){
        this.string = string;
    }

    //Objektsmetoder
    //Forkorting
    public String forkorte(){
        String[] streng = string.split(" ");
        String utskrift = "";
        for (int i = 0; i < streng.length; i++) {
            utskrift += streng[i].charAt(0);
        }
        return utskrift;
    }

    //Fjerning av tegn
    public String fjerneTegn(String a){
        String[] streng = string.split(a);
        String utskrift = "";
        for (int i = 0; i < streng.length; i++) {
            utskrift += streng[i];
        }
        return utskrift;
    }
}
