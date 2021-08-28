package com.company.dao;

import com.company.model.Discount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DiscountDao extends GenericDao {
    public void updateDiscountByDays(double discountValue, int daysForDiscount) {
        String query = "update discount set discount=? where days_for_discount = ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setDouble(1, discountValue);
            preparedStatement.setInt(2, daysForDiscount);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Discount> getAllDiscounts() {
        String query = "select id,discount,days_for_discount from discount";
        List<Discount> discountList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double discount = resultSet.getDouble("discount");
                int daysForDiscount = resultSet.getInt("days_for_discount");

                discountList.add(new Discount(id, discount, daysForDiscount));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return discountList;
    }
}
