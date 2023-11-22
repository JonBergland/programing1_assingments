package oppgave1;

public class Arrangement {
  final private int arrangementNr;
  final private String navn;
  final private String sted;
  final private String arrangor;
  final private String type;
  final private String tidspunkt;

  public Arrangement(int arrangementNr, String navn, String sted, String arrangor, String type, String tidspunkt) {
    this.arrangementNr = arrangementNr;
    this.navn = navn;
    this.sted = sted;
    this.arrangor = arrangor;
    this.type = type;
    this.tidspunkt = tidspunkt;
  }
  public int getArrangementNr() {
    return arrangementNr;
  }
  public String getNavn() {
    return navn;
  }
  public String getSted() {
    return sted;
  }
  public String getArrangor() {
    return arrangor;
  }

  public String getType() {
    return type;
  }
  public String getTidspunkt() {
    return tidspunkt;
  }

  public void toStrin() {
    System.out.println( "Nr: " + arrangementNr + " Navn: " + navn + " Sted: " +sted+ " Arrangør: " + arrangor
        + " Type: " + type + " Tidspunkt: " + tidspunkt);
  }
}
