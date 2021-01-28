import java.util.ArrayList;

public class Account {
    /**
     * The name of the account.
     */
    private String name;
    /**
     * The account ID number.
     */
    private String uuid;
    /**
     * The user object that owns this account.
     */
    private User holder;
    /**
     * The list of transactions for this account.
     */
    private ArrayList<Transaction> transactions;

    /**
     *
     * @param name The account ID number.
     * @param holder The list of transactions for this account.
     * @param theBank The Bank user using
     */
    public Account(String name, User holder, Bank theBank) {

        // set the account name and holder
        name = this.name;
        holder = this.holder;

        // get new account UUID

        this.uuid = theBank.getNewAccountUUID();

        //init transactions
        this.transactions = new ArrayList<Transaction>();

    }

    /**
     * Return the account UUID
     * @return the uuid
     */
    public String getUUID() {
        return this.uuid;
    }

}
