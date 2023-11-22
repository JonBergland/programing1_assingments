package oppgave1;

import java.util.Comparator;

public class SortByTime implements Comparator<Arrangement> {
  public int compare(Arrangement a, Arrangement b){
    return a.getTidspunkt().compareTo(b.getTidspunkt());
  }
}
