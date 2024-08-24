import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to $0.");
            this.balance = 0;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your current balance is $" + balance);
            return false;
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
            return false;
        }
    }
}

// Class representing the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu and handle user input
    public void displayMenu() {
        int option = 0;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Validate user input to ensure it is an integer
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                processOption(option);
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear the invalid input
            }

        } while (option != 4);

        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    // Method to process the user's selected option
    private void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                // Exit the menu
                break;
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }

    // Method to check the balance of the account
    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    // Method to deposit money into the account
    private void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to withdraw money from the account
    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Please take your cash.");
        } else {
            System.out.println("Transaction failed.");
        }
    }

    // Main method to run the ATM program
    public static void main(String[] args) {
        // Initialize a bank account with a balance of $1000
        BankAccount account = new BankAccount(1000);

        // Create an ATM and connect it to the bank account
        ATM atm = new ATM(account);

        // Display the ATM menu to the user
        atm.displayMenu();
    }
}
