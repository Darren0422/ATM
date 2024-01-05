import java.util.ArrayList;
import java.util.UUID;

public class Bank {

    // Name of the bank
    private String name;

    // List of all the banks's users
    private ArrayList<User> users;

    // List of all the banks's accounts
    private ArrayList<Account> accounts;

    // Bank class object constructor  
    public Bank(String name) {
        this.name = name;

        this.users = new ArrayList<User>();

        this.accounts = new ArrayList<Account>();
    }

    /**
     * Returns the banks name
     * @return the banks name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the banks name
     * @return the banks name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a list of Users for the bank
     * @return a list of Users for the account
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets a list of Users for the bank
     * @return a list of Users for the account
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Returns a list of Accounts for the bank
     * @return a list of Accounts for the account
     */
    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    /**
     * Sets a list of Accounts for the bank
     * @return a list of Accounts for the account
     */
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    /**
     * Generate new universally unique ID for the user
     * @return a UUID for the user
     */
    public String getNewUserUUID() {
        String uuid;
        boolean nonUnique;
    
        // Continue looping until we get a UUID
        do {
            // Generate a random UUID
            uuid = UUID.randomUUID().toString();
    
            // Check if it's unique
            nonUnique = false;
            for (User u : this.users) {
                if (uuid.equals(u.getUUID())) {
                    nonUnique = true;
                    break;
                }
            }
    
        } while (nonUnique);
    
        return uuid;
    }

    /**
     * Generate new universally unique ID for the account
     * @return a UUID for the account
     */
    public String getNewAccountUUID() {
        String uuid;
        boolean nonUnique;
    
        // Continue looping until we get a UUID
        do {
            // Generate a random UUID
            uuid = UUID.randomUUID().toString();
    
            // Check if it's unique
            nonUnique = false;
            for (Account a : this.accounts) {
                if (uuid.equals(a.getUUID())) {
                    nonUnique = true;
                    break;
                }
            }
    
        } while (nonUnique);
    
        return uuid;
    }

    /**
     * Creates a new User object for the bank
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param pin the user's pin
     * @return new User object
     */
    public User AddUser(String firstName, String lastName, String pin) {
        // Create a new user object and add it to the list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // create a saving account for the user
        Account newSavingAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newSavingAccount);
        this.addAccount(newSavingAccount);

        // create a checking account for the user
        Account newCheckingAccount = new Account("Cheque", newUser, this);
        newUser.addAccount(newCheckingAccount);
        this.addAccount(newCheckingAccount);
        return newUser;
    }

    /**
     * Adds an account to the list of the bank's accounts
     * @param anAccount the account to add to the list
     */
    public void addAccount(Account anAccount) {
        this.accounts.add(anAccount);
    }

    /**
     * Checks the user credentials and performs a login.
     * @param userID User's UUID
     * @param pin user's pin
     * @return User object if successful or null if unsuccessful
     */
    public User userLogin(String userID, String pin) {
        
        for (User u : this.users) {
            if(u.getUUID().compareTo(userID) == 0 && u.verifyPin(pin)) {
                return u;
            }
        }

        return null;
    }
}
