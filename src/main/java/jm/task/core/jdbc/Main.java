package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * В методе main класса Main должны происходить следующие операции:
 *  1. Создание таблицы User(ов)
 *  2. Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль ( User с именем – name добавлен в базу данных )
 *  3. Получение всех User из базы и вывод в консоль ( должен быть переопределен toString в классе User)
 *  4. Очистка таблицы User(ов)
 *  5. Удаление таблицы
 */
public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Jason", "Bourne", 32);
        userService.saveUser("Foma", "Kiniaev", 53);
        userService.saveUser("James", "Gosling", 67);
        userService.saveUser("Elon", "Musk", 51);

        userService.getAllUsers();

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
