import java.util.Scanner;

interface bankOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// Step 2: Create a BankAccount class implementing the BankOperations interface
class bankAccount implements bankOperations {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public bankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double checkBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

public class BankAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to store bank accounts
        bankAccount[] accounts = new bankAccount[10];
        int accountCount = 0;

        while (true) {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Add a new bank account");
            System.out.println("2. Deposit money into a bank account");
            System.out.println("3. Withdraw money from a bank account");
            System.out.println("4. Check the balance of a bank account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (accountCount < accounts.length) {
                        System.out.print("Enter account number: ");
                        int accountNumber = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        System.out.print("Enter account holder name: ");
                        String accountHolderName = scanner.nextLine();

                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();

                        bankAccount newAccount = new bankAccount(accountNumber, accountHolderName, initialBalance);
                        accounts[accountCount] = newAccount;
                        accountCount++;
                        System.out.println("New account added successfully!");
                    } else {
                        System.out.println("Cannot add more accounts. Array is full.");
                    }
                    break;

                case 2:
                    System.out.print("Enter account number to deposit money: ");
                    int depositAccountNumber = scanner.nextInt();
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();

                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i].getAccountNumber() == depositAccountNumber) {
                            accounts[i].deposit(depositAmount);
                            System.out.println("Amount deposited successfully!");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter account number to withdraw money: ");
                    int withdrawAccountNumber = scanner.nextInt();
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i].getAccountNumber() == withdrawAccountNumber) {
                            accounts[i].withdraw(withdrawAmount);
                            System.out.println("Amount withdrawn successfully!");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter account number to check balance: ");
                    int checkAccountNumber = scanner.nextInt();

                    for (int i = 0; i < accountCount; i++) {
                        if (accounts[i].getAccountNumber() == checkAccountNumber) {
                            System.out.println("Account Holder Name: " + accounts[i].getAccountHolderName());
                            System.out.println("Current Balance: " + accounts[i].checkBalance());
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}