//I am writing java Program with by using OOPs concepts .
//i am using Class,Objects,Encapsulation,inheritance,polymorphism and abstraction

// Project Title: Online Banking System .

import java.util.Scanner;

// Base abstract class for all account types
abstract class Account {
    private String accHolderName;
    private String accNumber;
    protected double balance;

    public Account(String name, String accNo, double balance) {
        this.accHolderName = name;
        this.accNumber = accNo;
        this.balance = balance;
    }

    public abstract void showAccountType();

    public void displayBalance() {
        System.out.println("Balance: Rs." + balance);
    }

    public String getName() {
        return accHolderName;
    }

    public String getAccountNumber() {
        return accNumber;
    }
}

// Savings Account
class SavingsAccount extends Account {
    public SavingsAccount(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }

    public void showAccountType() {
        System.out.println("Savings Account");
    }
}

// Current Account
class CurrentAccount extends Account {
    public CurrentAccount(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }

    public void showAccountType() {
        System.out.println("Current Account");
    }
}

// Transaction interface
interface Transaction {
    void perform(Account acc, double amount);
}

// Deposit transaction
class Deposit implements Transaction {
    public void perform(Account acc, double amount) {
        acc.balance += amount;
        System.out.println("Deposited Rs." + amount);
    }
}

// Withdraw transaction
class Withdraw implements Transaction {
    public void perform(Account acc, double amount) {
        if (amount <= acc.balance) {
            acc.balance -= amount;
            System.out.println("Withdrawn Rs." + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

// Main interaction class
public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account acc = new SavingsAccount("Chandra", "ACC123", 5000);
        acc.showAccountType();
        acc.displayBalance();

        System.out.print("Enter amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        Transaction deposit = new Deposit();
        deposit.perform(acc, depositAmount);
        acc.displayBalance();

        System.out.print("Enter amount to withdraw: ");
        double withdrawAmount = scanner.nextDouble();
        Transaction withdraw = new Withdraw();
        withdraw.perform(acc, withdrawAmount);
        acc.displayBalance();

        scanner.close();
    }
}
