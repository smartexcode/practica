package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserDao {
    void createUsersTable();

    void dropUsersTable();

    long saveUser(String name, String lastName, int age, String birth, String gender, String country);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
