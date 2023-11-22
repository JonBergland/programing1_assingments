public class RealEstate {
  private final int municipalityNr;
  private final String municipalityName;
  private final int lotNr;
  private final int sectionNr;
  private final String name;
  private final double area;
  private final String nameOfOwner;

  public RealEstate(int municipalityNr, String municipalityName, int lotNr, int sectionNr, String name,
  double area, String nameOfOwner){
    this.municipalityNr = municipalityNr;
    this.municipalityName = municipalityName;
    this.lotNr = lotNr;
    this.sectionNr = sectionNr;
    if (name.isEmpty()){
      name = " ---";
    }
    this.name = name;
    this.area = area;
    this.nameOfOwner = nameOfOwner;
  }
  public int getMunicipalityNr() {
    return municipalityNr;
  }
  public String getMunicipalityName() {
    return municipalityName;
  }
  public int getLotNr() {
    return lotNr;
  }
  public int getSectionNr() {
    return sectionNr;
  }
  public String getName() {
    return name;
  }
  public double getArea() {
    return area;
  }
  public String getNameOfOwner() {
    return nameOfOwner;
  }

  public String getID() {
    return municipalityNr + "-" + lotNr + "/" + sectionNr;
  }

  @Override
  public String toString(){
    return municipalityName + " " + getID() + " " + name + " " +
        area + " " + nameOfOwner;
  }
}
