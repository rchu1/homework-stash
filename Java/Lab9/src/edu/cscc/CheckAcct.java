package edu.cscc;

import java.util.Date;

public class CheckAcct {

   private static int Id;
   private double Balance, annIntRate, annualInterestRate, MonthlyInterest;
    private Date DateCreated;


    CheckAcct(int Id, double Balance) {
        this.Id = Id;
        this.Balance = Balance;
        DateCreated= new Date();

    }




    public void Withdraw(double withdraw) {

        Balance = Balance-withdraw ;
    }


    public void Deposit(double deposit) {
        Balance=Balance+deposit;

    }

    public static int getId() {
        return Id;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public double getAnnIntRate() {
        return annIntRate;
    }

    public void setAnnIntRate(double annIntRate) {
    annualInterestRate = annIntRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {

    }


    public double getMonthlyInterest() {
        MonthlyInterest = ((annualInterestRate/12)* Balance);
        return MonthlyInterest;
    }




    public Date getDateCreated() {
        return DateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        DateCreated = dateCreated;
    }


}
