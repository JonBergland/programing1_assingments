package oppgave2.src;
import java.util.ArrayList;

class Tekstanalyse {
    //Objektvariabler
    private int[] antallTegn = new int[30];
    private String tekst;


    //Konstruktør
    public Tekstanalyse(String tekst) {
        this.tekst = tekst;
    }

    //Objektsmetoder:

    public int[] getAntallTegn() {
        return antallTegn;
    }


    //Finn antall forskjellige bokstaver i teksten (se bort i fra andre tegn)

    public int getAntallUnike() {
        int antallUnike = 0;
        for (int i = 0; i < antallTegn.length - 1; i++) {
            if (antallTegn[i] > 0) {
                antallUnike += 1;
            }
        }
        return antallUnike;
    }

    //antall bokstaver i teksten
    public int getAntallBokstaver() {
        int antallBokstaver = 0;
        for (int i = 0; i < antallTegn.length - 1; i++) {
            antallBokstaver += antallTegn[i];
        }
        return antallBokstaver;
    }

    //Hvor stor del av teksten er ikke bokstaver (prosent)

    public double getProsentIkkeBokstaver() {
        double prosent = (double) antallTegn[29] / (getAntallBokstaver() + antallTegn[29]);
        prosent *= 100;
        return prosent;
    }

    //Antall forekomster av en bestemt bokstav

    public int getAntallAvBokstav(String bokstav) {
        bokstav = bokstav.toLowerCase();
        int nummer = bokstav.charAt(0) - 97;
        int antall = 0;
        if (nummer >= 0 && nummer <= 25) {
            antall = antallTegn[nummer];
        } else if (nummer == 230 - 97) { //hvis tallet er æ, ø eller å
            antall = antallTegn[26];
        } else if (nummer == 248 - 97) {
            antall = antallTegn[27];
        } else if (nummer == 229) {
            antall = antallTegn[28];
        }
        return antall;
    }


    //Hvilke/hvilken bokstav forekommer mest (liste, if len > 0)

    public ArrayList<Character> getBokstavFlestAv() {
        ArrayList<Character> liste = new ArrayList<Character>();
        //char liste[] = new char[0];
        int antall = 1;
        for (int i = 0; i < antallTegn.length - 4; i++) {
            if (antallTegn[i] > antall) {
                char bokstav = (char) ((char) i + 97);
                //liste = new char[0];
                liste.clear();
                liste.add(bokstav);
                //liste = Collections.singletonList(liste.add(bokstav));
                antall = antallTegn[i];
            } else if (antallTegn[i] == antall) {
                char bokstav = (char) ((char) i + 97);
                liste.add(bokstav);
            }
        }
        for (int i = 26; i < 29; i++) {
            if (antallTegn[i] > antall) {
                liste.clear();
                antall = antallTegn[i];
                if (i == 26) { //tester om det er æ, ø eller å
                    char bokstav = (char) 230;
                    liste.add(bokstav);
                } else if (i == 27) {
                    char bokstav = (char) 248;
                    liste.add(bokstav);
                } else {
                    char bokstav = (char) 229;
                    liste.add(bokstav);
                }
            } else if (antallTegn[i] == antall) {
                if (i == 26) { //tester om det er æ, ø eller å
                    char bokstav = (char) 230;
                    liste.add(bokstav);
                } else if (i == 27) {
                    char bokstav = (char) 248;
                    liste.add(bokstav);
                } else if (i == 28) {
                    char bokstav = (char) 229;
                    liste.add(bokstav);
                }
            }
        }
        return liste;
    }


        //Mutasjonsmetoder:

        //endre fra tekst streng til antall tegn
    public String omgjorTilAntallTegn() {
            String tekst2 = tekst;
            tekst2 = tekst2.toLowerCase();
            for (int i = 0; i < tekst2.length(); i++) {
                int nummer = tekst2.charAt(i) - 97;

                if (nummer >= 0 && nummer <= 25) { //tester om bokstaven er a-z
                    antallTegn[nummer] += 1;

                } else { //hvis bokstaven ikke er a-z
                    if (nummer == 230 - 97) { //tester om det er æ, ø eller å
                        antallTegn[26] += 1;
                    } else if (nummer == 248 - 97) {
                        antallTegn[27] += 1;
                    } else if (nummer == 229 - 97) {
                        antallTegn[28] += 1;
                    } else {//hvis tegnet ikke er en bokstav
                        antallTegn[29] += 1;
                    }

                }
            }

            return null;
    }

}