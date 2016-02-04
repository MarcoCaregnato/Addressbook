/**
 * Created by Andreas on 03.02.16.
 */
public class Address {

    private String name;
    private String surname;
    private String location;
    private String zipcode;
    private String country;
    private String street;
    private int housenr;
    private String mobilenr;
    private String telnr;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHousenr() {
        return housenr;
    }

    public void setHousenr(int housenr) {
        this.housenr = housenr;
    }

    public String getMobilenr() {
        return mobilenr;
    }

    public void setMobilenr(String mobilenr) {
        this.mobilenr = mobilenr;
    }

    public String getTelnr() {
        return telnr;
    }

    public void setTelnr(String telnr) {
        this.telnr = telnr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(Address address) {
        this.name = address.name;
        this.surname = address.surname;
        this.location = address.location;
        this.zipcode = address.zipcode;
        this.country = address.country;
        this.street = address.street;
        this.housenr = address.housenr;
        this.mobilenr = address.mobilenr;
        this.telnr = address.telnr;
        this.email = address.email;
    }

    public String toString() {
        return getSurname() + ";" + getName() + ";" + getStreet() + ";" + getHousenr() + ";" +
                 getLocation() + ";" + getZipcode() + ";" + getCountry() + ";" + getEmail() + ";" +
                    getMobilenr() + ";" + getTelnr() + "\n";
    }

    public void setAdresse(String s) {
        String[] array = s.split(";");
        try {
            setSurname(array[0]);
            setName(array[1]);
            setStreet(array[2]);
            setHousenr(Integer.parseInt(array[3]));
            setLocation(array[4]);
            setZipcode(array[5]);
            setCountry(array[6]);
            setEmail(array[7]);
            setMobilenr(array[8]);
            setTelnr(array[9]);
        }
        catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
