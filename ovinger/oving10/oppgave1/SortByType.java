package oppgave1;

import java.util.Comparator;

public class SortByType implements Comparator<Arrangement> {
  public int compare(Arrangement a, Arrangement b) {
    return a.getType().compareTo(b.getType());
  }
}
