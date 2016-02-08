/**
 * Created by Andreas on 03.02.16.
 */
public class Address {

    private String surname;
    private String name;
    private String street;
    private int housenr;
    private String location;
    private int zipcode;
    private String country;
    private String email;
    private String mobilenr;
    private String telnr;

    /**
     * Gibt den Vornamen des Address-Objektes zurück
     *
     * @return name, Vorname des Objektes
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Vornamen des Objektes, sofern der übergebene
     * Parameter nicht null und nicht leer ist
     *
     * @param name, der gewünschte Vorname für das Objekt
     */
    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    /**
     * Gibt den Nachnamen des Address-Objektes zurück
     *
     * @return surname, Nachname des Objektes
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Setzt den Nachname des Objektes, sofern der übergebene
     * Parameter nicht null und nicht leer ist
     *
     * @param surname, der gewünschte Nachname für das Objekt
     */
    public void setSurname(String surname) {
        if (surname != null && !surname.isEmpty())
            this.surname = surname;
    }

    /**
     * Gibt den Wohnort des Address-Objektes zurück
     *
     * @return name, Wohnort des Objektes
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setzt den Wohnort des Objektes, sofern der übergebene
     * Parameter nicht null und nicht leer ist
     *
     * @param location, der gewünschte Wohnort für das Objekt
     */
    public void setLocation(String location) {
        if (location != null && !location.isEmpty())
            this.location = location;
    }

    /**
     * Gibt die Postleitzahl des Address-Objektes zurück
     *
     * @return zipcode, Postleitzahl des Objektes
     */
    public int getZipcode() {
        return zipcode;
    }

    /**
     * Setzt die Postleitzahl des Objektes, sofern der übergebene
     * Parameter fünf Stellen hat und größer als 0 ist
     *
     * @param zipcode, die gewünschte Postleitzahl für das Objekt
     */
    public void setZipcode(int zipcode) {
        if (String.valueOf(zipcode).length() == 5 && zipcode > 0)
            this.zipcode = zipcode;
    }

    /**
     * Gibt das Land des Address-Objektes zurück
     *
     * @return country, Land des Objektes
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setzt das Land des Objektes, sofern der übergebene
     * Parameter nicht null und nicht leer ist
     *
     * @param country, das gewünschte Land für das Objekt
     */
    public void setCountry(String country) {
        if (country != null && !country.isEmpty())
            this.country = country;
    }

    /**
     * Gibt die Straße des Address-Objektes zurück
     *
     * @return street, Straße des Objektes
     */
    public String getStreet() {
        return street;
    }

    /**
     * Setzt die Straße des Objektes, sofern der übergebene
     * Parameter nicht null und nicht leer ist
     *
     * @param street, die gewünschte Straße für das Objekt
     */
    public void setStreet(String street) {
        if (street != null && !street.isEmpty())
            this.street = street;
    }

    /**
     * Gibt die Hausnummer des Address-Objektes zurück
     *
     * @return housenr, Hausnummer des Objektes
     */
    public int getHousenr() {
        return housenr;
    }

    /**
     * Setzt die Hausnummer des Objektes, sofern der übergebene
     * Parameter größer als 0 ist.
     *
     * @param housenr, der gewünschte Vorname für das Objekt
     */
    public void setHousenr(int housenr) {
        if (housenr > 0)
            this.housenr = housenr;
    }

    /**
     * Gibt die Mobiltelefonnummer des Address-Objektes zurück
     *
     * @return mobilenr, Mobiltelefonnummer des Objektes
     */
    public String getMobilenr() {
        return mobilenr;
    }

    /**
     * Setzt die Mobiltelefonnummer des Objektes, sofern der übergebene
     * Parameter nicht null, nicht leer ist, zehn Stellen hat und nur
     * Ziffern enthält
     *
     * @param mobilenr, die gewünschte Mobiltelefonnummer für das Objekt
     */
    public void setMobilenr(String mobilenr) {
        if (mobilenr != null && !mobilenr.isEmpty()
                && mobilenr.length() == 10 && noLetters(mobilenr))
            this.mobilenr = mobilenr;
    }

    /**
     * Gibt die Telefonnummer des Address-Objektes zurück
     *
     * @return telnr, Telefonnummer des Objektes
     */
    public String getTelnr() {
        return telnr;
    }

    /**
     * Setzt die Telefonnummer des Objektes, sofern der übergebene
     * Parameter nicht null, nicht leer ist, zehn Stellen hat und
     * nur Ziffern beinhaltet
     *
     * @param telnr, der gewünschte Vorname für das Objekt
     */
    public void setTelnr(String telnr) {
        if (telnr != null && !telnr.isEmpty() &&
                telnr.length() == 10 && noLetters(telnr))
            this.telnr = telnr;
    }

    /**
     * Kontrolliert ob der übergebene String nur Zahlen enthält, sofern
     * dieser nicht null und nicht leer ist.
     *
     * @param s, der zu kontrolliernde String
     * @return ret, das Ergebnis der Kontrolle, true falls der String nur
     * Ziffern enthält und false wenn dies nicht der Fall ist
     */
    private boolean noLetters(String s) {
        boolean ret = true;
        if (s != null && !s.isEmpty()) {
            for (int i = 0; i < s.length() && ret; i++) {
                if (!Character.isDigit(s.charAt(i)))
                    ret = false;
            }
        } else {
            ret = false;
        }
        return ret;
    }

    /**
     * Gibt die E-mail-Adresse des Address-Objektes zurück
     *
     * @return email, E-mail-Adresse des Objektes
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setzt die Email-Adresse des Objektes, sofern der übergebene
     * Parameter nicht null,  nicht leer ist und ein '@' und mindestens einen
     * Punkt beinhaltet
     *
     * @param email, die gewünschte Email-Adresse für das Objekt
     */
    public void setEmail(String email) {
        if (email != null && !email.isEmpty() && checkEmail(email))
            this.email = email;
    }

