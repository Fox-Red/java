public class TestMain {
    public static void main(String[] args) {
        BankSingIn bsi = new BankSingIn();

        bsi.readUser("F:\\User.txt");
        bsi.writeUesr("F:\\User.txt",bsi.ceartUser("继文", "123", 0));
    }
}
