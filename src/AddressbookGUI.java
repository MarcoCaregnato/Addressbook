import java.awt.Container; import java.awt.Font;

import javax.swing.*;

@SuppressWarnings("serial")
public class AddressbookGUI extends JFrame {

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

    private JButton fore = null;
    private JButton back = null;
    private JButton neu = null;
    private JButton cancel = null;
    private JButton begin = null;
    private JButton end = null;

    public AddressbookGUI (){

        //Fenster Titel
        setTitle("Adressbuch");
        //Fenstergroesse
        setBounds(0,0,700,500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Nachname Schrift
        nachname = new JLabel ("Nachname:");
        nachname.setBounds(50, 50, 80, 20);

        //Nachname Textfeld
        nachnamefield = new JTextField();
        nachnamefield.setBounds(135, 50, 150, 20);

        //Vorname Schrift
        vorname = new JLabel("Vorname:");
        vorname.setBounds(400, 50, 80, 20);

        //Vorname Textfeld
        vornamefield = new JTextField();
        vornamefield.setBounds(475, 50, 150, 20);

        //Email Schrift
        email = new JLabel("Email:");
        email.setBounds(50, 100, 80, 20);

        //Email Textfeld
        emailfield = new JTextField();
        emailfield.setBounds(135, 100, 250, 20);

        //Handynummer Schrift
        handynummer = new JLabel("Handynummer:");
        handynummer.setBounds(50,140,120,20);

        //Handynummer Textfeld
        handynummerfield = new JTextField();
        handynummerfield.setBounds(165, 140, 100, 20);

        //Telefonnummer Schrift
        telnummer = new JLabel("Telefonnummer:");
        telnummer.setBounds(50, 170, 150, 20);

        //Telefonnummer Textfeld
        telnummerfield = new JTextField ();
        telnummerfield.setBounds(205, 170, 100, 20);

        //Hausnummer Schrift
        hausnummer = new JLabel("Hausnummer:");
        hausnummer.setBounds(50,200,120,20);

        //Hausnummer Textfeld
        hausnummerfield = new JTextField();
        hausnummerfield.setBounds(175, 200, 50, 20);

        //Strasse Schrift
        strasse = new JLabel("Strasse:");
        strasse.setBounds(50, 230, 70, 20);

        //Strasse Textfeld
        strassefield = new JTextField();
        strassefield.setBounds(125, 230, 150, 20);

        //Land Schrift
        land = new JLabel("Land:");
        land.setBounds(50,260,50,20);

        //Land Textfeld
        landfield = new JTextField();
        landfield.setBounds(105, 260, 70, 20);

        //Ort Schrift
        ort = new JLabel("Ort:");
        ort.setBounds(50, 290, 70, 20);

        //Ort Textfeld
        ortfield = new JTextField();
        ortfield.setBounds(125, 290, 90, 20);

        //Postleitzahl Schrift
        plz = new JLabel("Postleitzahl:");
        plz.setBounds(50,320,120,20);

        //Postleitzahl Textfield
        plzfield = new JTextField();
        plzfield.setBounds(175, 320, 80, 20);



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

        //Fenster sichbar machen
        setVisible(true);
    }
}