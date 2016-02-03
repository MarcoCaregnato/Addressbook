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
        current++;
        return adresses[current];
    }
}
