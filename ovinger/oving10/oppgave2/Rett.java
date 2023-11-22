package oppgave2;

public class Rett {
  private final String navn;
  private final String type;
  private final int pris;

  private final String oppskrift;

  public Rett(String navn, String type, int pris, String oppskrift){
    this.navn = navn;
    this.type = type;
    this.pris = pris;
    this.oppskrift = oppskrift;
  }

  public String getNavn() {
    return navn;
  }

  public String getType() {
    return type;
  }

  public int getPris() {
    return pris;
  }

  public String getOppskrift() {
    return oppskrift;
  }

  public void toStrin(){
    System.out.println("Navn: " + this.navn + ", Type: " + this.type + ", Pris: " + this.pris
        + ", Oppskrift: " + this.oppskrift);
  }
}
