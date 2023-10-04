package web.dao;


import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        entityManager.persist(user);
    }



    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void update(long oldId, User newUser) {
        System.out.println(oldId);
        User oldUser = entityManager.find(User.class, oldId);
        oldUser.clone(newUser);
    }
    @Override
    @Transactional
    public void removeUserById(long id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }
}
