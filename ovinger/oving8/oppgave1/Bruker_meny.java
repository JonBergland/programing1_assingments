package oppgave1;
import javax.swing.*;
import java.util.ArrayList;

public class Bruker_meny {
    private ArrayList<ArbTaker> arbTakerArrayList;

    private boolean fortsette = true;
    public Bruker_meny(ArrayList<ArbTaker> arbTakerArrayList){
        this.arbTakerArrayList = arbTakerArrayList;
    }

    public void start() {
        String[] navneliste = toStringListe();
        var valgAvPerson = JOptionPane.showOptionDialog(null, "Velg person",
        "Person", 0, 3, null,navneliste, navneliste[0]);

        String[] options = {"Sett månedslønn", "Sett skatteprosent"};
        var valgAvEndring = JOptionPane.showOptionDialog(null, "Velg data du vil endre",
        "Datavalg", 0, 3, null, options, options[0]);

        if(valgAvEndring == 0){
            String input = JOptionPane.showInputDialog("Skriv inn ny månedslønn: ");
            tryInt(input); //tester inputt om det er int
            int nyMaanedslonn = Integer.parseInt(input);
            arbTakerArrayList.get(valgAvPerson).setMaanedslonn(nyMaanedslonn);
        } else if (valgAvEndring == 1) {
            String input = JOptionPane.showInputDialog("Skriv inn ny skatteprosent som desimaltall (eks. 10% = 0.1): ");
            tryInt(input); //tester inputt om det er int
            int nySkatteprosent = Integer.parseInt(input);
            arbTakerArrayList.get(valgAvPerson).setSkatteprosent(nySkatteprosent);
        }

        System.out.println(arbTakerArrayList.get(valgAvPerson).getNavn() + "\n"
                + arbTakerArrayList.get(valgAvPerson).getSkatt());

        int svar = JOptionPane.showConfirmDialog(null, "Vil du endre mer?", "Fortsette",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if(svar == JOptionPane.NO_OPTION){
            setFortsette(false);
        }
    }

    private String[] toStringListe(){
        String[] navneListe = new String[arbTakerArrayList.size()];
        for(int i = 0; i < arbTakerArrayList.size(); i++) {
            navneListe[i] = arbTakerArrayList.get(i).getNavn();
        }
        return navneListe;
    }

    private void tryInt(String tall){
        try {
            Integer.parseInt(tall);
        }
        catch (NumberFormatException e) {
            System.out.println("Det du skrev inn ble ikke akseptert");
            System.exit(0);
        }
    }
    private void setFortsette(boolean svar){
        fortsette = svar;
    }
    public boolean getFortsette(){
        return fortsette;
    }


}
