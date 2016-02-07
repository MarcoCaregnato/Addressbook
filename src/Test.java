/**
 * Created by Andreas on 04.02.16.
 */
public class Test {

    public static void main(String[] args) {
        //new AddressbookGUI();
        Addressbook test = new Addressbook();
        test.readAddresses();
        Address neu = new Address();
        neu.setAddress("Resch;Andreas;Riedl;19;Steinegg;39053;Italien;andreas.resch@tfobz.net;3420447584;0471376702");
        test.addNew(neu);
        neu.setAddress("Caregnato;Marco;Romstraße;117;Burgstall;39014;Italien;marco.cargenato@tfobz.net;3453123405; ");
        test.changeCurrent(neu);
        //neu.setAddress("Surname;Name;Street;1;Location;10000;Country;e@mail.it;1234567890;1234567890");
        //test.addNew(neu);
        test.reSort();
        test.writeAddresses();
    }
}
