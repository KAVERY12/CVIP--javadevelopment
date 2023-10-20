
import java.util.*;
import java.util.Scanner;

public class ATM {
    private double balance;
    private String cardNumber;
    private String pin;

    public ATM(String cardNumber, String pin, double initialBalance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public void showMenu() {
        System.out.println("Welcome to CUB Bank ATM");
        System.out.println("Please insert your card.");
        System.out.println("--------------------------");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Change PIN");
        System.out.println("5. Exit");
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void withdrawMoney(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Please take your cash: $" + amount);
            System.out.println("Your remaining balance is: $" + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println("You have successfully deposited: $" + amount);
        System.out.println("Your new balance is: $" + balance);
    }

    public void changePIN(String newPIN) {
        pin = newPIN;
        System.out.println("Your PIN has been changed successfully.");
    }

    public static void main(String[] args) {
        ATM atm = new ATM("3451245", "45213", 5000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your card number: ");
        String inputCardNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String inputPIN = scanner.nextLine();

        if (inputCardNumber.equals(atm.cardNumber) && inputPIN.equals(atm.pin)) {
            int choice;
            do {
                atm.showMenu();
                System.out.print("Please select an option: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter the amount to withdraw: $");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdrawMoney(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter the amount to deposit: $");
                        double depositAmount = scanner.nextDouble();
                        atm.depositMoney(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter your new PIN: ");
                        String newPIN = scanner.next();
                        atm.changePIN(newPIN);
                        break;
                    case 5:
                        System.out.println("Thank you for using XYZ Bank ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid card number or PIN. Please try again.");
        }

        scanner.close();
    }
}

