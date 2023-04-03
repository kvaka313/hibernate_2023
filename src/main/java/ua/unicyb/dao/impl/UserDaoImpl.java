package ua.unicyb.dao.impl;

import jakarta.persistence.EntityManager;
import ua.unicyb.dao.UserDao;
import ua.unicyb.entities.User;

public class UserDaoImpl implements UserDao {
    private EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
        em.flush();
    }

    public User getUserById(Long id) {
        return em.find(User.class, id);// SELECT * FROM periodic_user WHERE id = usr.getId()
    }


}
