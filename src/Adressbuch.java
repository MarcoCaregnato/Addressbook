import java.io.*;

/**
 * Created by Andreas on 03.02.16.
 */
public class Adressbuch {

    private Address[] addresses;
    private int current;
    private int amount;
    private String path = "/Users/Andreas/Desktop/test/test.csv";

    public Adressbuch(int max_amount) {
        addresses = new Address[max_amount];
        current = 0;
    }

    public Address getCurrent() {
        return addresses[current];
    }

    public Address getPrevious() {
        if (current > 0) {
            current--;
            return getCurrent();
        }
        else return null;
    }

    public Address getNext() {
        if (current < addresses.length) {
            current++;
        }
        return getCurrent();
    }

    public Address getFirst() {
        current = 0;
        return getCurrent();
    }

    public Address getLast() {
        int stelle = -1;
        for (int i = addresses.length - 1; i >= 0 && stelle == -1; i--) {
            if (addresses[i] != null) {
                stelle = i;
            }
        }
        current = stelle;
        return getCurrent();
    }

    public void addNew(Address address) {
        if (amount + 1 < addresses.length) {
            addresses[amount + 1] = new Address();
            addresses[amount + 1].setAdress(address);
            amount++;
        }
    }

    public Address changeCurrent(Address address) {
        addresses[current].setAdress(address);
        return getCurrent();
    }

    public void deleteCurrent() {
        if (current != -1)
        addresses[current] = null;
    }

    public void deleteAll() {
        for (int i = 0; i < addresses.length; i++) {
            addresses[i] = null;
        }
        current = -1;
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
                    addresses[amount] = new Address();
                    addresses[amount].setAdress(line);
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

    public void writeAdresses() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (Address x : addresses) {
                if (x != null) {
                    writer.write(x.toString());
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Datei nicht angelegt");
        }
    }
}
