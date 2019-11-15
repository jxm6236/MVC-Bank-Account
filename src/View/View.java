/*
/***************************************
* Filename: View.java
* Short description: View for all panels
* @author James McGettigan
* @version  11/1/2019
***************************************/
package View;

public class View {
    private AccountList accList;
    private ExistingAccount exAccList;
    private NewAccount newAcc;
    
    public View()
    {
        accList = new AccountList();
        exAccList = new ExistingAccount();
        newAcc = new NewAccount();
    }

    public AccountList getAccountList() {
        return accList;
    }

    public ExistingAccount getExistingAccount() {
        return exAccList;
    }

    public NewAccount getNewAccount() {
        return newAcc;
    }
    
    
}
