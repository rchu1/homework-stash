package edu.cscc;
/*
	Chapter 10:	Account program
	Programmer: Randy Chu
	Date: 3/39/2018
	Filename:	BankAcctDemo.java
	Purpose:
*/
import edu.cscc.CheckAcct;
import java.util.Scanner;
import java.text.DecimalFormat;

public class BankAcctDemo {
  public static void main (String[] args) {
	  int acctID;
	  double acctBalance, annIntRate, momthlyin, withAmt, depAmt;
	  Scanner input = new Scanner(System.in);
	  DecimalFormat twoDigits = new DecimalFormat("$###,###.00");

	  System.out.println("   Bank Account Balance");
	  System.out.println();

	  System.out.print("Enter your account id: ");
	  acctID = input.nextInt();
	  System.out.println();

	  System.out.print("Enter your current Balance: ");
	  	  acctBalance = input.nextDouble();
	  System.out.println();

	  System.out.print("Enter your annual interest rate: ");
	  	  annIntRate = input.nextDouble();
	  System.out.println();

	  System.out.print("Enter any withdrawals: ");
	  	  	  withAmt = input.nextDouble();
	  System.out.println();

	  System.out.print("Enter any deposits: ");
	  	  	  depAmt = input.nextDouble();
	  System.out.println();


     CheckAcct account = new CheckAcct(acctID, acctBalance);
    account.setAnnIntRate(annIntRate);

    account.Withdraw(withAmt);
    account.Deposit(depAmt);
    System.out.println("Balance for account # " +  account.getId() + " is " +twoDigits.format(account.getBalance()));

    System.out.println("Monthly interest is " + twoDigits.format(account.getMonthlyInterest()));

    System.out.println("This account was created at " +
      account.getDateCreated());
      System.out.println();
  }
}

