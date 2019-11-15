/*
/***************************************
* Filename: Modeljava
* Short description: Model Class
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Model;

import java.util.ArrayList;
import java.util.List;

public class Model extends java.util.Observable{

    //Initialize Variables
    ArrayList<BankAccount> accounts;
    
    //Default Constructor
    public Model() {
        accounts = new ArrayList();
    }
    
    //Add Account Method
    public void addAccount(String name, double initialBal) {
        accounts.add(new BankAccount(name, initialBal));
        this.setChanged();
        this.notifyObservers();
    }
    
    //Account Getter
    public BankAccount getAccount(int accountID) {    
        for(int i = 0; i < accounts.size(); i++)
        {
            BankAccount current = accounts.get(i);
            if(current.getID() == accountID)
            {
                return current;
            }
        }
        return null;
    }
    
    //Withdraw Method
    public boolean withdraw(int accountID, double amount) {
        BankAccount target = getAccount(accountID);
        
        if(target == null)
            return false;
        
        double oldBalance = target.getBalance();
        //Calculation
        target.withdraw(amount);
        
        if(oldBalance != target.getBalance())
        {
            this.setChanged();
            this.notifyObservers();
            
            return true;
        }
        return false;
    }
    //Deposit Method
    public boolean deposit(int accountID, double amount) {
        BankAccount target = getAccount(accountID);
        
        if(target == null)
            return false;
        
        double oldBalance = target.getBalance();
        
        //Calculation
        target.deposit(amount);
        
        if(oldBalance != target.getBalance())
        {
            this.setChanged();
            this.notifyObservers();
            
            return true;
        }
        return false;
        
    }
    
   //Account Delettion
    public boolean delAccount(int accountID) {
        BankAccount target = this.getAccount(accountID);
        
        if(target == null)
            return false;
        
        accounts.remove(target);
        this.setChanged();
        this.notifyObservers();
        return true;
    }
    
   //AcountList Getter
    public List getAccountList() {
        return java.util.Collections.unmodifiableList(accounts);
    }
}
