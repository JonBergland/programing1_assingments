package oppgave2;

public class Meny {
  private final Rett forrett;
  private final Rett hovedrett;
  private final Rett dessert;

  private final int totalPris;

  public Meny(Rett forrett, Rett hovedrett, Rett dessert){
    this.forrett = forrett;
    this.hovedrett = hovedrett;
    this.dessert = dessert;
    this.totalPris = forrett.getPris() + hovedrett.getPris() + dessert.getPris();
  }

  public int getTotalPris() {
    return totalPris;
  }

  public void toStrin() {
    System.out.println("\n Meny: \n");
    System.out.println(forrett.getNavn() + ", " + hovedrett.getNavn() + ", " + dessert.getNavn());
  }
}
