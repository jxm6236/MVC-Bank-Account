/*
/***************************************
* Filename: ExistingAccount.java
* Short description: View for Existing Account
* @author James McGettigan
* @version  11/1/2019
***************************************/
package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ExistingAccount{

    //Declare Variables
    private Button accSelection; 
    private Button withdraw; 
    private Button deposit ;
    private Button delete;
    
    private TextField account; 
    private TextField withdrawOut; 
    private TextField depositIn; 
    private TextField balance;
    
    private Label bal;
    
    public ExistingAccount()
    {
        //Local Variables
        Stage primaryStage = new Stage();
        Scene root;
        GridPane layout = new GridPane();
        
        //Start putting together the GridPane
        //Account
        accSelection = new Button("Account Selection");
        account = new TextField();
        
        layout.add(account, 0, 0);
        layout.add(accSelection, 1, 0);
        
        //Deposit
        deposit = new Button("Deposit");
        depositIn = new TextField();
        
        layout.add(depositIn, 0, 1);
        layout.add(deposit, 1, 1);
        
        //Withdraw
        withdraw = new Button("Withdraw");    
        withdrawOut = new TextField();
        
        layout.add(withdrawOut, 0, 2);
        layout.add(withdraw, 1, 2);
        
        //Balance
        balance = new TextField();
        balance.setDisable(true);
        balance.setStyle("-fx-opacity: 1;");
        
        bal = new Label("Balance");
                
        //Delete
        delete = new Button("Delete");
        
        layout.add(bal, 0, 3);
        
        GridPane.setHalignment(bal, HPos.RIGHT);
        GridPane.setValignment(bal, VPos.CENTER);
        
        layout.add(balance, 1, 3);
        layout.add(delete, 1, 4);
        layout.setAlignment(Pos.CENTER);
        layout.setHgap(5);
        layout.setVgap(10);
        
        root = new Scene(layout, 325, 200);
        primaryStage.setTitle("Access an Existing Account");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    public void bindSelectButton(EventHandler<ActionEvent> action)
    {
        this.accSelection.setOnAction(action);
    }
    
    public void bindWithdrawButton(EventHandler<ActionEvent> action)
    {
        this.withdraw.setOnAction(action);
    }
    
    public void bindDepositButton(EventHandler<ActionEvent> action)
    {
        this.deposit.setOnAction(action);
    }
    
    public void bindDeleteButton(EventHandler<ActionEvent> action)
    {
        this.delete.setOnAction(action);
    }
    
    public double getWithdraw()
    {
        try
        {
        return Double.parseDouble(withdrawOut.getText());
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
                
    }
    
    public double getDeposit()
    {
        try
        {
            return Double.parseDouble(depositIn.getText());
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
    
    public int getAccountID()
    {
        int input;
        try
        {
            input = Integer.parseInt(account.getText());
        }
        catch(NumberFormatException e)
        {
            input = -1;
        }
        return input;
    }
    
    public void setBalance(double balance)
    {
        this.balance.setText(String.format("%.2f",balance));
    }
    
    public void setBalanceField(String input)       
    {
        this.balance.setText(input);
    }
    
    public void resetInputFields()
    {
        this.depositIn.setText("");
        this.withdrawOut.setText((""));
    }
    
}
