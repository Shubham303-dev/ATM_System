package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import dao.ATMDaoImpl;
import dao.ATMDaoIntrf;

public class Main {
    public static void main(String[] args) {
    	String cardNumber;
        int pin;
        double txamount;
        double currentBalance;
        ATMDaoIntrf dao=new ATMDaoImpl();
        
        System.out.println("Welcome to XYZ ATM");
        	
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        try {
        	System.out.println("Enter your 6digits card number");
			cardNumber=br.readLine();
			System.out.println("Enter your 4digits atm pin");
			pin=Integer.parseInt(br.readLine());
			
			boolean tf=dao.userValidate(cardNumber,pin);
			if(!tf){
				System.err.print("! User not found !");
			}
			else{
				do {
					System.out.println("1. Balance Enquiry\n" +
		                    "2. Withdrawal\n" +
		                    "3. Deposit \n" +
		                    "0. EXIT\n");

		            System.out.println("Enter Choice: ");
		            int ch=Integer.parseInt(br.readLine());
		            
		            switch (ch){
		            case 1:
	                	currentBalance=dao.balanceCheck();
	                	System.out.println("Current Account Balance : "+currentBalance);
	                	break;
	                	
		            case 2:
		            	System.out.println("Enter Amount to Withdraw : ");
		            	txamount=Double.parseDouble(br.readLine());
	                	currentBalance=dao.withdrawal(txamount);
	                	System.out.println("Current Account Balance : "+currentBalance);
	                	break;
	                	
		            case 3:
		            	System.out.println("Enter Amount to Diposit : ");
		            	txamount=Double.parseDouble(br.readLine());
	                	currentBalance=dao.deposit(txamount);
	                	System.out.println("Current Account Balance : "+currentBalance);
	                	break;

	                case 0:
	                    System.out.println("Thank you for using our ATM !!!");
	                    System.exit(0);
	                default:
	                    System.out.println("Enter valid choice !");
	                    break;


		            }
		            
				}while(true);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
}