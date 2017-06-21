package com.juliemartin.currencycalculator.calc;

import com.juliemartin.currencycalculator.data.MoneyBean;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Julie Martin
 */
public class Calculations {
    
      /**
     * Buying
     *
     * @param money
     * @throws ArithmeticException
     */
    public void buyPerCAD(MoneyBean money) throws ArithmeticException {
        // Divide APR by 12
        BigDecimal monthlyRate = money.getRate().divide(new BigDecimal("12"), MathContext.DECIMAL64);

        // At each step this variable is updated
        BigDecimal temp;
        // (1+rate)
        temp = BigDecimal.ONE.add(monthlyRate);

        // (1+rate)^term
        temp = temp.pow(money.getTerm().intValueExact());

        // 1 - (1+rate)^-term
        temp = BigDecimal.ONE.subtract(temp);

        // (1 - (1+rate)^-term) / rate
        temp = temp.divide(monthlyRate, MathContext.DECIMAL64);

        // pv * (rate / 1 - (1+rate)^-term)
        temp = money.getInputValue().multiply(temp);

        // Round to 2 decimal places using banker's rounding
        temp = temp.setScale(2, RoundingMode.HALF_EVEN);

        // Remove the sign if the result is negative
        money.setResult(temp.abs());

    }
    
    
    
}
