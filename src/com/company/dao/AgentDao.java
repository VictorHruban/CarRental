package com.company.dao;

import com.company.model.Agent;
import com.company.model.User;
import com.company.model.UserType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentDao extends GenericDao {
    public Agent findByUserId(int userId) {
            String query ="select agent.id, nume, prenume,telefon,email,adresa,agent_user_id,username,password,type from agent\n" +
                    " inner join user on user.id = agent_user_id\n" +
                    " where user.id=?";
            try{
                PreparedStatement preparedStatement = getConnection().prepareStatement(query);
                preparedStatement.setInt(1,userId);
                ResultSet resultSet=preparedStatement.executeQuery();

                if(resultSet.next()) {
                    int id = resultSet.getInt("agent.id");
                    String nume = resultSet.getString("nume");
                    String prenume = resultSet.getString("prenume");
                    String telefon = resultSet.getString("telefon");
                    String email = resultSet.getString("email");
                    String adresa = resultSet.getString("adresa");

                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    UserType userType = UserType.valueOf(resultSet.getString("type"));
                    User user = new User(userId,username,password,userType);

                    return new Agent(id,nume,prenume,telefon,email,adresa,user);

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        return null;
    }

    public Agent save(Agent agent) {
        String query="insert into agent(nume,prenume,telefon,email,adresa,agent_user_id) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement=getConnection().prepareStatement(query);
            preparedStatement.setString(1, agent.getNume());
            preparedStatement.setString(2, agent.getPrenume());
            preparedStatement.setString(3, agent.getTelefon());
            preparedStatement.setString(4, agent.getEmail());
            preparedStatement.setString(5,agent.getAdresa());
            preparedStatement.setInt(6,agent.getUser().getId());
            preparedStatement.executeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return findByUserId(agent.getUser().getId());

    }



}
