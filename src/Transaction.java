import java.util.Date;

public class Transaction {

    // Amount of the transaction
    private double amount;

    // Date of the transaction
    private Date timestamp;

    // Reference of the transaction
    private String Reference;

    // Account in which the transaction was made
    private Account transactionAccount;

    // Transaction class object constructor  
    public Transaction(double amount, String Reference, Account transactionAccount) {
        
        this.amount = amount;

        this.timestamp = new Date();

        this.Reference = Reference;

        this.transactionAccount = transactionAccount;
    }

    /**
     * Returns the transaction amount
     * @return the transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the transaction amount
     * @return the transaction amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns the date of the transaction
     * @return the date of transaction
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the date of the transaction
     * @return the date of transaction
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns the reference of the transaction
     * @return the reference of transaction
     */
    public String getReference() {
        return Reference;
    }

    /**
     * Sets the reference of the transaction
     * @return the reference of transaction
     */
    public void setReference(String reference) {
        Reference = reference;
    }

    /**
     * Returns the account in which the transaction was made
     * @return account in which the transaction was made
     */
    public Account getTransactionAccount() {
        return transactionAccount;
    }

    /**
     * Sets the account in which the transaction was made
     * @return account in which the transaction was made
     */
    public void setTransactionAccount(Account transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    /**
     * Returns a string summary of the transaction
     * @return a string summary of the transaction
     */
    public String getSummaryLine() {
        if (amount >= 0) {
            return String.format("%s : R%.02f : %s", this.timestamp.toString(), this.amount, this.Reference);
        } else {
            return String.format("%s : R(%.02f) : %s", this.timestamp.toString(), -this.amount, this.Reference);
        }
    }
    

}
