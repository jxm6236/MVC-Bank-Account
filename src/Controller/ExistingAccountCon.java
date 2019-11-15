/*
/***************************************
* Filename: ExistingAccountCon.java
* Short description: Controller for Existing Account
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Controller;

import Model.Model;
import View.ExistingAccount;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ExistingAccountCon implements Observer{

    private int currentAcc = 0;
    private Model m;
    private ExistingAccount accView;
    
    public ExistingAccountCon(Model m, ExistingAccount v) {
        this.m = m;
        this.accView = accView;
        m.addObserver(this);
        
        setSelectButton();
        setDepositButton();
        setWithdrawButton();
        setDeleteButton();
    }
    
    @Override
    public void update(Observable o, Object o1) {
        checkAccountInput();
        accView.resetInputFields();
    }
    
    private void checkAccountInput() {
        currentAcc = accView.getAccountID();
        if(m.getAccount(currentAcc) != null)
        {
            accView.setBalance(m.getAccount(currentAcc).getBalance());
        }
        else
        {
            currentAcc = -1;
            invalidAccount();
        }
    }
    //Setters
    private void setSelectButton() {
        accView.bindSelectButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAccountInput();
            }
        });
    }

    private void setWithdrawButton() {
        accView.bindWithdrawButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(accView.getAccountID() != currentAcc)
                    checkAccountInput();
                
                //-1 represents an invalid account
                if(currentAcc != -1)
                {
                    m.withdraw(currentAcc, accView.getWithdraw());
                }
                else
                {
                    invalidAccount();
                }
            }
        });
    }
    
    private void invalidAccount() {
        accView.setBalanceField("Invalid");
    }
    
    //Setters
    private void setDepositButton() {
        accView.bindDepositButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(accView.getAccountID() != currentAcc)
                    checkAccountInput();
                
                //-1 represents an invalid account
                if(currentAcc != -1)
                {
                    m.deposit(currentAcc, accView.getDeposit());
                }
                else
                {
                    invalidAccount();
                }
            }
        });
    }
    
    private void setDeleteButton() {
        accView.bindDeleteButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                
                //Make sure the right account is signed in
                if(accView.getAccountID() != currentAcc)
                    checkAccountInput();
                
                boolean success = false;
                
                if(currentAcc != -1)
                    success = m.delAccount(currentAcc);
                
                if(success)
                    accView.setBalanceField("Deleted");
                else
                    accView.setBalanceField("Error");
            }
        });
    }
}
