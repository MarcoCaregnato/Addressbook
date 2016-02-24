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

    /**
     * Gibt den Dateipfad zurück
     *
     * @return
     */
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

    /**
     * Gibt die Anzahl der Adressen zurück, die momentan im Arraylist vorhanden sind
     *
     * @return die Anzahl der Adressen in addresses
     */
    public int getAmount() {
        amount = addresses.size();
        return amount;
    }

    /**
     * Setzt den Pfad der Datei in der die Adressen abgespeichert
     * werden sollen.
     * @param path String der nicht null und nicht leer ist
     */
    public void setPath(String path) {
        if (path != null && !path.isEmpty()) {
            this.path = path;
        }
    }

    /**
     * Gibt das Address-Objekt an der Stelle current im ArrayList
     * addresses zurück
     * @return Address-Objekt an Stelle current oder null, fals dieses
     * nicht gesetzt ist.
     */
    public Address getCurrent() {
        Address ret;
        if (current >= addresses.size())
            ret = null;
        else
            ret = addresses.get(current);
        return ret;
    }

    /**
     *Liefert das vorherige Objekt - falls vorhanden - zurück und reduziert
     *current um eins. Ist das vorherige Objekt nicht gesetzt, wird null
     * zurückgeliefert und current nicht verändert.
     * @return Addressobjekt an Stelle current oder null
     */
    public Address getPrevious() {
        Address ret;
        if (current > 0 && addresses.get(current - 1) != null) {
            current--;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     *Liefert das nächste Objekt - falls vorhanden - zurück und erhöht
     *current um eins. Ist das nächste Objekt nicht gesetzt, wird null
     * zurückgeliefert und current nicht verändert.
     * @return Addressobjekt an Stelle current oder null
     */
    public Address getNext() {
        Address ret;
        if (current < addresses.size() - 1) {
            current++;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Liefert das erste Objekt im Addressbook zurück und
     * setzt current auf dieses Objekt.
     * Ist die Liste leer, wird null zurück geliefert
     * @return Objekt an erster Stelle oder null, falls dieses
     * nicht gesetzt ist
     */
    public Address getFirst() {
        Address ret;
        if (!addresses.isEmpty()) {
            current = 0;
            ret = addresses.get(current);
        } else {
            ret = null;
        }
        return ret;
    }

    /**
     * Liefert das letzte Objekt im Addressbook zurück und
     * setzt current auf dieses Objekt.
     * Ist die Liste leer, wird null zurück geliefert
     * @return Objekt an erster Stelle oder null, falls die
     * Liste leer ist
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
     *Trägt eine neue Adresse am Ende des Arraykists ein. amount wird um eins erhöht und
     *die current wird auf das neue Objekt gesetzt.
     *Parameters:
     *@param address die neue Adresse
     *@return 0 falls das Eintragen erfolgreich war
     * -1 falls kein einzutragendes Objekt übergeben wurde
     */
    public int addNew(Address address) {
        int ret = -1;
        if (address != null) {
            ret = 0;
            addresses.add(address);
            current = addresses.size() - 1;
            amount++;
        }
        return ret;
    }

    /**
     * Ändert das aktuelle Objekt so ab, dass der Paramter address
     * gleich dem aktuellen Objekt ist.
     * sortiert ihn aber nicht ein.
     * @param address, das aktualisierte Objekt an Stelle current
     * @return 0 falls die Änderung erfolgreich durchgeführt werden konnte
     * -1 falls kein zu änderndes Objekt übergeben wurde
     * -2 falls die aktuelle Adresse unbekannt ist
     */
    public int changeCurrent(Address address) {
        int ret = 0;
        if (address != null) {
            try {
                addresses.get(current).setAddress(address);
            } catch (IndexOutOfBoundsException e) {
                ret = -2;
            }
        } else {
            ret = -1;
        }
        return ret;
    }

    /**
     * Löscht die aktuelle Adresse aus der Liste.
     * Die aktuelle Adresse wird jene Adresse die nach dem gelöschten
     * Objekt stand. Ist die zu löschende Adresse die letzte Adresse in der Liste,
     * wird die aktuelle Adresse das Objekt das vor der zu löschenden Adresse vorhanden ist.
     * Ist die zu löschende Adresse die Einzige, die gespeichert ist, wird die current auf -1 gesetzt.
     * amount wird beim Löschen immer um eins reduziert.
     * @return 0 falls das Löschen erfolgreich war
     * -1 falls das aktuelle Objekt nicht gesetzt ist
     */
    public int deleteCurrent() {
        int ret = 0;
        addresses.remove(current);
        amount--;
        if (current >= addresses.size()) {
            ret -= 1;
        }
        return ret;
    }

    /**
     * Löscht den ganzen Inhalt von addresses. Setzt amount auf 0 und current auf -1
     * @return 0 falls das Löschen erfolgreich war
     * -1 falls addresses leer ist
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
     * Liest die Adressen aus der Textdatei die in path vorhanden ist. Vorher werden die gespeicherten Adressen in
     * addresses gelöscht.
     * Nach dem Einfügen sind die Songs in sortierter Reihenfolge vorhanden.
     * current wird auf 0 gesetzt.
     * @return 0 falls die Adressen erfolgreich eingefügt wurden
     * -1 falls path nicht gesetzt ist
     * -2 falls die Datei nicht zu finden ist
     * -3 falls ein Lesefehler in der Datei vorhanden ist
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
     * Schreibt die Songs in die Textdatei die sich am Pfad path befindet.
     * Dabei werden die in der Datei gespeicherten Adressen gelöscht.
     * @return
     * 0 falls die Songs erfolgreich eingefügt wurden
     * -1 falls path nicht gesetzt wurde
     * -2 falls die Datei nicht angelegt werden konnte
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
                reSort();
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