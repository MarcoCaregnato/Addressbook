import java.io.*;

/**
 * Created by Andreas on 03.02.16.
 */
public class Addressbook {

    private Address[] addresses;
    private int current;
    private int amount;
    private String path = "/Users/Andreas/Desktop/test/test.csv";

    public Addressbook(int max_amount) {
        addresses = new Address[max_amount];
        current = 0;
    }

    public Address getCurrent() {
        return addresses[current];
    }

    public void getPrevious() {
        if (current >= 1) {
            current--;
        }
    }

    public void getNext() {
        if (current < addresses.length) {
            current++;
        }
    }

    public void getFirst() {
        current = 0;
    }

    public void getLast() {
        int stelle = -1;
        for (int i = addresses.length - 1; i >= 0 && stelle == -1; i--) {
            if (addresses[i] != null) {
                stelle = i;
            }
        }
        current = stelle;
    }

    public void addNew(Address address) {
        if ((amount + 1) < addresses.length) {
            amount++;
            addresses[amount] = new Address();
            addresses[amount].setAddress(address);
            current = amount;
        }
    }

    public void changeCurrent(Address address) {
        addresses[current] = new Address();
        addresses[current].setAddress(address);
    }

    public void deleteCurrent() {
        addresses[current] = new Address();
        amount--;
        current--;
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
                if (line == null || line.isEmpty())
                    // Dateiende erkannt
                    break;
                else {
                    addresses[amount] = new Address();
                    addresses[amount].setAddress(line);
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
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Datei nicht angelegt");
        }
    }

    public void reSort() {
        for (Address x :addresses) {
            System.out.println(x.toString());
        }
    }
}
