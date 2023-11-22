package oppgave1;
import java.util.*;
import oppgave1.Person;

public class ArbTaker {
    java.util.GregorianCalendar kalender = new GregorianCalendar();
    int aar = kalender.get(Calendar.YEAR);
    /**
     * Objekstvariabler
     */
    private final Person person;

    private final int arbTakerNr;

    private final int ansettelsesAar;

    private double maanedslonn;

    private double skatteprosent;

    /**
     *Konstruktør
     */
    public ArbTaker(Person person, int arbTakerNr, int ansettelsesAar, double maanedslonn, double skatteprosent){
        this.person = person;
        this.arbTakerNr = arbTakerNr;
        this.ansettelsesAar = ansettelsesAar;
        this.maanedslonn = maanedslonn;
        this.skatteprosent = skatteprosent;
    }
    /**
     * Get-metoder for alle atributtene
     */
    public Person getPerson() {
        return person;
    }

    public int getArbTakerNr() {
        return arbTakerNr;
    }

    public int getAnsettelsesAar() {
        return ansettelsesAar;
    }

    public double getMaanedslonn() {
        return maanedslonn;
    }

    public double getSkatteprosent() {
        return skatteprosent;
    }

    /**
     *Set-metoder
     */

    public void setMaanedslonn(double maanedslonn) {
        this.maanedslonn = maanedslonn;
    }

    public void setSkatteprosent(double skatteprosent) {
        this.skatteprosent = skatteprosent;
    }
    /**
     * Immutable metoder
     */
    public double getSkattIKroner(){
        return maanedslonn*skatteprosent;
    }
    public double bruttoLønnPerAar(){
        return maanedslonn*12;
    }
    public double skatteTrekkPerAar(){
        return getSkattIKroner()*10.5;
    }
    public String getNavn(){
        String output = person.getEtternavn() + ", " + person.getFornavn();
        return output ;
    }
    public int getAlder(){
        return aar - person.getFodelsaar();
    }
    public int getAntallAarIBedrift(){
        return aar - ansettelsesAar;
    }
    public boolean ansattAntallAar(int aar){
        return aar < getAntallAarIBedrift();
    }

    public String getSkatt(){
        String output = "Skatt i kroner per måned: " + getSkattIKroner() + ", Bruttolønn: " + bruttoLønnPerAar()
                + ", Skatte trekk per aar: " + skatteTrekkPerAar();
        return output;
    }




}
