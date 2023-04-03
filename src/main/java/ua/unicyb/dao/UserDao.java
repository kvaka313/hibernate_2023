package ua.unicyb.dao;

import ua.unicyb.entities.User;

public interface UserDao {
    void saveUser(User user);

    User getUserById(Long id);
}
