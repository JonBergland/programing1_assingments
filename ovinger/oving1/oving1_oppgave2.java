/**
 * Øving 1, Oppgave 2
 * 
 * Omgjøre timer, minutter og sekunder om til antall sekunder
 * 
 */

import static javax.swing.JOptionPane.*;

class oving1Oppgave2 {
    public static void main(String[] args){
        showMessageDialog(null, "Her kan du gjøre om til antall sekunder fra timer, minuter og sekunder" );
        String antallTimer = showInputDialog("Skriv inn antall timer: ");
        String antallMinutter = showInputDialog("Skriv inn antall minutter: ");
        String antallSekunder = showInputDialog("Skriv inn antall sekunder: ");

        double timer = Double.parseDouble(antallTimer);
        double minutter = Double.parseDouble(antallMinutter);
        double sekunder = Double.parseDouble(antallSekunder);

        if(timer>=0 && minutter >= 0 && sekunder >= 0){
            double totaleSekunder = timer*3600 + minutter*60 + sekunder;
            showMessageDialog(null, "Du har " + totaleSekunder + " sekunder");
        }
        else{
            showMessageDialog(null, "Feilmelding");
        }

    }
}
