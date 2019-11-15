/*
/***************************************
* Filename: AccountList.java
* Short description: View for AccountList
* @author James McGettigan
* @version  11/1/2019
***************************************/
package View;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

public class AccountList{
    //Initialize Variables
    private TextArea display;
    
    public AccountList() {
        Stage primaryStage = new Stage();
        Scene root;
        BorderPane layout = new BorderPane();
        
        display = new TextArea();
        display.setText("Please Create an Account!");
        display.setEditable(false);
        
        layout.setCenter(display);
        
        root = new Scene(layout, 300, 250);
        primaryStage.setTitle("Account List");
        primaryStage.setScene(root);
        primaryStage.show();
    }
    
    public void updateDisplay(String newString) {
        display.setText(newString);
    }
}