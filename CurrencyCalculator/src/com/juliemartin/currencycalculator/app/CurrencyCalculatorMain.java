package com.juliemartin.currencycalculator.app;

import com.juliemartin.currencycalculator.calc.Calculations;
import com.juliemartin.currencycalculator.data.MoneyBean;
import com.juliemartin.currencycalculator.data.RecordBean;
import com.juliemartin.currencycalculator.presentation.CurrencyCalculatorFX;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Julie Martin
 */
public class CurrencyCalculatorMain extends Application {
    
    private Calculations calc;
    private MoneyBean money;
    private RecordBean record;
    private CurrencyCalculatorFX gui;

    @Override
    public void init() {
        calc = new Calculations();
        money = new MoneyBean();
        record = new RecordBean();
        gui = new CurrencyCalculatorFX(calc, record);
    }

    @Override
    public void start(Stage primaryStage) {
        gui.start(primaryStage);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
    
}