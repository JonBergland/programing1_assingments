public class UserInterface {
  RealEstateRegister realEstateRegister = new RealEstateRegister();

  public void start() {
    intit();
    doOperation(menuList());
  }

  public void intit() {
    realEstateRegister.getList().add(new RealEstate(1445,"Gloppen",
        77, 631, "", 1017.6, "Jens Olsen"));
  }

  private int menuList() { //en metode som lager en meny over funksjonene til programmet og lar bruker velge en av dem
    int menuChoice;
    do {
      String s = "-"; //en streng som skal markere et skille mellom tidligere kjørt funksjon og menyen
      System.out.println(s.repeat(30));
      //skriver ut funksjonene til bruker
      System.out.println("""
          [1] Registrer en ny eiendom
          [2] Skriv ut alle eiendommene
          [3] Søk etter en eiendomm ved hjelp av id-en
          [4] Få ut gjennomsnittet av alle eiendommenes arealer
          [5] Avslutt
          """);

      //får inn valgt funksjon fra bruker og legger i variablen menuChoice
      String output = "Skriv inn tallet som korresponderer med handlingen du vil utføre: ";
      menuChoice = realEstateRegister.intInput(output, 0);
    } while (menuChoice == 0);
    return menuChoice; //returnerer valgt int verdi
  }

  private void doOperation(int menuChoice) { //en metode som tar inn tallverdien som bruker satte inn som parameter
    do { //kjører en do-while løkke som kjører så lenge meny-valget ikke er 8
      switch (menuChoice) { //bruker switch til å kjøre metoden som tilsvarer til den brukervalgte verdien
        case 1 -> realEstateRegister.addRealEstate();
        case 2 -> realEstateRegister.printRealEstateList();
        case 3 -> realEstateRegister.searchAfterRealEstate();
        case 4 -> realEstateRegister.getAverageArea();
        case 5 -> System.exit(0);
        default -> System.out.println("Tallet du satte inn samsvarer ikke med et tall fra listen");
      }
      menuChoice = menuList();
    } while (true);
  }
}
