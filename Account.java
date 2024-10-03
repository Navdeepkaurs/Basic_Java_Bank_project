import java.util.*;

public class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    // constructor
    Account(String name, String id) {
        customerName = name;
        customerId = id;
    }

    // Function for money deposite
    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    // Function for money withdrawing
    public void withdraw(int amount) {
        if (amount != 0 && balance >= amount) {
            balance -= amount;
            previousTransaction = amount;
        }
    }

    // Function showing previous transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction has been made yet.");
        }
    }

    // Calculating intrest of current funds after n years
    public void calculateInterest(int years) {
        double interestRate = 0.0185;
        double interest = balance * interestRate * years;
        System.out.println("Current Interest Rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + (balance + interest));
    }

    // show page
    public void showMenu() {
        char option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName + " !");
        System.out.println("Your Bank Id is : " + customerId);
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("What would u like to do ?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Deposit money");
        System.out.println("C. Withdraw money");
        System.out.println("D. Get previous transaction");
        System.out.println("E. Calculate intrest");
        System.out.println("F Exit");

        do {
            System.out.println();
            System.out.println("Enter your choice : ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("------------------------------------");
                    System.out.println("Your current balance is : " + balance);
                    System.out.println("------------------------------------");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("------------------------------------");
                    System.out.println("Enter the amount you want to deposit : ");
                    int deposit = sc.nextInt();
                    deposit(deposit);
                    System.out.println("Deposit successful!");
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("------------------------------------");
                    System.out.println("Enter the amount you want to withdraw: ");
                    int withdraw = sc.nextInt();
                    withdraw(withdraw);
                    System.out.println("Withdrawal successful!");
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("------------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------------");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("------------------------------------");
                    System.out.println("Enter the number of years: ");
                    int years = sc.nextInt();
                    calculateInterest(years);
                    System.out.println("------------------------------------");
                    System.out.println();
                    break;
                case 'F':
                    System.out.println("------------------------------------");
                    break;
                default:
                    System.out.println("Invalid option! Please enter A, B, C, D, E, or F.");

            }
        } while (option != 'F');
        System.out.println("Thanking for Banking with us " + customerName);
        sc.close();
    }

}
