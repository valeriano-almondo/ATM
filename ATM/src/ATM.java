import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        // init Scanner
        Scanner sc = new Scanner(System.in);

        // init Bank
        Bank theBank = new Bank("Raiffeisen Bank");

        // add a user, which also creates a savings account
        User aUser = theBank.addUser("Lucas", "Kucavik", "1234");

        // add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);
    }

}
