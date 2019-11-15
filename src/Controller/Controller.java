/*
/***************************************
* Filename: Controller.java
* Short description: Controls the 3 classes
* @author James McGettigan
* @version  11/1/2019
***************************************/
package Controller;

import Model.Model;
import View.View;

public class Controller {
   
    public Controller(Model model, View view) {
        AccountListCon accListCon = new AccountListCon(model, view.getAccountList());
        ExistingAccountCon exAccCon = new ExistingAccountCon(model, view.getExistingAccount());
        NewAccountCon newAcc = new NewAccountCon(model, view.getNewAccount());
    }
}
