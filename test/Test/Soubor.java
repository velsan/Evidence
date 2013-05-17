package Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Suchý Vojtěch
 */
public class Soubor {

    File file = new File("pokus.evd");

    public void vytvor() throws IOException {
        if (file.exists() == false) {
            file.createNewFile();
        }

    }

    public void zapis() throws IOException {
        System.out.println("Zapisuji");
        FileWriter fw = new FileWriter(file);
        for (int i = 35; i <= 55; i++) {
            fw.write(i);
            fw.write(" ");
        }
        fw.close();
    }
    public void cti () throws FileNotFoundException, IOException {
        System.out.println("Čtu ze souboru");
        FileReader fr =new FileReader (file);
        int c;
        while ((c=fr.read()) != -1){
            System.out.println((char)c);
        }
        fr.close();
    }
}
