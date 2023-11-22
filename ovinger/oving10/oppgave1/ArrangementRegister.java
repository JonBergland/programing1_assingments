package oppgave1;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrangementRegister {
  Scanner in = new Scanner(System.in);
  private ArrayList<Arrangement> arrangements = new ArrayList<>();

  public void intit() {
    arrangements.add(new Arrangement(101, "Kaffedrikking", "Kafeen på hjørnet", "Kaffeavhengig",
        "Sosial sammenkomst", "202112231200"));
    arrangements.add(new Arrangement(102, "Is-spising", "Is-baren", "Isavhengig",
        "Sosial sammenkomst", "202203141300"));
    arrangements.add(new Arrangement(103, "Vanndrikking", "Vann-dispenseren", "Vann-entuiast",
        "Sosial nytelse", "202306011400"));
    arrangements.add(new Arrangement(123, "Badeland", "Badelandet", "Meg",
        "Bading", "202311011200"));

    doOperation(menuList());
  }
  /**
   * Metode som lar bruker lage et nytt objekt av arrangement
   */
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
  private int menuList() { //en metode som lager en meny over funksjonene til programmet og lar bruker velge en av dem
    int menuChoice;
    do {
      String s = "-"; //en streng som skal markere et skille mellom tidligere kjørt funksjon og menyen
      System.out.println(s.repeat(30));
      //skriver ut funksjonene til bruker
      System.out.println("""
                    [1] Legg til arrangement
                    [2] Finn alle arrangementer på et gitt sted
                    [3] Finn alle arrangementer på en gitt dato
                    [4] Finn alle arrangementer mellom et gitt tidsintervall
                    [5] Sorter arrangementene
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
        case 1 -> addArrangement();
        case 2 -> choosePlace();
        case 3 -> chooseDate();
        case 4 -> chooseTimeInterval();
        case 5 -> sortListBy(sortListInput());
        case 6 -> System.exit(0);
        default -> System.out.println("Tallet du satte inn samsvarer ikke med et tall fra listen");
      }
      menuChoice = menuList();
    } while (menuChoice != 8);
  }
  private void addArrangement(){
    System.out.println("Skriv inn arrangement nummeret: ");
    int arrangementNr = tryInt(in.nextLine());

    while (checkArrangementNr(arrangementNr)){
      System.out.println("Skriv inn et unikt arrangement nummer: ");
      arrangementNr = tryInt(in.nextLine());
    }


    System.out.println("Skriv inn navnet på arrangementet: ");
    String navn = in.nextLine();

    System.out.println("Skriv inn hvor arrangementet finner sted: ");
    String sted = in.nextLine();

    System.out.println("Skriv inn arrangøren av arrangementet: ");
    String arrangor = in.nextLine();

    System.out.println("Skriv inn type arrangementet");
    String type = in.nextLine();

    System.out.println("Skriv inn tidspunktet på arrangementet på formen ååååmmddtimetimeminmin");
    String tidspunkt = in.nextLine();

    //Lager en objekt av TrainDeparture med verdiene vi fikk fra bruker og legger den inn i Table-objektet
    Arrangement newArrangement = new Arrangement(arrangementNr, navn, sted, arrangor, type, tidspunkt);
    arrangements.add(newArrangement);
  }
  private void choosePlace() { //en metode for å la bruker velge en sted fra en liste
    ArrayList<Arrangement> placeList = new ArrayList<>();
    String print = "";
    do {
      System.out.print(print);
      System.out.println("Skriv inn et sted: ");
      String place = in.nextLine();
      for (Arrangement arrangement : arrangements) {
        if (place.equalsIgnoreCase(arrangement.getSted())){
          placeList.add(arrangement);
        }
      }

      print = "Du må sette inn en sted som arrangementene finner sted\n";
    } while (placeList.isEmpty());
    placeList.forEach(Arrangement::toStrin);
  }
  private void chooseDate(){
    ArrayList<Arrangement> dateList = new ArrayList<>();
    String print = "";
    do {
      System.out.print(print);
      System.out.println("Skriv inn en dato på formen ÅÅÅÅMMDD: ");
      String date = in.nextLine();
      for (Arrangement arrangement : arrangements) {
        if (date.equals(arrangement.getTidspunkt().substring(0, 8))) {
          dateList.add(arrangement);
        }
      }
      print = "Du må sette inn en dato som arrangement finner sted på\n";
    } while (dateList.isEmpty());

    dateList.forEach(Arrangement::toStrin);
  }
  private void chooseTimeInterval(){
    arrangements.sort(new SortByTime());
    ArrayList<Arrangement> arrangementList = new ArrayList<>();
    String print = "";
    do {
      System.out.print(print);
      System.out.println("Skriv inn en dato på formen ÅÅÅÅMMDD: ");
      String date1 = in.nextLine();

      System.out.println("Skriv inn en ny dato på formen ÅÅÅÅMMDD: ");
      String date2 = in.nextLine();
      for (Arrangement arrangement : arrangements) {
        if (date1.compareTo(arrangement.getTidspunkt().substring(0, 8)) < 0 && date2.compareTo(arrangement.getTidspunkt().substring(0, 8)) > 0) {
          arrangementList.add(arrangement);
        }
      }
      print = "Du må sette inn et tidsinterval som det befinner seg arrangement i\n";
    } while (arrangementList.isEmpty());

    arrangementList.forEach(Arrangement::toStrin);
  }
  private int sortListInput(){
    System.out.println("Velg en av atributtene å sortere listen etter: ");
    System.out.println("[1] Sted \n[2] Type arrangement \n[3] Tidspunkt");
    return tryInt(in.nextLine());
  }
  private void sortListBy(int sortChoice){
    do {
      switch (sortChoice) {
        case 1 -> arrangements.sort(new SortByPlace());
        case 2 -> arrangements.sort(new SortByType());
        case 3 -> arrangements.sort(new SortByTime());
        default -> {
          System.out.println("Du må sette inn et tall fra listen");
          sortChoice = sortListInput();
        }
      }

    } while (sortChoice < 1 || sortChoice > 3);


    arrangements.forEach(Arrangement::toStrin);
  }

  private boolean checkArrangementNr(int arrangementNr){
    boolean output = false;
    for (Arrangement arrangement : arrangements) {
      if (arrangementNr == arrangement.getArrangementNr()){
        output = true;
        break;
      }
    }
    return output;
  }

}
