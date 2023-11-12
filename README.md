# Java-ATM-Code
# Using Class and Object

package OOPSinJAVA;
import java.util.Scanner;
class ATM{
     String accountNumber;
     String pin;
     double balance;

    public ATM(String accountNumber,String pin,double balance){
        this.accountNumber=accountNumber;
        this.pin=pin;
        this.balance=balance;
    }
    public void displayBalance(){
        
        System.out.println("Your Account Balance is : "+balance);
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Rs" + amount + "Deposited Succesfully");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }
        public void withdraw(double amount){
            if(amount > 0 && amount <= balance){
                balance=balance-amount;
                System.out.println("Rs"+amount+"Withdraw Succesfully");
            }
            else{
                System.out.println("Insufficient Fund");
            }
       }
  }
public class Praticee {
    public static void main(String[] args) {
        ATM atm=new ATM("123456","1234",1000.0);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Account number ");
        String enteredAccountNumber=sc.nextLine();
        System.out.println("Your pin");
        String enteredPin=sc.nextLine();
        if(enteredAccountNumber.equals(atm.accountNumber) && enteredPin.equals(atm.pin)){
            System.out.println("Welcome to the ATM : ");

         int choice;
         do {
             System.out.println("\nOptions");
             System.out.println("1.Display");
             System.out.println("2.Deposit");
             System.out.println("3.Withdraw");
             System.out.println("4.Exit");
             System.out.println("Select option");
             choice = sc.nextInt();

             switch (choice) {
                 case 1:
                     atm.displayBalance();
                     break;
                 case 2:
                     System.out.println("Enter deposit amoount");
                     double depositAmount = sc.nextDouble();
                     atm.deposit(depositAmount);
                     break;
                 case 3:
                     System.out.println("Enter withdraw amount");
                     double withdrawAmount = sc.nextDouble();
                     atm.withdraw(withdrawAmount);
                     break;
                 case 4:
                     System.out.println("Thankyou for using the ATM Goodbye");
                     break;

                 default:
                     System.out.println("Invalid option.Please try again");
             }
         }
         while(choice!=4);
        }
         else {
        System.out.println("Invalid account number or pin or Access denied");
    }
    sc.close();
}
}

