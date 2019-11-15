/*
/***************************************
* Filename: BankAccount.java
* Short description: BankAccount Model
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Model;

public class BankAccount {
    
    // InitializeVariables
    private static int accNum = 0;
    private int accountID;
    private String accName;
    private double accountBal;
    
    //Default Constructor
    public BankAccount() {
        this("Normal Checking Account", 0);
    }
    
    public BankAccount(String name, double startBal) {
        this.accName = name;
        this.accountBal = startBal;
        this.accountID = ++accNum;
        System.out.println(this);
    }
    
    //ID Getter
    public int getID() {
        return this.accountID;
    }
    
    //Account Name Getter
    public String getAccountName() {
        return this.accName;
    }
    
    //Account Balance Getter
    public double getBalance() {
        return this.accountBal;
    }
    
    //Withdraw Method
    public void withdraw(double amount) {
        if(amount > this.accountBal)
        {
            System.out.println("Not enough Funds");
            return;
        }
        else if(amount < 0)
        {
            System.out.println("Withdraw must be greaer than 0");
            return;
        }
        
        this.accountBal -= amount;
    }
    
    //Deposit Method
    public void deposit(double amount)
    {
        if(amount < 0)
        {
            System.out.println("Invalid Transaction: Amount cannot be less than 0");
            return;
        }
        
        this.accountBal += amount;
    }

    @Override
    public String toString() {
        return (accName + " " + accountID + ": balance = $" + String.format("%.2f",accountBal));
    }
}
