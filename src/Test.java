/**
 * Created by Andreas on 04.02.16.
 */
public class Test {

    public static void main(String[] args) {
        Adressbuch test = new Adressbuch(10);
        test.readAdresses();
        test.deleteAll();
        Address neu = new Address();
        neu.setAdresse("Resch;Andreas;Riedl;19;Steinegg;39053;Italien;andreas.resch@tfobz.net;3420447584;0471376702");
        test.addNew(neu);
        neu.setAdresse("Caregnato;Marco;Romstraße;117;Burgstall;39014;Italien;marco.cargenato@tfobz.net;3453123405;");
        test.addNew(neu);
        test.getPrevious();
        test.deleteCurrent();
        //System.out.println(test.getFirst().toString());
        test.writeAdresses();
    }
}
