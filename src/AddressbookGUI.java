import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class AdressbuchGUI extends JFrame {

    private static Address address = new Address();
    private static Addressbook addressbook;

    private JLabel vorname;
    private JTextField vornamefield;

    private JLabel nachname;
    private JTextField nachnamefield;

    private JLabel email;
    private JTextField emailfield;

    private JLabel handynummer;
    private JTextField handynummerfield;

    private JLabel telnummer;
    private JTextField telnummerfield;

    private JLabel hausnummer;
    private JTextField hausnummerfield;

    private JLabel strasse;
    private JTextField strassefield;

    private JLabel land;
    private JTextField landfield;

    private JLabel ort;
    private JTextField ortfield;

    private JLabel plz;
    private JTextField plzfield;

    private JButton fore;
    private JButton back;
    private JButton neu;
    private JButton cancel;
    private JButton begin;
    private JButton end;
    private JButton deleteall;

    public AdressbuchGUI() {
        addressbook = new Addressbook();
        addressbook.setPath("/home/oem/Documents/Schule/Informatik/test/test.csv");
        addressbook.readAddresses();
        //Fenster Titel
        setTitle("Adressbuch");
        //Fenstergroesse
        setBounds(0, 0, 650, 350);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                vergleich();
                addressbook.reSort();
                addressbook.writeAddresses();
                System.exit(0);
            }
        });

        //Nachname Schrift
        nachname = new JLabel("Nachname:");
        nachname.setBounds(50, 30, 80, 20);

        //Nachname Textfeld
        nachnamefield = new JTextField();
        nachnamefield.setBounds(135, 30, 150, 25);

        //Vorname Schrift
        vorname = new JLabel("Vorname:");
        vorname.setBounds(350, 30, 80, 20);

        //Vorname Textfeld
        vornamefield = new JTextField();
        vornamefield.setBounds(425, 30, 150, 25);

        //Email Schrift
        email = new JLabel("Email:");
        email.setBounds(50, 154, 80, 20);

        //Email Textfeld
        emailfield = new JTextField();
        emailfield.setBounds(135, 150, 250, 25);

        //Handynummer Schrift
        handynummer = new JLabel("Mobil:");
        handynummer.setBounds(340, 194, 60, 20);

        //Handynummer Textfeld
        handynummerfield = new JTextField();
        handynummerfield.setBounds(405, 190, 170, 25);

        //Telefonnummer Schrift
        telnummer = new JLabel("Tel:");
        telnummer.setBounds(50, 194, 30, 20);

        //Telefonnummer Textfeld
        telnummerfield = new JTextField();
        telnummerfield.setBounds(135, 192, 170, 25);

        //Hausnummer Schrift
        hausnummer = new JLabel("Nr:");
        hausnummer.setBounds(475, 72, 30, 20);

        //Hausnummer Textfeld
        hausnummerfield = new JTextField();
        hausnummerfield.setBounds(510, 70, 65, 25);

        //Strasse Schrift
        strasse = new JLabel("Strasse:");
        strasse.setBounds(50, 72, 70, 20);

        //Strasse Textfeld
        strassefield = new JTextField();
        strassefield.setBounds(135, 70, 300, 25);

        //Land Schrift
        land = new JLabel("Land:");
        land.setBounds(430, 112, 50, 20);

        //Land Textfeld
        landfield = new JTextField();
        landfield.setBounds(480, 110, 95, 25);

        //Ort Schrift
        ort = new JLabel("Ort:");
        ort.setBounds(50, 112, 70, 20);

        //Ort Textfeld
        ortfield = new JTextField();
        ortfield.setBounds(135, 110, 150, 25);

        //Postleitzahl Schrift
        plz = new JLabel("PLZ:");
        plz.setBounds(300, 112, 40, 20);

        //Postleitzahl Textfield
        plzfield = new JTextField();
        plzfield.setBounds(345, 110, 60, 25);

        //BUTTON naechste addressbook
        fore = new JButton();
        fore.setText("->");
        fore.setBounds(350, 250, 100, 30);

        //BUTTON vorherige addressbook
        back = new JButton();
        back.setText("<-");
        back.setBounds(200, 250, 100, 30);

        //BUTTON erste addressbook
        begin = new JButton();
        begin.setText("<|");
        begin.setBounds(50, 250, 100, 30);

        //BUTTON letzte addressbook
        end = new JButton();
        end.setText("|>");
        end.setBounds(500, 250, 100, 30);

        //BUTTON neue addressbook
        neu = new JButton();
        neu.setText("new");
        neu.setBounds(50, 300, 175, 30);

        //BUTTON addressbook loeschen
        cancel = new JButton();
        cancel.setText("delete");
        cancel.setBounds(410, 300, 190, 30);

        //BUTTON alles loeschen
        deleteall = new JButton();
        deleteall.setText("delete all");
        deleteall.setBounds(255, 300, 125, 30);


        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.add(vorname);
        contentPane.add(vornamefield);

        contentPane.add(nachname);
        contentPane.add(nachnamefield);

        contentPane.add(email);
        contentPane.add(emailfield);

        contentPane.add(handynummer);
        contentPane.add(handynummerfield);

        contentPane.add(telnummer);
        contentPane.add(telnummerfield);

        contentPane.add(hausnummer);
        contentPane.add(hausnummerfield);

        contentPane.add(strasse);
        contentPane.add(strassefield);

        contentPane.add(land);
        contentPane.add(landfield);

        contentPane.add(ort);
        contentPane.add(ortfield);

        contentPane.add(plz);
        contentPane.add(plzfield);

        contentPane.add(fore);
        contentPane.add(back);
        contentPane.add(begin);
        contentPane.add(end);
        contentPane.add(neu);
        contentPane.add(cancel);
        contentPane.add(deleteall);

        //Fenster sichbar machen
        address = addressbook.getCurrent();
        fuellen(address);
        setVisible(true);

        //JButton mit der Aufschrift: "<-"
        back.addActionListener(
                new ActionListener() {
                    @Override
                    /**
                     *  Kontrolliert ob die vorherige addressbook ungleich null ist.
                     *  Ist das der Fall so wird die vorherige addressbook mit Hilfe
                     *  der Methode füllen(Address i) ausgegeben,
                     *  ansont wird die Methode stackfail() aufgrufen.
                     */
                    public void actionPerformed(ActionEvent e) {
                        vergleich();
                        address = addressbook.getPrevious();
                        if (address != null) {
                            fuellen(address);
                        } else
                            stackfail();
                    }
                }
        );
        //JButton mit der Aufschrif: "->"
        fore.addActionListener(
                new ActionListener() {
                    /**
                     * Kontrolliert ob die nächste addressbook ungleich null ist.
                     * Ist das der Falll so wird die nächste addressbook mit Hilfe
                     * der Methode füllen(Address i) ausgegeben,
                     * ansonst wird die Methode neu() aufgerufen.
                     */
                    public void actionPerformed(ActionEvent e) {
                        vergleich();
                        address = addressbook.getNext();
                        if (address!= null) {
                            fuellen(address);
                        } else {
                        	if(addressbook.getCurrent().compareTo(new Address()) != 0){
                        		addressbook.addNew(new Address());
                            	neu();
                        	}
                        }
                    }
                }

        );
        //JButton mit der Aufschrift: "new"
        neu.addActionListener(
                new ActionListener() {
                    /**
                     * Ruft die Methode neu() auf.
                     */
                    public void actionPerformed(ActionEvent e) {
                        addressbook.addNew(new Address());
                        neu();
                    }
                }

        );
        //JButten mit der Aufschrift: "<|"
        begin.addActionListener(
                new ActionListener() {
                    /**
                     * Speichert die erste Adresse ab und gibt
                     * die mit Hilfe der Methode fuellen(Address i)
                     */
                    public void actionPerformed(ActionEvent e) {
                        vergleich();
                        address = addressbook.getFirst();
                        fuellen(address);


                    }
                }
        );
        //JButton mit der Aufschrift: "|>"
        end.addActionListener(
                new ActionListener() {
                    /**
                     * Speichert die letze Adresse ab und gibt
                     * die mit Hilfe der Methode fuellen(Address i)
                     */
                    public void actionPerformed(ActionEvent e) {
                        vergleich();
                        address = addressbook.getLast();
                        fuellen(address);
                    }
                }

        );
        //JButton mit der Aufschrift: "delete"
        cancel.addActionListener(
                new ActionListener() {
                    /**
                     * Ruft die Methode sicherheit(int i) auf
                     */
                    public void actionPerformed(ActionEvent e) {
                        sicherheit(0);
                    }
                }

        );
        //JButton mit der Aufschrift: "delete all"
        deleteall.addActionListener(
                new ActionListener() {
                    /**
                     * Ruft die Methode sicherheit(int i) auf.
                     */
                    public void actionPerformed(ActionEvent e) {
                        sicherheit(1);
                    }
                }

        );
    }

    /**
     * Diese Methode kann von den JButtos:"<|", "<-"
     * aufgerufen werden. Sie gibt ein Fenster(JFrame) aus,
     * das darauf hinweist, dass man sich am Anfang des
     * Adressbuches befindet. Der aufscheindende Text lautet:
     * "Diese Position ist nicht erreichbar". Der Titel des JFrames
     * lautet: "Error". Das Fenster kann nur verlassen werden, indem
     * man auf den JButten "OK" klickt.
     */
    private void stackfail() {

        JButton exit = new JButton();
        final JFrame error = new JFrame();
        JLabel note = new JLabel();

        error.setBounds(275, 150, 300, 150);
        error.setTitle("Error!");
        error.setResizable(false);
        error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        note.setText("Diese Position ist nicht erreichbar");
        note.setBounds(30, 40, 250, 20);

        exit.setBounds(100, 80, 100, 40);
        exit.setText("OK");
        exit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        error.dispose();
                    }
                });
        error.setLayout(null);
        error.add(note);
        error.add(exit);
        error.setVisible(true);
    }

    /**
     * Kontrolliert ob der mitgegebene Parameter unleich null ist.
     * Anschließend ließt er jede Membervariable von Address und
     * schaut ob diese unleich null sind, wenn sie das sind
     * werden sie in ihr zugehöriges Textfeld geschrieben.
     * Diese Methode wird immer dann aufgrufen, wenn die JButtons
     * "<|", "<-","->", "|>", und "cancell" benutzt werden.
     *
     * @param address die zu lesenden Membervariablen
     */
    private void fuellen(Address address) {
        if (address != null) {
            if (address.getSurname() != null)
                nachnamefield.setText(address.getSurname());
            if (address.getName() != null)
                vornamefield.setText(address.getName());
            if (address.getStreet() != null)
                strassefield.setText(address.getStreet());
            if (address.getHousenr() != 0)
                hausnummerfield.setText(String.valueOf(address.getHousenr()));
            else
                hausnummerfield.setText("");
            if (address.getLocation() != null)
                ortfield.setText(address.getLocation());
            if (address.getZipcode() != 0)
                plzfield.setText(String.valueOf(address.getZipcode()));
            else
                plzfield.setText("");
            if (address.getEmail() != null)
                emailfield.setText(address.getEmail());
            if (address.getTelnr() != null)
                telnummerfield.setText(address.getTelnr());
            if (address.getMobilenr() != null)
                handynummerfield.setText(address.getMobilenr());
            if (address.getCountry() != null)
                landfield.setText(address.getCountry());
        }
    }

    /**
     * Gibt ein Fenster (JFrame) aus, bei dem ein
     * Text("Löschen") und zwei JButtons("delete" + "quit")
     * erscheinen. Dieses Fenster wird nur dann ausgegeben, wenn
     * man die JButtons: "delete all" oder "delete" betätigt
     * hat. Ist man durch "delete all" an dieses Fenster gelangt
     * und man drückt "delete" so wird der ganze Speicher geleert.
     * Ist man jedoh durch "delete" an dieses Fenster gelangt und
     * man drückt delete, so wird nur diese addressbook aus dem Speicher
     * entfernt die gerade angezeigt wir. Wird "quit" betätigt
     * so gelangt man auf das vorherige JFrame.
     *
     * @param I alle loeschen oder nur den Aktuellen
     */
    private void sicherheit(final int I) {
        JButton ok = new JButton();
        JButton cancel = new JButton();

        final JFrame error = new JFrame();
        JLabel note = new JLabel();

        error.setBounds(275, 150, 300, 150);
        error.setTitle("Error!");
        error.setResizable(false);
        error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        note.setText("Löschen?");
        note.setBounds(120, 40, 250, 20);

        cancel.setBounds(175, 80, 100, 30);
        cancel.setText("quit");

        ok.setBounds(25, 80, 100, 30);
        ok.setText("OK");

        ok.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (I == 1) {
                            addressbook.deleteAll();
                            neu();
                        } else {
                            addressbook.deleteCurrent();
                            address = addressbook.getCurrent();
                            if (address != null)
                                fuellen(address);
                        }
                        error.dispose();
                    }
                }
        );
        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        error.dispose();
                    }
                }
        );
        error.setLayout(null);
        error.add(note);
        error.add(ok);
        error.add(cancel);
        error.setVisible(true);

    }

    /**
     * Schreibt in jedes Textfeld: " ", hinein sodass
     * man ungehidert eine neue addressbook eingeben kann.
     * Die Methode von aufgrufen sobald der JButton
     * "add new" gedrückt wird oder wenn das Ende der
     * des Adressbuches erreicht wurde.
     */
    private void neu() {
    	fuellen(new Address());
    }
    /**
     * Kontrolliert ob die Adresse verändert wurde
     * oder nicht, falls sie verändert wurde wird sie
     * neu in den Speicher geschrieben.
     */
    private void vergleich() {
        Address cache = new Address();
        if (address != null) {
            if (nachnamefield.getText() != null)
                cache.setSurname(nachnamefield.getText());
            if (vornamefield.getText() != null)
                address.setName(vornamefield.getText());
            if (strassefield.getText() != null)
                cache.setName(vornamefield.getText());
            if (hausnummerfield.getText() != null)
                try {
                    cache.setHousenr(Integer.parseInt(hausnummerfield.getText()));
                } catch (NumberFormatException e) {
                }
            if (ortfield.getText() != null)
                cache.setLocation(ortfield.getText());
            if (plzfield.getText() != null)
                try {
                    cache.setZipcode(Integer.parseInt(plzfield.getText()));
                } catch (NumberFormatException e) {
                }
            if (emailfield.getText() != null)
                cache.setEmail(emailfield.getText());
            if (telnummerfield.getText() != null)
                cache.setTelnr(telnummerfield.getText());
            if (handynummerfield.getText() != null)
                cache.setMobilenr(handynummer.getText());
            if (landfield.getText() != null)
                cache.setCountry(landfield.getText());
            if (cache.compareTo(address) != 0) {
                addressbook.changeCurrent(cache);
            }
        }
    }
}
