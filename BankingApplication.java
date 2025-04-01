package mini_project;

import java.util.*;

class BankAccount { private double balance; // Stores the account balance

// Constructor to initialize the account with an initial balance
public BankAccount(double initialBalance) {
    this.balance = initialBalance;
}

// Method to get the current account balance
public double getBalance() {
    return balance;
}

// Method to deposit money into the account
public void deposit(double amount) {
    if (amount > 0) { // Ensure the deposit amount is valid
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    } else {
        System.out.println("Invalid deposit amount. Please enter a positive value.");
    }
}

// Method to withdraw money from the account
public void withdraw(double amount) {
    if (amount > 0 && amount <= balance) { // Ensure the withdrawal amount is valid and sufficient funds are available
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    } else if (amount > balance) {
        System.out.println("Insufficient funds. Your current balance is: " + balance);
    } else {
        System.out.println("Invalid withdrawal amount. Please enter a positive value.");
    }
}

// Method to transfer money to another account
public void transfer(BankAccount recipient, double amount) {
    if (amount > 0 && amount <= balance) {
        this.withdraw(amount);
        recipient.deposit(amount);
        System.out.println("Transfer successful. New balance: " + balance);
    } else {
        System.out.println("Invalid transfer amount or insufficient funds.");
    }
}

}

 class Banking { public static void main(String[] args)
 {
	 Scanner scanner = new Scanner(System.in); // Scanner object for user input
     BankAccount account = new BankAccount(1000); // Create a bank account with an initial balance of 1000
     BankAccount savingsAccount = new BankAccount(500); // Another account for transfer demonstration

// Infinite loop to continuously show the menu until the user chooses to exit
    while (true) {
        // Display the banking options
        System.out.println("\nSimple Banking Application");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer Funds");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 5.");
            scanner.next(); // Clear invalid input
            continue;
        }
        
        int choice = scanner.nextInt(); // Read user choice
        
        // Perform operations based on the user's choice
        switch (choice) {
            case 1:
                // Display the current balance
                System.out.println("Current Balance: " + account.getBalance());
                break;
            case 2:
                // Prompt user to enter deposit amount
                System.out.print("Enter amount to deposit: ");
                if (scanner.hasNextDouble()) {
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount); // Call deposit method
                } else {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    scanner.next(); // Clear invalid input
                }
                break;
            case 3:
                // Prompt user to enter withdrawal amount
                System.out.print("Enter amount to withdraw: ");
                if (scanner.hasNextDouble()) {
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount); // Call withdraw method
                } else {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    scanner.next(); // Clear invalid input
                }
                break;
            case 4:
                // Prompt user to enter transfer amount
                System.out.print("Enter amount to transfer to savings account: ");
                if (scanner.hasNextDouble()) {
                    double transferAmount = scanner.nextDouble();
                    account.transfer(savingsAccount, transferAmount); // Transfer funds
                } else {
                    System.out.println("Invalid input. Please enter a valid amount.");
                    scanner.next(); // Clear invalid input
                }
                break;
            case 5:
                // Exit the application
                System.out.println("Thank you for using the banking application.");
                scanner.close(); // Close scanner before exiting
                return;
            default:
                // Handle invalid user input
                System.out.println("Invalid option. Please try again.");
        }
    }
}

}