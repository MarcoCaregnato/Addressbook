import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andreas on 03.02.16.
 */
public class Addressbook {

    private List<Address> addresses;
    private int current;
    private int amount;
    private String path;

    public String getPath() {
        return path;
    }

    /**
     * Customkonstruktor, der das ArrayList erstellt und die aktuelle
     * Position (current) auf 0 setzt
     */
    public Addressbook() {
        addresses = new ArrayList<>();
        current = 0;
    }

    public int getAmount() {
        amount = addresses.size();
        return amount;
    }

    public void setPath(String path) {
        if (path != null && !path.isEmpty()) {
            this.path = path;
        }
    }

    /**
     * Gibt das Address-Objekt an der Stelle current im ArrayList
     * addresses zurück
     *
     * @return Address-Objekt an Stelle current
     */
    public Address getCurrent() {
        Address ret;
        if (addresses.get(current) == null)
            ret = null;
        else
            ret = addresses.get(current);
        return ret;
    }

    /**
     * Reduziert current um 1, sofern current größer oder gleich 1 ist
     */
    public Address getPrevious() {
        Address ret;
        if (current >= 1 && addresses.get(current - 1) != null) {
            current--;
            ret = getCurrent();
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Erhöht current um 1, sofern current kleiner als die Stellenanzahl von
     * addresses ist und gibt , ansonsten wird ein neues Address-Objekt hinzugefügt und
     * dann current um 1 erhöht.
     */
    public Address getNext() {
        Address ret;
        if (current < addresses.size() && addresses.get(current) != null) {
            current++;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Setzt current auf 0, sodass der Benutzer auf das erste Element in addresses
     * zugreifen kann
     */
    public Address getFirst() {
        Address ret;
        if (addresses.size() != 0) {
            current = 0;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Setzt current auf das letzte Element im ArrayList addresses, sodass der Benutzer
     * auf das letzte Objekt zugreifen kann
     */
    public Address getLast() {
        Address ret;
        if (addresses.size() != 0) {
            current = addresses.size() - 1;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;

    }

    /**
     * Fügt ein neues Address-Objekt an addresses hinzu und erhöht amount und current um 1
     *
     * @param address, das hinzuzufügende Objekt
     */
    public int addNew(Address address) {
        int ret = -1;
        if (address != null) {
            ret = 0;
            addresses.add(address);
            current++;
            amount++;
        }
        return ret;
    }

    /**
     * Ändert das Objekt an der Stelle current
     *
     * @param address, das aktualisierte Objekt an Stelle current
     */
    public int changeCurrent(Address address) {
        int ret = 0;
        if (address != null) {
            addresses.get(current).setAddress(address);
        } else {
            ret = -1;
        }
        return ret;
    }

    /**
     * Löscht das Objekt an der Stelle current und
     * reduziert amount um 1
     */
    public int deleteCurrent() {
        int ret = 0;
        addresses.remove(current);
        amount--;
        if (addresses.get(current) == null) {
            ret = -1;
        }
        return ret;
    }

    /**
     * Löscht den gesammten Inhalt von addresses und setzt current auf -1
     */
    public int deleteAll() {
        int ret = 0;
        if (!addresses.isEmpty()) {
            addresses.clear();
            amount = 0;
            current = -1;
        } else {
            ret = -1;
        }
        return ret;
    }

    /**
     * Liest Address-Objekte aus einer CSV-Datei im Pfad path aus und speichert
     * sie in addresses, wobei bei jedem Hinzufügen amount um 1 erhöht wird
     */
    public int readAddresses() {
        int ret = 0;
        this.deleteAll();
        if (path == null)
            ret = -1;
        if (ret == 0) {
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
                ret = -1;
            } catch (IOException e) {
                ret = -3;
            }
        }
        return ret;
    }

    /**
     * Schreibt den Inhalt von addresses in die Datei im Pfad path
     */
    public int writeAddresses() {
        int ret = 0;
        if (path == null) {
            ret = -1;
        }
        if (ret == 0) {
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(path));
                for (Address x : addresses) {
                    if (x != null) {
                        writer.write(x.toString());
                        writer.write("\n");
                    }
                }
                writer.close();
            } catch (FileNotFoundException e) {
                ret = -2;
            } catch (IOException e) {
                ret = -3;
            }
        }
        return ret;
    }

    /**
     * Sortiert die Address-Objekte in addresses mit der Methode "Sortieren durch
     * Einsetzen", wobei als erstes die Eigenschaft surname verglichen wird
     */
    public void reSort() {
        for (int i = 0; i < addresses.size(); i++) {
            for (int j = i; j < addresses.size(); j++) {
                Address temp;
                temp = addresses.get(j).clone();
                if (temp.compareTo(addresses.get(i)) < 0) {
                    addresses.get(j).setAddress(addresses.get(i).clone());
                    addresses.get(i).setAddress(temp.clone());
                }
            }
        }
    }
}