import java.util.*;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(5000);

        while (true) {
            System.out.println("----------------------------------------------------------------------------------------------");
            System.out.println("Welcome to CoddSoftt ATM :");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            System.out.println("----------------------------------------------------------------------------------------------");

            switch (choice) {
                case 1:
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.println("Your balance is: " + account.getBalance()+"rs");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Transaction Successfull,Redirecting you to Main Menu..................");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Transaction Successfull,Redirecting you to Main Menu..................");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.println("Exit Successfull,Remember to take all your belongings with you!");
                    System.out.println("Thank you! for visitng CoddSoftt ATM.");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + "rs successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + "rs successful.");
            return true;
        } else {
            System.out.println("Insufficient balance.");
            return false;
        }
    }
}


