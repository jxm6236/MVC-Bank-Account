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

    //Local Variables
    private int currentAcc = -1;
    private Model m;
    private ExistingAccount view;



    public ExistingAccountCon(Model m, ExistingAccount view)

    {

        this.m = m;
        this.view = view;
        m.addObserver(this);

        setSelectButton();
        setDepositButton();
        setWithdrawButton();
        setDeleteButton();
    }

    @Override
    public void update(Observable o, Object o1) {
        checkAccountInput();
        view.resetInputFields();
    }


    private void checkAccountInput()
    {
        currentAcc = view.getAccountID();
        if(m.getAccount(currentAcc) != null)
        {
            view.setBalance(m.getAccount(currentAcc).getBalance());
        }
        else
        {
            currentAcc = -1;
            invalidAccount();
        }
    }
    //Setters
    private void setSelectButton()
    {
        view.bindSelectButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkAccountInput();
            }
        });
    }


    private void setWithdrawButton()
    {
        view.bindWithdrawButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(view.getAccountID() != currentAcc)
                    checkAccountInput();
                
                //-1 represents an invalid account
                if(currentAcc != -1)
                {
                    m.withdraw(currentAcc, view.getWithdraw());
                }
                else
                {
                    invalidAccount();
                }

            }

        });

    }

    private void invalidAccount()
    {
        view.setBalanceField("Invalid");
    }

    //Setters
    private void setDepositButton()
    {
        view.bindDepositButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Make sure the right account is signed in
                if(view.getAccountID() != currentAcc)
                    checkAccountInput();

                //-1 represents an invalid account
                if(currentAcc != -1)
                {
                    m.deposit(currentAcc, view.getDeposit());
                }
                else
                {
                    invalidAccount();
                }
            }
        });
    }


    private void setDeleteButton()
    {
        view.bindDeleteButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Make sure the right account is signed in
                if(view.getAccountID() != currentAcc)
                    checkAccountInput();
                
                boolean success = false;
                
                if(currentAcc != -1)
                    success = m.delAccount(currentAcc);
                
                if(success)
                    view.setBalanceField("Success");
                else
                    view.setBalanceField("Failure");
            }
        });
    }
}