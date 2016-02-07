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

    public Addressbook() {
        addresses = new ArrayList<Address>();
        current = 0;
    }

    public Address getCurrent() {
        return addresses.get(current);
    }

    public void getPrevious() {
        if (current >= 1) {
            current--;
        }
    }

    public void getNext() {
        if (current < addresses.size()) {
            current++;
        }
    }

    public void getFirst() {
        current = 0;
    }

    public void getLast() {
        int stelle = -1;
        for (int i = addresses.size() - 1; i >= 0 && stelle == -1; i--) {
            if (addresses.get(i) != null) {
                stelle = i;
            }
        }
        current = stelle;
    }

    public void addNew(Address address) {
        addresses.add(address);
        current++;
        amount++;
    }

    public void changeCurrent(Address address) {
        System.out.println(current);
        addresses.get(current).setAddress(address);
    }

    public void deleteCurrent() {
        addresses.remove(current);
        amount--;
        current--;
    }

    public void deleteAll() {
        addresses.clear();
        current = -1;
    }

    public void readAddresses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();
                if (line == null || line.isEmpty())
                    // Dateiende erkannt
                    break;
                else {
                    //addresses.set(amount, new Address());
                    //addresses.get(amount).setAddress(line);
                    Address input = new Address();
                    input.setAddress(line);
                    addresses.add(input);
                    amount++;
                    current++;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden");
        } catch (IOException e) {
            System.out.println("Lesefehler in Datei");
        }
    }

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
