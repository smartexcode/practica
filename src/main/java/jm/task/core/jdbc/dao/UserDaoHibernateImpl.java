package jm.task.core.jdbc.dao;
/**
 * Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)
 */

import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, int age, String birth, String gender, String country) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
