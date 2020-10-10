package com.vangreat.dao;

import com.vangreat.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createUser(String name, String surname, String activity, String country) {
        User user = new User(name, surname, activity, country);
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> listUsers = (List<User>) entityManager.createQuery("from User").getResultList();
        return listUsers;
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
