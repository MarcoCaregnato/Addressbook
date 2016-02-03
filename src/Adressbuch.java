import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 03.02.16.
 */
public class Adressbuch {

    private Adresse[] adresses;
    private int current;
    private int amount;
    private String path;

    public Adressbuch(int max_amount) {
        adresses = new Adresse[max_amount];
        current = 0;
    }

    public Adresse getCurrent() {
        return adresses[current];
    }

    public Adresse getNext() {
        if (current < adresses.length) {
            current++;
        }
        return adresses[current];
    }

    public Adresse getFirst() {
        current = 0;
        return getCurrent();
    }

    public Adresse getLast() {
        int stelle = -1;
        for (int i = adresses.length; i >= 0 && stelle == -1; i--) {
            if (adresses[i] != null) {
                stelle = i;
            }
        }
        current = stelle;
        return adresses[stelle];
    }

    public Adresse addNew(Adresse adresse) {
        adresses[amount + 1] = new Adresse();
        adresses[amount + 1].setAdresse(adresse);
        amount++;
        return getLast();
    }

    public Adresse changeCurrent(Adresse adresse) {
        adresses[current].setAdresse(adresse);
        return getCurrent();
    }

    public void deleteCurrent() {
        adresses[current] = null;
    }

    public void deleteAll() {
        for (Adresse x : adresses) {
            x = null;
        }
    }

    public void readAdresses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    // Dateiende erkannt
                    break;
                else {
                    adresses[amount] = new Adresse();
                    adresses[amount].setAdresse(line);
                    amount++;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        } catch (IOException e) {
            System.out.println("Lesefehler in Datei");
        }
    }
}
