package com.juliemartin.currencycalculator.app;

import java.text.NumberFormat;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        double cur1 = Double.parseDouble(currency1.getText());
        double cur2 = Double.parseDouble(currency2.getText());
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

    
    // Create Layout Method
    
    private GridPane createLayout() {
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
        Label currency1Label = new Label("Currency 1: ");
        currency1Label.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans serif");
        layout.add(currency1Label, 0, 1);
        
        currency1 = new TextField();
        currency1.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currency1.setAlignment(Pos.CENTER_RIGHT);
        layout.add(currency1, 1, 1);
        
        // Column 0, Row 2
        Label currency2Label = new Label("Currency2: ");
        currency2Label.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans-serif");
        layout.add(currency2Label, 0, 2);
        
        // Column 1, Row 2
        currency2 = new TextField();
        currency2.setStyle("-fx-font-size:14pt; -fx-font-weight:normal; -fx-font-family:Verdana, sans-serif");
        currency2.setAlignment(Pos.CENTER_RIGHT);
        layout.add(currency2, 1, 2);
        
        // Column 0, Row 3
        Label resultLabel = new Label("Result: ");
        resultLabel.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");
        layout.add(resultLabel, 0, 3);
        
        // Column 1, Row 3
        result = new TextField();
        result.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family: Verdana, sans-serif");
        result.setAlignment(Pos.CENTER_RIGHT);
        
        // Make sure you can't edit the result field
        result.setEditable(false);
        layout.add(result, 1, 3);
        
        // Convert Button
        Button convert = new Button("Convert");
        convert.setStyle("-fx-font-size:14pt; -fx-font-weight:bold; -fx-font-family:Verdana, sans-serif");

        // Exit button
        Button exit = new Button("Exit");
        exit.setStyle("-fx-font-size:14pt; -fx-font-weight:bold;  -fx-font-family:Verdana, sans-serif");
        
        // HBox that will span 2 columns so that buttons can be centered 
        HBox hboxBtn = new HBox();

        // Add the buttons to the HBox
        hboxBtn.getChildren().addAll(convert, exit);

        // Center the contents of the HBox
        hboxBtn.setAlignment(Pos.CENTER);
        
        // Spacing around the controls in the HBox
        hboxBtn.setPadding(new Insets(20.0));

        // Add spacebetween buttons
        hboxBtn.setSpacing(10.0); // Spacing around the controls in the HBox

        // Place the HBOX in column 0, row 4, spanning 2 columns and 1 row
        layout.add(hboxBtn, 0, 4, 2, 1);
        
        // Connect the buttons to their event handler
        convert.setOnAction(this::convertAction);
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
    
    @Override
    public void start(Stage primaryStage) {

        // Create Layout
        
        Parent root = createLayout();
        
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
