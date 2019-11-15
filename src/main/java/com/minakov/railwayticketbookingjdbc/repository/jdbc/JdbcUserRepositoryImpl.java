package com.minakov.railwayticketbookingjdbc.repository.jdbc;

import com.minakov.railwayticketbookingjdbc.model.User;
import com.minakov.railwayticketbookingjdbc.repository.UserRepository;
import com.minakov.railwayticketbookingjdbc.util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class JdbcUserRepositoryImpl implements UserRepository {

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(String s) {

    }

    @Override
    public User findById(String id) {
        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getString("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBirthday(resultSet.getDate("birthday"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User create(User user) {

        user.setId(UUID.randomUUID().toString());

        try (Connection connection = DBConnectionUtil.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?)");
            statement.setString(1, user.getId());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setDate(4, user.getBirthday(), Calendar.getInstance());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }
}
