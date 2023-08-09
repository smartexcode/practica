package jm.task.core.jdbc.dao;
/**
 * Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)
 */

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;

import static jm.task.core.jdbc.util.HibernateUtil.getSessionFactory;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {}

    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("CREATE TABLE if NOT EXISTS test (id SERIAL PRIMARY KEY," +
                "name VARCHAR(40) NULL," +
                "lastName VARCHAR(80) NULL," +
                "age int NULL CHECK (age >0 AND age < 100)," +
                "birth VARCHAR(60) NULL," +
                "gender VARCHAR(1) NULL CHECK ( gender in ('м','ж','w','m'))," +
                "country VARCHAR(100) CHECK ( country in ('Россия','Беларусь','Казахстан')))").addEntity(User.class);


        query.executeUpdate();
        session.close();
        transaction.commit();
    }



    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("DROP TABLE if EXISTS test;").addEntity(User.class);

        query.executeUpdate();
        session.close();
        transaction.commit();
    }

    @Override
    public void saveUser(String name, String lastName, int age, String birth, String gender, String country) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("INSERT INTO test(name, lastName, age, birth, gender, country) VALUES (?, ?, ?, ?, ?, ?)").addEntity(User.class);

        query.executeUpdate();
        session.close();
        transaction.commit();
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createSQLQuery("DELETE FROM test WHERE id=?");

        query.executeUpdate();
        session.close();
        transaction.commit();
    }

    @Override
    public List<User> getAllUsers() {
        return getSessionFactory().getCurrentSession().createSQLQuery("SELECT * FROM test").addEntity(User.class).list();
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("TRUNCATE TABLE test");

        query.executeUpdate();
        session.close();
        transaction.commit();
    }
}
