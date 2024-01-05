import java.util.Scanner;

public class ATM {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // Create a bank
        Bank bank = new Bank("ABSA");

        // Add a user to the bank
        User user = bank.AddUser("John", "Doe", "1234");

        User currentUser;

        while (true) {
            currentUser = ATM.menuLogin(bank, scanner);

            ATM.menuUser(currentUser, scanner);
        }

    }

    public static User menuLogin(Bank bank, Scanner scanner) {

        String userID;
        String pin;
        User authorisedUser;

        do {

            System.out.println("Welcome to " + bank.getName());

            System.out.println("Please enter your user ID:");
            userID = scanner.nextLine();

            System.out.println("Please enter your user pin:");
            pin = scanner.nextLine();

            authorisedUser = bank.userLogin(userID, pin);
            if (authorisedUser == null) {
                System.out.println("Incorrect user ID/pin combination. Please try again.");
            }

        } while (authorisedUser == null);

        return authorisedUser;

    }

    public static User menuUser(User user, Scanner scanner) {
        user.userAccountSummary();

        int choice;

        do {
            System.out.printf("Welcome %s, please select an option:", user.getFirstName());

            System.out.println("\n1.  Show account transaction history");
            System.out.println("\n2.  Withdrawl");
            System.out.println("\n3.  Deposit");
            System.out.println("\n4.  Transfer");
            System.out.println("\n5.  Quit");
            System.out.println();
            System.out.print("Enter choice:");
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please choose 1-5.");
            }

        } while (choice < 1 || choice > 5);

        switch (choice) {
            case 1:
            user.userAccountSummary();
                ATM.showTransHistory(user, scanner);
                System.out.print("Trans history");
                break;
            case 2:
            user.userAccountSummary();
                ATM.withdrawlFunds(user, scanner);
                System.out.print("withdrawl");
                break;
            case 3:
            user.userAccountSummary();
                ATM.depositFunds(user, scanner);
                System.out.print("deposit");
                break;
            case 4:
                user.userAccountSummary();
                ATM.transferFunds(user, scanner);
                System.out.print("transfer ");
                break;
            case 5:
                scanner.nextLine();
                break;
        }

        // redisplay the menu unless the user wants to quit.
        if (choice != 5) {
            ATM.menuUser(user, scanner);
        }

        return user;

    }

    public static void showTransHistory(User user, Scanner scanner) {

        int accountChoice;

        do {
            System.out.printf("Enter the number (1-%s) of the account: ", user.numOfAccounts());

            accountChoice = scanner.nextInt() - 1;
            if (accountChoice < 0 || accountChoice > user.numOfAccounts()) {
                System.out.println("Invalid account, please try again!");
            }
        } while (accountChoice < 0 || accountChoice > user.numOfAccounts());

        user.printTransHistory(accountChoice);
    }

    public static void transferFunds(User user, Scanner scanner) {
        int fromAccount;
        int toAccount;
        double amount;
        double accountBalance;

        // Account to transfer from
        do {
            System.out.printf("Enter the number (1-%s) of the account to transfer from: ", user.numOfAccounts());

            fromAccount = scanner.nextInt() - 1;

            if (fromAccount < 0 || fromAccount >= user.numOfAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAccount < 0 || fromAccount >= user.numOfAccounts());

        accountBalance = user.getAccountBalance(fromAccount);

        // Account to transfer to
        do {
            System.out.printf("Enter the number (1-%s) of the account to transfer to: ", user.numOfAccounts());
            toAccount = scanner.nextInt() - 1;

            if (toAccount < 0 || toAccount >= user.numOfAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAccount < 0 || toAccount >= user.numOfAccounts());

        // Amount to transfer
        do {
            System.out.printf("Enter the amount to transfer (max R%.2f) : R", accountBalance);
            amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > accountBalance) {
                System.out.printf("Amount must not be greater than account balance of R%.02f\n", accountBalance);
            }

        } while (amount < 0 || amount > accountBalance);

        // Transfer the amounts
        // Do the transfer
        // Two transactions recorded, one to minus funds and one to add funds
        user.addAcctTransaction(fromAccount, -1 * amount,
                String.format("Transfer to account %s", user.getAccountUUID(toAccount)));
        user.addAcctTransaction(toAccount, amount,
                String.format("Transfer to account %s", user.getAccountUUID(toAccount)));

    }

    public static void withdrawlFunds(User user, Scanner scanner) {
        int fromAccount;
        double amount;
        double accountBalance;
        String reference;

        // Account to withdraw from
        do {
            System.out.printf("Enter the number (1-%s) of the account to withdraw from: ", user.numOfAccounts());

            fromAccount = scanner.nextInt() - 1;

            if (fromAccount < 0 || fromAccount >= user.numOfAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (fromAccount < 0 || fromAccount >= user.numOfAccounts());

        accountBalance = user.getAccountBalance(fromAccount);

        // Amount to withdraw
        do {
            System.out.printf("Enter the amount to withdraw (max R%.2f) : R", accountBalance);
            amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            } else if (amount > accountBalance) {
                System.out.printf("Amount must not be greater than account balance of R%.02f\n", accountBalance);
            }

        } while (amount < 0 || amount > accountBalance);

        scanner.nextLine();

        System.out.println("Enter a reference: ");
        reference = scanner.nextLine();

        user.addAcctTransaction(fromAccount, -1 * amount, reference);

    }

    public static void depositFunds(User user, Scanner scanner) {

        int toAccount;
        double amount;
        String reference;

        // Account to deposit to
        do {
            System.out.printf("Enter the number (1-%s) of the account to deposit to: ", user.numOfAccounts());

            toAccount = scanner.nextInt() - 1;

            if (toAccount < 0 || toAccount >= user.numOfAccounts()) {
                System.out.println("Invalid account. Please try again.");
            }
        } while (toAccount < 0 || toAccount >= user.numOfAccounts());

        // Amount to deposit
        do {
            System.out.println("Enter the amount to deposit : R ");
            amount = scanner.nextDouble();

            if (amount < 0) {
                System.out.println("Amount must be greater than zero");
            } 

        } while (amount < 0);

        scanner.nextLine();

        System.out.println("Enter a reference: ");
        reference = scanner.nextLine();

        user.addAcctTransaction(toAccount, amount, reference);
    }
}
