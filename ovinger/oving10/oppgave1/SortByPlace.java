package oppgave1;

import java.util.Comparator;

public class SortByPlace implements Comparator<Arrangement> {
  public int compare(Arrangement a, Arrangement b) {
    return a.getSted().compareTo(b.getSted());
  }
}
