package oppgave2;

import java.util.ArrayList;
import java.util.Scanner;

public class MenyRegister {
  Scanner in = new Scanner(System.in);
  private ArrayList<Rett> rettArrayList = new ArrayList<>();
  private ArrayList<Meny> menyArrayList = new ArrayList<>();

  public void start(){
    init();
    doOperation(menuList());

  }
  private void init(){
    rettArrayList.add(new Rett("Havregrøt", "Hovedrett", 20, "Bland ingredienser"));
    rettArrayList.add(new Rett("Risgrøt", "Hovedrett", 25, "Bland ingredienser"));
    rettArrayList.add(new Rett("Rømmegrøt", "Hovedrett", 30, "Bland ingredienser"));
    rettArrayList.add(new Rett("Tomatsuppe", "Forrett", 40, "Bland ingredienser"));
    rettArrayList.add(new Rett("Grønnsaksuppe", "Forrett", 25, "Bland ingredienser"));
    rettArrayList.add(new Rett("Sjokoladekake", "Dessert", 45, "Bland ingredienser"));
    rettArrayList.add(new Rett("Gulrotkake", "Dessert", 41, "Bland ingredienser"));
    rettArrayList.add(new Rett("Ostekake", "Dessert", 50, "Bland ingredienser"));
    rettArrayList.add(new Rett("Bløtkake", "Dessert", 43, "Bland ingredienser"));
    rettArrayList.add(new Rett("Oreokake", "Dessert", 42, "Bland ingredienser"));

  }

  private int menuList() { //en metode som lager en meny over funksjonene til programmet og lar bruker velge en av dem
    int menuChoice;
    do {
      String s = "-"; //en streng som skal markere et skille mellom tidligere kjørt funksjon og menyen
      System.out.println(s.repeat(30));
      //skriver ut funksjonene til bruker
      System.out.println("""
                    [1] Registrer en ny rett
                    [2] Finn en rett med hjelp av navnet
                    [3] Finn alle retter av gitt type
                    [4] Registrer en ny meny
                    [5] Finn alle menyer mellom et gitt prisintervall
                    [6] Avslutt
                    """);

      //får inn valgt funksjon fra bruker og legger i variablen menuChoice
      System.out.println("Skriv inn tallet som korresponderer med handlingen du vil utføre: ");
      menuChoice = tryInt(in.nextLine());
      //hvis det som ble satt inn ikke var et tall, blir dummy-verdien 0 satt inn og løkka gjentas
    } while (menuChoice == 0);
    return menuChoice; //returnerer valgt int verdi
  }
  private void doOperation(int menuChoice) { //en metode som tar inn tallverdien som bruker satte inn som parameter
    do { //kjører en do-while løkke som kjører så lenge meny-valget ikke er 8
      switch (menuChoice) { //bruker switch til å kjøre metoden som tilsvarer til den brukervalgte verdien
        case 1 -> addRett();
        case 2 -> findRettOfNavn();
        case 3 -> findRettOfType();
        case 4 -> addMeny();
        case 5 -> menyMedPrisMellom(intInput("Nedre grense"), intInput("Øvre grense"));
        case 6 -> System.exit(0);
        default -> System.out.println("Tallet du satte inn samsvarer ikke med et tall fra listen");
      }
      menuChoice = menuList();
    } while (menuChoice != 8);
  }

  private void addRett(){
    System.out.println("Skriv inn navnet på retten: ");
    String navn = in.nextLine();

    while (checkNavn(navn)){
      System.out.println("Det navnet eksisterer allerede: ");
      navn = in.nextLine();
    }

    System.out.println("Skriv inn type rett: ");
    String type = in.nextLine();

    System.out.println("Skriv inn prisen: ");
    String intInput = in.nextLine();
    int pris = tryInt(intInput);

    System.out.println("Skriv inn oppskriften til retten: ");
    String oppskrift = in.nextLine();

    Rett rett = new Rett(navn, type, pris, oppskrift);
    rettArrayList.add(rett);
  }

  private Rett rettOfNavn(String navn){
    for (Rett rett : rettArrayList) {
      if(rett.getNavn().equalsIgnoreCase(navn)){
        return rett;
      }
    }
    return null;
  }
  private void findRettOfNavn(){
    System.out.println("Skriv inn navnet på retten du vil finne: ");
    Rett rett = rettOfNavn(in.nextLine());
    while (rett == null){
      System.out.println("Du skrev ikke inn navnet på en registrert rett. Prøv igjen: ");
      rett = rettOfNavn(in.nextLine());
    }
    rett.toStrin();
  }

  private ArrayList<Rett> rettOfType(String type){
    ArrayList<Rett> rettOfType = new ArrayList<>();
    for (Rett rett : rettArrayList) {
      if(rett.getType().equalsIgnoreCase(type)){
        rettOfType.add(rett);
      }
    }
    return rettOfType;
  }

  private void findRettOfType(){
    System.out.println("Skriv inn typen retter du vil finne: ");
    ArrayList<Rett> retter = rettOfType(in.nextLine());
    while (retter.isEmpty()){
      System.out.println("Du skrev ikke inn navnet på en registrert type rett. Prøv igjen: ");
      retter = rettOfType(in.nextLine());
    }
    retter.forEach(Rett::toStrin);
  }

  private void addMeny(){
    Rett forrett = chooseRettByType("forrett", "Skriv inn navnet på forretten du ønsker: ");

    Rett hovedrett = chooseRettByType("hovedrett", "Skriv inn navnet på hovedretten du ønsker: ");

    Rett dessert = chooseRettByType("dessert", "Skriv inn navnet på desserten du ønsker: ");

    Meny meny = new Meny(forrett, hovedrett, dessert);
    menyArrayList.add(meny);
  }
  private Rett chooseRettByType(String type, String detaljer){
    System.out.println(detaljer);
    rettOfType(type).forEach(Rett::toStrin);

    Rett rett = rettOfNavn(in.nextLine());

    while (rett == null){
      System.out.println("Du må sette inn navnet på en rett: ");
      rett = rettOfNavn(in.nextLine());
    }

    return rett;
  }

  private void menyMedPrisMellom(int nedre, int ovre){
    if (nedre <= ovre) {
      menyArrayList.forEach(meny -> {
        if (meny.getTotalPris() > nedre && meny.getTotalPris() < ovre) {
          meny.toStrin();
        }
      });
    }
    else {
      System.out.println("Nedre grense er ikke mindre enn eller lik øvre grense");
    }
  }

  private boolean checkNavn(String navn) {
    boolean output = false;
    for (Rett rett : rettArrayList) {
      if(navn.equalsIgnoreCase(rett.getNavn())){
        output = true;
        break;
      }
    }
    return output;
  }

  private int intInput(String detaljer){
    System.out.println(detaljer);
    int intInput = tryInt(in.nextLine());
    return intInput;
    }


  private int tryInt(String tall){ //en metode for å sjekke om en streng er et tall (int)
    int output = 0;
    try {
      output = Integer.parseInt(tall); //sjekker om strengen kan konverteres til tall
    }
    catch (NumberFormatException e) { //hvis den ikke kan konverteres blir en feilmelding skrevet ut til bruker
      System.out.println(e + ". Det du skrev inn ble ikke akseptert og verdien 0 ble satt inn istedet");
    }
    return output; //returnerer den konverterte strengen eller dummy-verdien
  }

}
