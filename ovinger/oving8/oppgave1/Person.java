package oppgave1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person {
    java.util.GregorianCalendar kalender = new GregorianCalendar();
    int aar = kalender.get(Calendar.YEAR);
    /**
     * Objekstvariabler
     * Setter alle til å være final, fordi man ikke skal kunne endre
     */
    private final String fornavn;
    private final String etternavn;
    private final int fodelsaar;
    public Person(String fornavn, String etternavn, int fodselaar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodelsaar = fodselaar;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public int getFodelsaar() {
        return fodelsaar;
    }

}
