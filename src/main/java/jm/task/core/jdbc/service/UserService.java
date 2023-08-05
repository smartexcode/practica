package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    void createUsersTable();

    void dropUsersTable();

    void saveUser(String name, String lastName, int age, String birth, String gender, String country);

    void removeUserById(long id);

    List<User> getAllUsers();

    void cleanUsersTable();
}
