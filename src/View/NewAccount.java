/*
/***************************************
* Filename: NewAccount.java
* Short description: Controller for New Account
* @author James McGettigan
* @version  11/1/2019
***************************************/
package View;

import java.util.ArrayList;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewAccount{

    //Initialize Variables
    private Label selection, deposit;
    private ComboBox cBox;
    private TextField depositField;
    private Button createAccount;

    //Default Constructor
    public NewAccount() {
        super();
        Stage primaryStage = new Stage();
        Scene root;
                
        //Construct the VBox
        GridPane primaryLayout = new GridPane();
        primaryLayout.setHgap(5);
        primaryLayout.setVgap(10);
        primaryLayout.setAlignment(Pos.CENTER);
        root = new Scene(primaryLayout, 300, 200);

        selection = new Label("Select Account Type");
        primaryLayout.add(selection,0,0);
        
        //Make ComboBox
        cBox = new ComboBox();
        primaryLayout.add(cBox, 0,1);
        centerNode(cBox);   
        
        deposit = new Label("Initial Deposit:");
        
        depositField = new TextField();
        
        GridPane.setHalignment(depositField, HPos.RIGHT);
        GridPane.setValignment(depositField, VPos.CENTER);
        
        primaryLayout.add(deposit, 0, 2);
        primaryLayout.add(depositField, 1, 2);
        
        //Add the button to create an account
        createAccount = new Button("Create Account");
        primaryLayout.add(createAccount, 0, 3);
        this.centerNode(createAccount);
        
        primaryStage.setTitle("Create New Account");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    private void centerNode(Node current) {
        GridPane.setHalignment(current, HPos.CENTER);
        GridPane.setValignment(current, VPos.CENTER);
        GridPane.setColumnSpan(current, GridPane.REMAINING);
    }
    
    public void bindCreateButton(EventHandler<ActionEvent> action)
    {
        createAccount.setOnAction(action);
    }
    
    public String getAccountType()
    {
        return (String)cBox.getValue();
    }
    
    public void setComboList(ArrayList<String> list)
    {
        cBox.getItems().addAll(list);
    }
    
    public double getBalance()
    {
        try
        {
            return Math.abs(Double.parseDouble(this.depositField.getText()));
        }
        catch(NumberFormatException e)
        {
            return 0;
        }
    }
    
    public void resetChoices()
    {
        depositField.setText("0");
        cBox.setValue(cBox.getItems().get(0));
    }
    
}
