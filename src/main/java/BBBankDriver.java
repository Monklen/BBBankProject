import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bbbank.dao.AccountHolderDao;
import com.bbbank.dao.AccountHolderDaoDB;
import com.bbbank.models.AccountHolder;
import com.bbbank.services.AccountService;

public class BBBankDriver {
	
	private static AccountHolderDao aDao = new AccountHolderDaoDB();
	private static AccountService aServ = new AccountService(aDao);

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//double balance = 100000d;
		
		boolean appOn = true;
		boolean menuOn = false;
		
		AccountHolder ac = null;
		
		while(appOn) {
			
			System.out.println("\n== Bigger Better Bank == \n");
			
			if(ac==null) {
				
				System.out.println("1: Login \n2: Create Account \n3: Exit");
			
				int option = Integer.parseInt(scan.nextLine());
			
				if(option == 1) {
			
					System.out.println("\n--Login--");
					System.out.println("Username:");
					String username = scan.nextLine();
				
					System.out.println("Password:");
					String password = scan.nextLine();
					
					try {
						ac = aServ.login(username, password);
						System.out.println("\nWelcome! " + ac.getUsername());
						menuOn = true;
					}
					catch(Exception e) {
						System.out.println("Username or password was incorrect");
					}
					
					
					
					while(menuOn == true) {
						System.out.println("\nBalance: $" + ac.getBalance() + "\n");
						System.out.println("Options:  \n1: Deposit \n2: Withdraw \n3: Transfer \n4: Account Info \n5: Logout");
					
						int choice = Integer.parseInt(scan.nextLine());
						
						
						if(choice == 1) {
							System.out.println("--Deposit--");
							System.out.println("Enter deposit amount:");
							double deposit = Double.parseDouble(scan.nextLine());
							if(deposit<0) {
								System.out.println("Cannot deposit a negative amount");
								continue;
							}
							else {
								double balance = ac.getBalance() + deposit;
								ac.setBalance(balance);
								aDao.updateAccountHolder(ac);
								
								
							}
						}
						else if(choice == 2) {
							System.out.println("\n--Withdraw--\n");
							System.out.println("Enter amount to withdraw:");
							double withdraw = Double.parseDouble(scan.nextLine());
							
							if(ac.getBalance()<=0 || ac.getBalance() - withdraw<0) {
								System.out.println("Insufficient funds");
								continue;
							}
							else {
								double balance = ac.getBalance() - withdraw;
								ac.setBalance(balance);
								aDao.updateAccountHolder(ac);
							}
							continue;
						}
						else if(choice == 3) {
							System.out.println("\n--Transfer--");
							continue;
						}
						else if(choice == 4) {
							System.out.println("\n--Account Info--\n");
							System.out.println(ac);
							continue;
						}
						else if(choice == 5) {
							menuOn = false;
							ac = null;
						}
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
				
				try {
					ac = aServ.signup(first, last, username, password, 0);
					System.out.println("Welcome " + ac.getUsername() + "! You may now sign in");
				}
				catch(Exception e) {
					System.out.println("Username already taken, please try again");
				}
				
				ac = null;
			}
				
				
					
//							
//						}
//						else if(choice == 2) {
//							
//						}
//						else if(choice == 3) {
//							//get user by username
//							System.out.println("Enter username of person you want to transfer money to");
//							String transferee = scan.nextLine();
//							
//							System.out.println("\nEnter amount to be transfered:");
//							double amount = Double.parseDouble(scan.nextLine());
//							
//							//get balance
//							if(balance<=0 && balance - amount<=0) {
//								System.out.println("Insufficient funds");
//								continue;
//							}
//							else {
//								// replace balance with new amount
//								
//								//balance = balance - amount;
//								
//								//transferee balance = balance + amount
//								//log the transfer
//								// date-time, transferer, amount , transferee
//							}
//						}
//						else if(choice == 4) {
//							System.out.println("Account Info: \n");
//							continue;
//							}
//						else if(choice == 5) {menuOn = false;}
//						else {
//							System.out.println("Invalid choice");
//							continue;
//						}
//				}
//				
//			}}
			
				
			
			else if(option == 3) {
				System.out.println("Goodbye");
				appOn = false;
			}
			else {
				System.out.println("Invalid choice");
				continue;
			}
		}
		}
	}
}
