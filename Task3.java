
package task3;
import java.util.Scanner;
class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void displayBalance() {
        System.out.println("Your current balance is: " + account.checkBalance());
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: " + account.checkBalance());
        } else {
            System.out.println("Withdrawal failed. Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: " + account.checkBalance());
    }
}
public class Task3 {

    
    public static void main(String[] args) {
        




        Account account = new Account(500);
        ATM atm = new ATM(account);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the ATM. Please choose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw cash");
            System.out.println("3. Deposit cash");
            System.out.println("4. Quit");

            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                atm.displayBalance();
            } else if (choice.equals("2")) {
                double amount = Double.parseDouble(scanner.nextLine());
                atm.withdraw(amount);
            } else if (choice.equals("3")) {
                double amount = Double.parseDouble(scanner.nextLine());
                atm.deposit(amount);
            } else if (choice.equals("4")) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
    
