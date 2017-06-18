package com.juliemartin.currencycalculator.presentation;

import com.juliemartin.currencycalculator.data.MoneyBean;
import com.juliemartin.currencycalculator.data.RecordBean;
import java.math.BigDecimal;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Julie Martin
 */
public class CurrencyCalculatorFX {
    
    private final MoneyBean money;
    private final RecordBean record;

    private TextField currencyCode;
    private TextField currencyAmount;
    private TextField value;
    private Label amountLabel;
    private Label title;

    private int calculationType;

    public CurrencyCalculatorFX(MoneyBean money, RecordBean record) {
        this.money = money;
        this.record = record;
        calculationType = 0; // Loan
    }
  
        // Create Layout Method
        public GridPane createLayout() {
        GridPane layout = new GridPane();
        
        // Column 0, Row 0
        Label title = new Label("Currency Converter");
        
        title.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans serif");
        
        // HBox will span 2 columns
        
        HBox hbox = new HBox();
        hbox.getChildren().addAll(title);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20.0));
        layout.add(hbox, 0, 0, 2, 1);
        
        // Column 0, Row 1
        Label currencyCodeLabel = new Label("Currency Code: ");
        currencyCodeLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans serif");
        layout.add(currencyCodeLabel, 0, 1);
        
        currencyCode = new TextField();
        currencyCode.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currencyCode.setAlignment(Pos.CENTER_RIGHT);
        layout.add(currencyCode, 1, 1);
        
        // Column 0, Row 2
        Label currencyAmountLabel = new Label("Amount: ");
        currencyAmountLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans-serif");
        layout.add(currencyAmountLabel, 0, 2);
        
        // Column 1, Row 2
        currencyAmount = new TextField();
        currencyAmount.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currencyAmount.setAlignment(Pos.CENTER_RIGHT);
        layout.add(currencyAmount, 1, 2);
        
        // Column 0, Row 3
        Label valueLabel = new Label("Value: ");
        valueLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        layout.add(valueLabel, 0, 3);
        
        // Column 1, Row 3
        value = new TextField();
        value.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans-serif");
        value.setAlignment(Pos.CENTER_RIGHT);
        
        // Make sure you can't edit the result field
        value.setEditable(false);
        layout.add(value, 1, 3);
        
        // Convert Button
        Button buy = new Button("Buy");
        buy.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");

        // Sell Button
        Button sell = new Button("Sell");
        sell.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");

        // Exit button
        Button exit = new Button("Exit");
        exit.setStyle("-fx-font-size:14pt; -fx-font-weight:bold;  -fx-font-family:Verdana, sans-serif");
        
        // HBox that will span 2 columns so that buttons can be centered 
        HBox hboxBtn = new HBox();

        // Add the buttons to the HBox
        hboxBtn.getChildren().addAll(buy, sell, exit);

        // Center the contents of the HBox
        hboxBtn.setAlignment(Pos.CENTER);
        
        // Spacing around the controls in the HBox
        hboxBtn.setPadding(new Insets(20.0));

        // Add spacebetween buttons
        hboxBtn.setSpacing(10.0); // Spacing around the controls in the HBox

        // Place the HBOX in column 0, row 4, spanning 2 columns and 1 row
        layout.add(hboxBtn, 0, 4, 2, 1);
        
        // Connect the buttons to their event handler
        buy.setOnAction(this::buyAction);
        sell.setOnAction(this::buyAction);
        exit.setOnAction(this::exitAction);
        
        // Set the column widths as a percentage
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(30.0);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(70.0);
        layout.getColumnConstraints().addAll(col1, col2);

        // Add space around the outside of the GridPane
        layout.setPadding(new Insets(0, 40, 0, 40));
        // Add space between rows and columns of the GridPane
        layout.setHgap(10.0);
        layout.setVgap(10.0);
        
        return layout;
    }
        
   private void calculateButtonHandler(ActionEvent e) {
        boolean doCalculation = true;
        try {
            finance.setInputValue(new BigDecimal(amountValue.getText()));
        } catch (NumberFormatException nfe) {
            doCalculation = false;
            numberFormatAlert(amountValue.getText(), "Loan");
        }
        try {
            finance.setRate(new BigDecimal(rateValue.getText()));
        } catch (NumberFormatException nfe) {
            doCalculation = false;
            numberFormatAlert(rateValue.getText(), "Rate");
        }
        try {
            finance.setTerm(new BigDecimal(termValue.getText()));
        } catch (NumberFormatException nfe) {
            doCalculation = false;
            numberFormatAlert(termValue.getText(), "Term");
        }

        if (doCalculation == true) {
            switch (calculationType) {
                case 0:
                    calc.loanCalculation(finance);
                    break;
                case 1:
                    calc.futureValueCalculation(finance);
                    break;
                case 2:
                    calc.savingsGoalCalculation(finance);
                    break;
            }
            resultValue.setText(finance.getResult().toString());
        }
    }


}


