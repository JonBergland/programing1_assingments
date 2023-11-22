public class reversert_tabell {
    public static void main(String[] args) {
        int[] tabell1 = {2,4,6,-12};
        int[] tabell2 = {7, 14, -6, 10};


        for (int i = 0; i < tabell1.length; i++) {
            tabell2[i] = tabell1[tabell1.length - i -1];
        }
        for (int j = 0; j < tabell2.length; j++) {
            System.out.println(tabell2[j]);
        }
        /*for (int k: tabell2){
            System.out.println(k);
        }*/

    }
}
