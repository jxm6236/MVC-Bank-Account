/*
/***************************************
* Filename: NewAccountCon.java
* Short description: Controller for New Account
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Controller;

import Model.Model;
import View.NewAccount;
import java.util.ArrayList;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NewAccountCon implements java.util.Observer{
    
    private NewAccount newAccView;
    private Model model;
    
    public NewAccountCon(Model m, NewAccount view) {
        this.newAccView = view;
        this.model = m;
        model.addObserver(this);
        
        this.addItems();
        this.bind();
    }

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("New Account Added! ");
        newAccView.resetChoices();
    }
    
    private void addItems() {
        ArrayList<String> accountTypes = new ArrayList();
        
        accountTypes.add("Savings Account");
        accountTypes.add("Checking Account");
        accountTypes.add("Interest Checking Account");
        
        newAccView.setComboList(accountTypes);
    }
    
    private void bind() {
        newAccView.resetChoices();
        
        newAccView.bindCreateButton(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.addAccount(newAccView.getAccountType(), newAccView.getBalance());
            }
        });
    }
}
