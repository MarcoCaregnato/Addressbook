import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Andreas on 03.02.16.
 */
public class Addressbook {

    private List<Address> addresses;
    private int current;
    private int amount;
    private String path = "/Users/Andreas/Desktop/test/test.csv";

    /**
     * Customkonstruktor, der das ArrayList erstellt und die aktuelle
     * Position (current) auf 0 setzt
     */
    public Addressbook() {
        addresses = new ArrayList<>();
        current = 0;
    }

    /**
     * Gibt das Address-Objekt an der Stelle current im ArrayList
     * addresses zurück
     *
     * @return Address-Objekt an Stelle current
     */
    public Address getCurrent() {
        return addresses.get(current);
    }

    /**
     * Reduziert current um 1, sofern current größer oder gleich 1 ist
     */
    public void getPrevious() {
        if (current >= 1) {
            current--;
        }
    }

    /**
     * Erhöht current um 1, sofern current kleiner als die Stellenanzahl von
     * addresses ist, ansonsten wird ein neues Address-Objekt hinzugefügt und
     * dann current um 1 erhöht.
     */
    public void getNext() {
        if (current < addresses.size()) {
            current++;
        }
        else {
            addNew(new Address());
            current++;
        }

    }

    /**
     * Setzt current auf 0, sodass der Benutzer auf das erste Element in addresses
     * zugreifen kann
     */
    public void getFirst() {
        current = 0;
    }

    /**
     * Setzt current auf das letzte Element im ArrayList addresses, sodass der Benutzer
     * auf das letzte Objekt zugreifen kann
     */
    public void getLast() {
        current = addresses.size() - 1;
    }

    /**
     * Fügt ein neues Address-Objekt an addresses hinzu und erhöht amount und current um 1
     * @param address, das hinzuzufügende Objekt
     */
    public void addNew(Address address) {
        addresses.add(address);
        current++;
        amount++;
    }

    /**
     * Ändert das Objekt an der Stelle current
     * @param address, das aktualisierte Objekt an Stelle current
     */
    public void changeCurrent(Address address) {
        addresses.get(current).setAddress(address);
    }

    /**
     * Löscht das Objekt an der Stelle current und
     * reduziert amount um 1
     */
    public void deleteCurrent() {
        addresses.remove(current);
        amount--;
    }

    /**
     * Löscht den gesammten Inhalt von addresses und setzt current auf -1
     */
    public void deleteAll() {
        addresses.clear();
        current = -1;
    }

    /**
     * Liest Address-Objekte aus einer CSV-Datei im Pfad path aus und speichert
     * sie in addresses, wobei bei jedem Hinzufügen amount um 1 erhöht wird
     */
    public void readAddresses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty())
                    // Dateiende erkannt
                    break;
                else {
                    Address input = new Address();
                    input.setAddress(line);
                    addresses.add(input);
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

    /**
     * Schreibt den Inhalt von addresses in die Datei im Pfad path
     */
    public void writeAddresses() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (Address x : addresses) {
                if (x != null) {
                    writer.write(x.toString());
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Datei nicht angelegt");
        }
    }

    /**
     * Sortiert die Address-Objekte in addresses mit der Methode "Sortieren durch
     * Einsetzen", wobei als erstes die Eigenschaft surname verglichen wird
     */
    public void reSort() {
        for (int i = 1; i < addresses.size(); i++) {
            int j = i - 1;
            Address temp = addresses.get(i).clone();
            if (addresses.get(i).getSurname().compareTo(addresses.get(j).getSurname()) < 0) {
                addresses.set(i, addresses.get(j).clone());
                addresses.set(j, temp.clone());
            }
        }
    }
}