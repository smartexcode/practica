package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    Util util = new Util();
    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        try (Statement statement = util.getConnection().createStatement()){
            statement.execute("CREATE TABLE if NOT EXISTS USER (id bigint auto_increment, name VARCHAR(40) NULL, lastName VARCHAR(40) NULL, age int NULL,birth VARCHAR(40) NULL,gender VARCHAR(1) NULL,country VARCHAR(40) NULL , CONSTRAINT table_name_pk PRIMARY KEY (id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = util.getConnection().createStatement()){
            statement.execute("DROP TABLE if EXISTS user;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, int age, String birth, String gender, String country) {
        String request = "INSERT INTO user(name, lastName, age, birth, gender, country) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, birth);
            preparedStatement.setString(5,gender);
            preparedStatement.setString(6, country);
            preparedStatement.executeUpdate();
            System.out.printf("User с именем – %s добавлен в базу данных\r\n",name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String request = "DELETE FROM user WHERE id=?";
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement(request)){
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Statement statement = util.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getInt("age"));
                user.setBirth(resultSet.getString("birth"));
                user.setGender(resultSet.getString("gender"));
                user.setCountry(resultSet.getString("country"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    public void cleanUsersTable() {
        try (Statement statement = util.getConnection().createStatement()){
            statement.execute("TRUNCATE TABLE user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
