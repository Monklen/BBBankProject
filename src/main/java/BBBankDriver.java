import java.util.Scanner;

public class BBBankDriver {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean appOn= true;
		boolean home = false;
		boolean signup = false;
		
		
		while (appOn == true) {
			System.out.println("\tWelcome to The Bigger Better Bank!\n");
			
			System.out.println("Type the number to Select an option:"
							+ "\n1: Login"
							+ "\n2: Sign Up"
							+ "\n3: Exit");
			int input = scan.nextInt();
			
			if (input == 1) {
				System.out.println("Enter username: ");
				String username = scan.nextLine();
				System.out.println("Enter password: ");
				String password = scan.nextLine();
				
	
			}
			else if(input == 2) {
				System.out.println("Enter your first name: ");
				String firstName = scan.nextLine();
				System.out.println("Enter your last name: ");
				String lastName = scan.nextLine();
				System.out.println("Enter a username: ");
				String username = scan.nextLine();
				System.out.println("Enter a password: ");
				String password = scan.nextLine();
				
			}
			else if(input == 3) {
				appOn = false;
			}
			else {
				System.out.println("invalid input");
				continue;
			}
			
		}
	}

}