    /**
     * Überprüft ob der übergebene Parameter als eine gültige E-mail-Adresse angesehen werden kann,
     * das heißt, dass der Paramater nicht null und nicht leer sein darf, nur ein '@' und mindestens
     * einen Punkt beinhaltet
     *
     * @param email
     * @return
     */
    private boolean checkEmail(String email) {
        boolean ret = false;
        if (email != null && !email.isEmpty()) {
            int fullstop = 0;
            int at_sign = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    at_sign++;
                }
                if (email.charAt(i) == '.') {
                    fullstop++;
                }
            }
            if (fullstop >= 1 && at_sign == 1) {
                ret = true;
            }
            return ret;
        }
        return ret;
    }

    /**
     * Setzt alle Eigenschaften eines Address-Objektes indem es das übergebene Objekt
     * als String an die gleichnamige
     * Methode setAddress(String s) übergibt,
     *
     * @param address, Objekt mit den gewünschten Eigenschaften
     */
    public void setAddress(Address a) {
        this.setAddress(a.toString());
    }

    /**
     * Gibt die Eigenschaften des Objektes in ihrer Stringentsprechung züruck, wobei jede
     * Eigenschaft durch ein Semikolon getrennt wird
     *
     * @return String, der alle Eigenschaften des Objektes enthält
     */
    public String toString() {
        return getSurname() + ";" + getName() + ";" + getStreet() + ";" + getHousenr() + ";" +
                getLocation() + ";" + getZipcode() + ";" + getCountry() + ";" + getEmail() + ";" +
                getMobilenr() + ";" + getTelnr();
    }

    /**
     * Setzt alle Eigenschaften eines Address-Objektes, sofern der Parameter
     * nicht null und nicht leer ist indem es den übergebenen String
     * an den Semikolons aufteilt
     *
     * @param s, die gewünschten Eigenschaften für das Objekt in einem String zusammengefasst
     */
    public void setAddress(String s) {
        String[] array = s.split(";");
        try {
            this.setSurname(array[0]);
            this.setName(array[1]);
            this.setStreet(array[2]);
            this.setHousenr(Integer.parseInt(array[3]));
            this.setLocation(array[4]);
            this.setZipcode(Integer.parseInt(array[5]));
            this.setCountry(array[6]);
            this.setEmail(array[7]);
            this.setMobilenr(array[8]);
            this.setTelnr(array[9]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    /**
     * Kopiert alle Eigenschaften des Objektes auf ein neues Objekt
     * und gibt dieses zurück
     *
     * @return ret, Objekt mit den gleichen Eigenschaften wie das zu klonende Objekt
     */
    public Address clone() {
        Address ret = new Address();
        ret.setAddress(this);
        return ret;
    }

    /**
     * Vergleicht zwei Address-Objekte und gibt einen
     * postiven Wert zurück, falls a größer ist. 0 wird zurückgegeben
     * wenn die Objekte identisch sind und ein negativer Wert wird
     * zurückgegeben wenn a kleiner ist
     *
     * @param a, das zu vergleichende Objekt
     * @return ret, Ergebnis des Vergleichs
     */
    public int compareTo(Address a) {
        int ret = 0;
        if (this.getSurname() != null && a.getSurname() != null)
            ret = this.getSurname().compareTo(a.getSurname());
        if (ret == 0 && this.getName() != null && a.getName() != null)
            ret = this.getName().compareTo(a.getName());
        if (ret == 0 && this.getStreet() != null && a.getStreet() != null)
            ret = this.getStreet().compareTo(a.getStreet());
        if (ret == 0 && this.getHousenr() != 0 && a.getHousenr() != 0)
            ret = this.getHousenr() - a.getHousenr();
        if (ret == 0 && this.getLocation() != null && a.getLocation() != null)
            ret = this.getLocation().compareTo(a.getLocation());
        if (ret == 0 && this.getZipcode() != 0 && a.getZipcode() != 0)
            ret = this.getZipcode() - a.getZipcode();
        if (ret == 0 && this.getCountry() != null && a.getCountry() != null)
            ret = this.country.compareTo(a.getCountry());
        if (ret == 0 && this.getEmail() != null && a.getEmail() != null)
            ret = this.getEmail().compareTo(a.getEmail());
        if (ret == 0 && this.getMobilenr() != null && a.getMobilenr() != null)
            ret = this.getMobilenr().compareTo(a.getMobilenr());
        if (ret == 0 && this.getTelnr() != null && a.getTelnr() != null)
            ret = this.getTelnr().compareTo(a.getTelnr());
        return ret;
    }

    public void reSet(String s) {
        String[] array = s.split(";");
        if (!surname.equals(array[0])) {
            this.setSurname(array[0]);
        }
        if (!name.equals(array[1])) {
            this.setName(array[1]);
        }
        if (!street.equals(array[2])) {
            this.setStreet(array[2]);
        }
        if (housenr != Integer.parseInt(array[3])) {
            this.setHousenr(Integer.parseInt(array[3]));
        }
        if (!location.equals(array[4])) {
            this.setLocation(array[4]);
        }
        if (zipcode != Integer.parseInt(array[5])) {
            this.setSurname(array[5]);
        }
        if (!country.equals(array[6])) {
            this.setCountry(array[6]);
        }
        if (!email.equals(array[7])) {
            this.setEmail(array[7]);
        }
        if (!mobilenr.equals(array[8])) {
            this.setMobilenr(array[8]);
        }
        if (!telnr.equals(array[9])) {
            this.setTelnr(array[9]);
        }
    }
}