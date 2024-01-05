import java.util.ArrayList;

public class Account {
    // Name of the account
    private String name;

    // UUID of the account
    private String uuid;

    // User object that owns this account
    private User accHolder;

    // List of all the accounts's accounts
    private ArrayList<Transaction> transactions;

    // Account class object constructor  
    public Account (String name, User accHolder, Bank bank) {
        this.name = name;

        this.accHolder = accHolder;
        
        this.uuid = bank.getNewAccountUUID();

        this.transactions = new ArrayList<Transaction>();

    }

    /**
     * Returns the name of the account
     * @return account's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the account
     * @return account's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the UUID of the account
     * @return account's UUID
     */
    public String getUUID() {
        return uuid;
    }

     /**
     * Sets the UUID of the account
     * @return account's UUID
     */
    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Returns the user object that owns the account
     * @return account holder's name
     */
    public User getAccHolder() {
        return accHolder;
    }

     /**
     * Sets the user object that owns the account
     * @return account holder's name
     */
    public void setAccHolder(User accHolder) {
        this.accHolder = accHolder;
    }

    /**
     * Returns a list of transactions for the account
     * @return a list of transactions for the account
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets the list of transactions for the account
     * @return a list of transactions for the account
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Gets the current balance of the account.
     * The balance is calculated by summing up the amounts of all transactions.
     * @return The current balance of the account.
     */
    public double getBalance() {
        double balance = 0;
        for (Transaction t : this.transactions) {
            balance += t.getAmount();
        }
        return balance;
    }

     /*
     * Prints the transaction history the account
     */
    public void printAcctTransHistory() {
        System.out.printf("\nTransacation history for account %s\n", this.uuid);
        for (int t = this.transactions.size()-1; t >= 0; t--) {
            System.out.println(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }
    
     /**
     * Adds a new transaction to the account's transaction list.
     * @param amount The amount of the transaction. Positive for deposits, negative for withdrawals.
     * @param reference Additional information or a reference associated with the transaction.
     */
    public void addAcctTransaction (double amount, String reference) {
        Transaction newTransaction = new Transaction(amount, reference, this);
        this.transactions.add(newTransaction);
    }
}
