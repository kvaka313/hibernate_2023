package ua.unicyb;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transaction;
import ua.unicyb.dao.UserDao;
import ua.unicyb.dao.impl.UserDaoImpl;
import ua.unicyb.entities.User;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("first-unit");


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserDao userDao = new UserDaoImpl(entityManager);
        User user = new User();
        user.setFirstName("Vasya");
        user.setLastName("Pupkin");
        user.setBalance(1100);
        EntityTransaction tr = entityManager.getTransaction();
        tr.begin();
        userDao.saveUser(user);
        tr.commit();
        User returnedUser = userDao.getUserById(user.getId());
        System.out.println(returnedUser.getId());
        entityManager.close();
    }
}
