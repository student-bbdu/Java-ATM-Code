import java.util.Scanner;

class ATM {
    private String accountNumber;
    private String pin;
    private double balance;

    public ATM(String accountNumber, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public void displayBalance() {
        System.out.println("Your account balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM("123456", "1234", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String enteredAccountNumber = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String enteredPin = scanner.nextLine();

        if (enteredAccountNumber.equals(atm.accountNumber) && enteredPin.equals(atm.pin)) {
            System.out.println("Welcome to the ATM!");
            int choice;
            do {
                System.out.println("\nOptions:");
                System.out.println("1. Display Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.displayBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid account number or PIN. Access denied.");
        }

        scanner.close();
    }
}