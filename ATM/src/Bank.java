import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> users;

    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty list of users and accounts
     * @param name the name of the bank
     */
    public Bank(String name) {

        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Add an account (for the Bank)
     * @param anAcct the account to add
     */
    public void addAccount(Account anAcct) {
        this.accounts.add(anAcct);
    }

    /**
     * Generate a new universally unique ID for a user
     * @return the uuid
     */
    public String getNewUserUUID() {

        // inits
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        // continue looping untile we get unique ID
        do {

            // generate the number
             uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += ((Integer)rng. nextInt(10)).toString();
            }

            // check to make sure it's unique
            nonUnique = false;
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0); {
                    nonUnique = true;
                    break;
                }
            }
            
        } while (nonUnique);

        return uuid;

    }

    /**
     * Generate a new universally unique ID for account
     * @return the uuid
     */
    public String getNewAccountUUID() {

        // inits
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        // continue looping untile we get unique ID
        do {

            //generate the number
            uuid = "";
            for (int i = 0; i < len; i++) {
                uuid += ((Integer)rng. nextInt(10)).toString();
            }

            // check to make sure it's unique
            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.compareTo(a.getUUID()) == 0); {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }

    /**
     * Create a new user of the bank
     * @param firsName the user's first name
     * @param lastName the user's last name
     * @param pin the user's pin
     * @return the new User object
     */
    public User addUser(String firsName, String lastName, String pin) {

        // create a new user object and add it to our list
        User newUser = new User(firsName, lastName, pin, this);
        this.users.add(newUser);

        // create a savings account for the user and add to User and Bank
        // accounts list
        Account newAccount = new Account("Savings", newUser, this);
        // add to hodler and bank lists
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;
    }

    /**
     * Get the user object associated with a particular userID and pin, if they are valid
     * @param userID the UUID for the user to log in
     * @param pin the pin o f the user
     * @return the User object, if the login is successful, or null if it's not
     */
    public User userLogin(String userID, String pin) {

        // search trought list of users
        for (User u : this.users) {

            //  check user ID is correct
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)) {
                 return u;
            }
        }

        // if we haven't found the user or have an incorrect pin
        return null;
    }


}
