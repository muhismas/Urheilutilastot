
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Urheilutilastot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Minkä niminen tiedosto luetaan?");
        String tiedosto = lukija.nextLine();
        System.out.println("Minkä nimisen joukkueen tiedot tulostetaan?");
        String kotijoukkue = lukija.nextLine();

        Scanner tiedostonLukija;
        try {
            tiedostonLukija = new Scanner(new File(tiedosto));
            int lkm = 0, voittoja=0, tappioita=0;
            while (tiedostonLukija.hasNextLine()) {
                String rivi = tiedostonLukija.nextLine();
                if(rivi.contains(kotijoukkue)){
                    lkm++;
                    String[] palat = rivi.split(",");
                    if(palat[0].equals(kotijoukkue)){
                        if(Integer.valueOf(palat[2])<Integer.valueOf(palat[3])){
                            tappioita++;
                        } else{
                            voittoja++;
                        }
                    } else{
                        if(Integer.valueOf(palat[2])<Integer.valueOf(palat[3])){
                            voittoja++;
                        } else{
                            tappioita++;
                        }
                    }
                }
            }
            System.out.println("Otteluita: "+lkm);
            System.out.println("Voittoja: "+voittoja);
            System.out.println("Tappioita: "+tappioita);

        } catch (Exception e) {
            System.out.println("Virhe: "+e);
        }

    }

}
