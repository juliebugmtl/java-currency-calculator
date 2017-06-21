/**
 * @author Julie Martin
 * @version 0.1
 */
package com.juliemartin.currencycalculator.data;

import com.juliemartin.currencycalculator.*;
import java.sql.*;
import java.util.*;

class Converter implements CurrencyDB {

    String url = "jdbc:derby://localhost:1527/CONVERTER";
    String user = "money";
    String password = "moneybags";
    
    public Converter() {
        super();
    }

    /**
     * Retrieve all the records for a given table Return the data as an
     * array list of CurrencyData objects
     *
     * @param sql The SQL statement to execute
     * @return The array list
     */

    public ArrayList<CurrencyData> getQueryRecords() {

        ArrayList<CurrencyData> rows = new ArrayList<>();
        String sql = "Select * from CONVERTER";
        try (
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pStatement = connection.prepareStatement(sql);
                ResultSet resultSet = pStatement.executeQuery();) {
            while (resultSet.next()) {
                rows.add(new CurrencyData(
                        resultSet.getInt("ID"),
                        resultSet.getString("CURRENCYCODE"),
                        resultSet.getString("BUYPERCAD"),
                        resultSet.getString("SELLPERCAD")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
        return rows;
    }
}
