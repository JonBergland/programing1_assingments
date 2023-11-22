import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.round;

public class RealEstateRegister {
  Scanner in = new Scanner(System.in);
  private final List<RealEstate> realEstateList;

  public RealEstateRegister() {
    this.realEstateList = new ArrayList<>();
  }

  public List<RealEstate> getList() {
    return this.realEstateList;
  }

  public void addRealEstate() {
    //add Municipality number
    int municipalityNr = 0;
    do {
      System.out.println("Skriv inn det unike kommunenummeret som er mellom 101-5054");
      municipalityNr = tryInt(in.nextLine(), 0);
    } while (municipalityNr < 101 || municipalityNr > 5054);

    //add Municipality name
    String municipalityName = "";
    System.out.println("Skriv inn kommunenavnet");
    do {
      municipalityName = in.nextLine();
    } while (municipalityName.isEmpty());

    //add Lot-number
    int lotNr = -1;
    do {
      lotNr = intInput("Skriv inn gårdsnummeret", -1);
    } while (lotNr < 0);

    //add Section-number
    int sectionNr = -1;
    do {
      sectionNr = intInput("Skriv inn bruksnummeret", -1);
    } while (sectionNr < 0);

    //add name for the section
    System.out.println("Skriv inn navnet på tomta");
    String name = in.nextLine();

    //add area
    double area = 0;
    do {
      area = floatInput("Skriv inn arealet til tomta", 0);
    } while (area <= 0);

    //add name of owner
    System.out.println("Skriv inn navnet på eieren");
    String nameOfOwner = in.nextLine();

    RealEstate newRealEstate = new RealEstate(municipalityNr, municipalityName,
        lotNr,sectionNr,name, area , nameOfOwner);

    this.realEstateList.add(newRealEstate);
  }

  public void removeRealEstate() {
    this.realEstateList.forEach(realEstate -> System.out.println(realEstate.getID()));

    String estateID = "";
    System.out.println("Skriv inn id-en du har lyst til å fjerne: ");
    estateID = in.nextLine();

    if (getRealEstateByID(estateID) == null) {
      System.out.println("Du skrev ikke inn en plot-id som passet med en i systemet");
    } else {
      realEstateList.remove(getRealEstateByID(estateID));
    }
  }
  public void printRealEstateList() {
    this.realEstateList.forEach(realEstate -> System.out.println(realEstate.toString()));
  }

  public void searchAfterRealEstate() {
    System.out.println("Skriv inn id-en til eiendommen du vil søke opp");
    RealEstate realEstate = getRealEstateByID(in.nextLine());
    if (realEstate == null) {
      System.out.println("En eiendom ved den id-en eksisterer ikke");
    }
    else {
      System.out.println(realEstate.toString());
    }
  }

  public RealEstate getRealEstateByID(String id) {
    for (RealEstate realEstate : realEstateList) {
      if (realEstate.getID().equalsIgnoreCase(id)) {
        return realEstate;
      }
    }
    return null;
  }

  public int getNumberOfRealEstate() {
    return realEstateList.size();
  }

  public void getAverageArea() {
    double average = 0;
    for (RealEstate realEstate : realEstateList) {
      average += realEstate.getArea();
    }
    double size = getNumberOfRealEstate();
    System.out.println(average/size + " er gjennomsnittet er arealet");
  }

  public List<RealEstate> getRealEstateByGnr(int gnr) {
    List<RealEstate> gnrList = new ArrayList<>();
    for (RealEstate realEstate : realEstateList) {
      if (realEstate.getLotNr() == gnr) {
        gnrList.add(realEstate);
      }
    }
    return gnrList;
  }

  public int intInput(String print, int dummyValue) { //en metode for en tall-input fra bruker
    System.out.println(print); //skriver ut en egendefinert streng til bruker
    String intInput = in.nextLine(); //får inn bruker-input
    return tryInt(intInput, dummyValue); //bruker intInput-metoden for å sjekke at input fra bruker er et tall
  }

  public float floatInput(String print, int dummyValue) { //en metode for en tall-input fra bruker
    System.out.println(print); //skriver ut en egendefinert streng til bruker
    String floatInput = in.nextLine(); //får inn bruker-input
    return tryFloat(floatInput, dummyValue); //bruker intInput-metoden for å sjekke at input fra bruker er et tall
  }
  private int tryInt(String tall, int dummyValue) { //en metode for å sjekke om en streng er et tall (int)
    int output = 0;
    try {
      output = Integer.parseInt(tall); //sjekker om strengen kan konverteres til tall
    } catch (NumberFormatException e) { //hvis den ikke kan konverteres blir en feilmelding skrevet ut til bruker
      System.out.println(e + ". Det du skrev inn ble ikke akseptert og verdien "
          + dummyValue + " ble satt istedet");
      output = dummyValue; //setter resultatet til dummy-verdien hvis strengen ikke kunne konverteres
    }
    return output; //returnerer den konverterte strengen eller dummy-verdien
  }

  private float tryFloat(String tall, int dummyValue) { //en metode for å sjekke om en streng er et tall (int)
    float output = 0;
    try {
      output = Float.parseFloat(tall); //sjekker om strengen kan konverteres til tall
    } catch (NumberFormatException e) { //hvis den ikke kan konverteres blir en feilmelding skrevet ut til bruker
      System.out.println(e + ". Det du skrev inn ble ikke akseptert og verdien "
          + dummyValue + " ble satt istedet");
      output = dummyValue; //setter resultatet til dummy-verdien hvis strengen ikke kunne konverteres
    }
    return output; //returnerer den konverterte strengen eller dummy-verdien
  }

}
