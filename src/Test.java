/**
 * Created by Andreas on 04.02.16.
 */
public class Test {

    public static void main(String[] args) {
        //new AddressbookGUI();
        Addressbook test = new Addressbook();
        test.readAddresses();
        test.deleteAll();
        Address neu = new Address();
        neu.setAddress("Resch;Andreas;Riedl;19;Steinegg;39053;Italien;andreas.resch@tfobz.net;3420447584;0471376702");
        test.addNew(neu);
        Address neu1 = new Address();
        neu1.setAddress("Caregnato;Marco;Romstraße;117;Burgstall;39014;Italien;marco.cargenato@tfobz.net;3453123405; ");
        test.addNew(neu1);
        Address neu2 = new Address();
        neu2.setAddress("Surname;Name;Street;1;Location;10000;Country;e@mail.it;1234567890;1234567890");
        test.addNew(neu2);
        Address neu3 = new Address();
        neu3.setAddress("Tschager;Agnes;Riedl;19;Steinegg;39053;Italien;tschager.agnes@outlook.de;3485642432;0471376702");
        test.addNew(neu3);
        Address neu4 = new Address();
        neu4.setAddress("Resch;Josef;Riedl;19;Steinegg;39053;Italien;resch.josef@rolmail.it;3483999395;0471376702");
        test.addNew(neu4);
        Address neu5 = new Address();
        neu5.setAddress("Resch;Julia;Riedl;19;Steinegg;39053;Italien;resch.julia@kaserer.it;6359663598;0471376702");
        test.addNew(neu5);

        test.getFirst();
        System.out.println(test.getCurrent().toString() + "\n");
        test.getNext();
        test.getNext();
        System.out.println(test.getCurrent().toString() + "\n");

        test.getLast();
        System.out.println(test.getCurrent().toString() + "\n");
        test.getPrevious();
        test.getPrevious();
        System.out.println(test.getCurrent().toString() + "\n");

        test.reSort();
        test.writeAddresses();
    }
}
