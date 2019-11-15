/*
/***************************************
* Filename: BankAccount.java
* Short description: Controller for Existing Account
* @author James McGettigan
* @version  11/1/2019
***************************************/
package MVC_BankAccount;

import javafx.application.Application;
import javafx.stage.Stage;

public class BankAccount extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        View.View view = new View.View();
        Model.Model model = new Model.Model();
        Controller.Controller controller = new Controller.Controller(model, view);
    }

    //Main App
    public static void main(String[] args) {
        launch(args);
    }
    
}
