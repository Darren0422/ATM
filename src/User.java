import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    // First name of the user
    private String firstName;

    // Last name of the user
    private String lastName;

    // UUID of the user
    private String uuid;

    // SHA-256 hash of the user's pin
    private byte[] pinHash;

    // List of all the user's accounts
    private ArrayList<Account> accounts;


    // User class object constructor  
    public User(String firstName, String lastName, String pin, Bank bank) {
        this.firstName = firstName;

        this.lastName = lastName;

        this.pinHash = hashPin(pin);

        this.uuid = bank.getNewUserUUID();

        this.accounts = new ArrayList<Account>();

        System.out.printf("User %s created. Pin = %s\n", this.uuid, pin);
    }


    /**
     * Returns the user's first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the user's last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the user's pin hash
     * @return the pin hash
     */
    public byte[] getPinHash() {
        return pinHash;
    }

    /**
     * Sets the user's pin hash
     * @param pinHash the pin hash
     */
    public void setPinHash(byte[] pinHash) {
        this.pinHash = pinHash;
    }

    /**
     * Creates a hash pin from the given pin
     * @param pin the user's given pin
     * @return the users pin in hash format
     */
    private byte[] hashPin(String pin) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Checks the given pin matches the users pin
     * @param pin the user's given pin
     * @return if the pin is valid or not
     */
    public boolean verifyPin(String pin) {
        // Hash the given pin to compare with the hashed pin of the User
        byte[] enteredPinHash = hashPin(pin);
        return MessageDigest.isEqual(enteredPinHash, pinHash);
    }

    /**
     * Returns a list of accounts for the user
     * @return a list of user accounts
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets a list of accounts for the user
     * @return a list of user accounts
     */
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Adds to the list of the users accounts
     * @param anAccount is added to the users list of accounts
     */
    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    /**
     * Returns the number of accounts in the list of accounts
     * @return the number of accounts in the list 
     */
    public int numOfAccounts() {
        return this.accounts.size();
    }

    /**
     * Returns the UUID of the user
     * @return the UUID of the user
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Sets the UUID of the user
     * @return the UUID of the user
     */
    public void setUUID(String uuid) {
        this.uuid = uuid;
    }

    /*
     * Prints a summary of the users accounts
     */
    public void userAccountSummary() {
        System.out.printf("\n%s's account summary\n",this.firstName);

        for (int i = 0; i < this.accounts.size(); i++) {
            Account acc = this.accounts.get(i);
            System.out.printf("%d) %s : R%.2f : %s\n", i + 1, acc.getUUID(), acc.getBalance(), acc.getName());
        }
    }
    
    /**
     * Prints the transaction hisotry for a particular account 
     * @param accountIndex index of the account to print
     */
    public void printTransHistory (int accountIndex) {
        this.accounts.get(accountIndex).printAcctTransHistory();
    }

    /**
     * Returns the balance of the specific account
     * @param accountIndex the index of the account to use
     * @return the balance of the account
     */
    public double getAccountBalance(int accountIndex){
        return this.accounts.get(accountIndex).getBalance();
    }

    /**
     * Adds a transaction to a specific account 
     * @param accountIndex index of the account 
     * @param amount amount of the transaction
     * @param Reference reference of the transaction 
     */
    public void addAcctTransaction(int accountIndex, double amount, String Reference) {
        this.accounts.get(accountIndex).addAcctTransaction(amount, Reference);
    }

    /**
     * Returns the UUID of a specific account
     * @param accountIndex index of the account 
     * @return the UUID of the account
     */
    public String getAccountUUID(int accountIndex) {
        return this.accounts.get(accountIndex).getUUID();
    }

}
