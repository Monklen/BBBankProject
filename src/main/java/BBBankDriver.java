import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bbbank.dao.AccountHolderDao;
import com.bbbank.dao.AccountHolderDaoDB;
import com.bbbank.models.AccountHolder;

public class BBBankDriver {
	
	public static void main(String[] args) {
		
		AccountHolderDao  acDao= new AccountHolderDaoDB();
		List<AccountHolder> aList = acDao.getAllAccountHolders();
		
		System.out.println(aList);
		
		Scanner scan = new Scanner(System.in);
		
/*		double balance = 100000d;
		
		boolean appOn = true;
		boolean menuOn = false;
		
		while(appOn) {
			
			System.out.println("<= Bigger Better Bank => \n");
			
			System.out.println("1: Login \n2: Create Account \n3: Exit");
			
			int option = Integer.parseInt(scan.nextLine());
			
			if(option == 1) {
			
				System.out.println("--Login--");
				System.out.println("Username:");
				String username = scan.nextLine();
				
				System.out.println("Password:");
				String password = scan.nextLine();
				
				menuOn = true;
				
					while(menuOn == true) {
						System.out.println("Welcome! " + username + "\n \nBalance: $" + balance + "\n");
						System.out.println("Options:  \n1: Deposit \n2: Withdraw \n3: Transfer \n4: Account Info \n5: Exit");
					
						int choice = Integer.parseInt(scan.nextLine());
						
						
						if(choice == 1) {
							System.out.println("Enter deposit amount:");
							double deposit = Double.parseDouble(scan.nextLine());
							if(deposit<0) {
								System.out.println("Cannot deposit a negative amount");
								continue;
							}
							else {
								balance = balance + deposit;
							}
						}
						else if(choice == 2) {
							System.out.println("Enter amount to withdraw");
							double withdraw = Double.parseDouble(scan.nextLine());
							
							if(balance<=0 && balance - withdraw<=0) {
								System.out.println("Insufficient funds");
								continue;
							}
							else {
								balance = balance - withdraw;
							}
						}
						else if(choice == 3) {
							//get user by username
							System.out.println("Enter username of person you want to transfer money to");
							String transferee = scan.nextLine();
							
							System.out.println("\nEnter amount to be transfered:");
							double amount = Double.parseDouble(scan.nextLine());
							
							//get balance
							if(balance<=0 && balance - amount<=0) {
								System.out.println("Insufficient funds");
								continue;
							}
							else {
								// replace balance with new amount
								
								balance = balance - amount;
								
								//transferee balance = balance + amount
								//log the transfer
								// date-time, transferer, amount , transferee
							}
						}
						else if(choice == 4) {
							System.out.println("Account Info: \n");
							continue;
							}
						else if(choice == 5) {menuOn = false;}
						else {
							System.out.println("Invalid choice");
							continue;
						}
				}
				
			}
			else if(option == 2) {
				System.out.println("Enter first name:");
				String first = scan.nextLine();
				
				System.out.println("Enter last name:");
				String last = scan.nextLine();
				
				System.out.println("Username:");
				String username = scan.nextLine();
				
				System.out.println("Password:");
				String password = scan.nextLine();
			}
			else if(option == 3) {
				System.out.println("Goodbye");
				appOn = false;
			}
			else {
				System.out.println("Invalid choice");
				continue;
			}
		}
*/
	}
}
