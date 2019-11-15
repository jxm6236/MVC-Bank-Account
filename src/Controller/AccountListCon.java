/*
/***************************************
* Filename: AccountListCon.java
* Short description: Controller for AccountList class
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Controller;

import Model.Model;
import View.AccountList;

import java.util.Observable;
import java.util.Observer;

public class AccountListCon implements Observer{
    
    private AccountList accView;
    
    public AccountListCon(Model m, AccountList view) {
        this.accView = view;
        m.addObserver(this);
    }

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("UPDATED");
        if(o instanceof Model)
            updateAccList((Model)o);
        else
            System.out.println("Error");
    }
    
    public void updateAccList(Model m) {
        String output = " ";
        
        for(int i = 0; i < m.getAccountList().size(); i++)
        {
            output += (m.getAccountList().get(i) + "\n");
        }
        System.out.println("Update the account list to!\n" + output);
        
        accView.updateDisplay(output);
    }
}
