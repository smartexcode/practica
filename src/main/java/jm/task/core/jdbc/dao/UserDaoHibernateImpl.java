package jm.task.core.jdbc.dao;
/**
 * Класс UserHibernateDaoImpl в рамках этой задачи не затрагивается (остаётся пустой)
 */

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {}

    @Override
    public void createUsersTable() {}

    @Override
    public void dropUsersTable() {

    }

    @Override
    public long saveUser(String name, String lastName, int age, String birth, String gender, String country) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            User user = new User();
            user.setName(name);
            user.setLastName(lastName);
            user.setAge(age);
            user.setBirth(birth);
            user.setGender(gender);
            user.setCountry(country);

            long id = (Long) session.save(user);

            transaction.commit();

            return id;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void removeUserById(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();


            User user = session.find(User.class, id);
            session.delete(user);

            transaction.commit();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public List<User> getAllUsers() {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();


            return (List<User>) session.createQuery("from User").list();


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public void cleanUsersTable() {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String sql = "TRUNCATE TABLE test";
            session.createSQLQuery(sql).executeUpdate();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

    }
}