package CodSoft_3rd_Java_Program;

import java.util.Scanner;

class BankAccount{

	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
		
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount; 
			System.out.println("Deposit successful. New balance: "+balance);
		}else {
			System.out.println("Invalid deposit amount. Please enter a positive value.");
		}
	}
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawl amount. New balance:"+balance);
		}else if(amount <= 0){
			System.out.println("Invalid withdrawl amount. Please enter a positive value.");
		} else {
			System.out.println("Insufficient funds. Withdrawl failed.");
		}
	}
}
class ATM{
	private BankAccount bankAccount;
	
	public ATM(BankAccount bankAccount){
		this.bankAccount = bankAccount;
	}
	public void displayMenu() {
		System.out.println("ATM Menu.");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Exit");
	}
	
	public void processOption(int option) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		switch (option) {
		case 1:
			System.out.println("Current Balance: "+bankAccount.getBalance());
			break;
		case 2:
			System.out.println("Enter deposit amount: ");
			double depositAmount = sc.nextDouble();
			bankAccount.deposit(depositAmount);
			break;
		case 3:
			System.out.println("Enter withdrawl amount: ");
			double withdrawlAmount = sc.nextDouble();
			bankAccount.withdraw(withdrawlAmount);
			break;
		case 4:
			System.out.println("Exiting ATM. Thank you!");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid option. Please choose a valid option.");
		}
	}
}
public class Atm_Interface {
	public static void main(String[] args) {
		BankAccount userAccount = new BankAccount(1000.0);
		ATM atm = new ATM(userAccount);
		int userOption;
		Scanner sc = new Scanner(System.in);
		
		do {
			atm.displayMenu();
			System.out.println("Enter you choice 1-4:");
			userOption = sc.nextInt();
			atm.processOption(userOption);
		} while (userOption != 4);
		
		sc.close();
	}
}
