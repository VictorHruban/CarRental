package com.company.dao;

import com.company.model.User;
import com.company.model.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends GenericDao {
    public User findByUsername(String username) {
        String query = "select id, username, password, type from user" +
                "                where username= ?";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                UserType userType = UserType.valueOf(resultSet.getString("type"));
                return new User(id, username, password, userType);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public User save(User user) {
        String query = "insert into user(username,password,type) values(?,?,?)";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUserType().name());
            preparedStatement.executeUpdate();
            return findByUsername(user.getUsername());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public User correctCredentials(String username, String password) {
        String query = "select id,username, password,type from user where username=? and password=?";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), UserType.valueOf(resultSet.getString(4)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

}
