package com.juliemartin.currencycalculator.app;

import com.juliemartin.currencycalculator.presentation.CurrencyCalculatorFX;
import java.text.NumberFormat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Julie Martin
 */
public class CurrencyCalculatorMain extends Application {
    
    private TextField currency1;
    private TextField currency2;
    private TextField result;

        /**
        * Convert: No check for valid strings for parseDouble
        *
        * @param event
        */
        private void convertAction(ActionEvent event) {
        double cur1 = Double.parseDouble(currencyCode.getText());
        double cur2 = Double.parseDouble(currencyAmount.getText());
        double cur3 = Double.parseDouble(value.getText());
        String ans = NumberFormat.getNumberInstance().format((cur1 + cur2));
        result.setText(ans);
        }

        /**
        * Use Platform.exit() rather than System.exit(0)
        *
        * @param event
        */
        private void exitAction(ActionEvent event) {
        Platform.exit();
        }
    
    @Override
    public void start(Stage primaryStage) {

        // Create Layout
        
        Parent root = CurrencyCalculatorFX.createLayout();
        
        Scene scene = new Scene(root, 425, 300);
        
        primaryStage.setTitle("Currency Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
