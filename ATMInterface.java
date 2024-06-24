import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void deposit(double amount) {
        if (account.deposit(amount)) {
            System.out.printf("Successfully deposited %.2f. New balance: %.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Invalid deposit amount. Please try again.");
        }
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.printf("Successfully withdrew %.2f. New balance: %.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.printf("Current balance: %.2f%n", account.getBalance());
    }

    public void userInterface() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- ATM Interface ---");
                System.out.println("1. Withdraw");
                System.out.println("2. Deposit");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("123456789", 1000.0);
        ATM atm = new ATM(account);
        atm.userInterface();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    protected void finalize() throws Throwable {
        // TODO Auto-generated method stub
        super.finalize();
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
