package web.dao;

import web.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void update(long id, User updatedUser) {
        User userOnUpdate = entityManager.find(User.class, id);
        userOnUpdate.setFirstName(updatedUser.getFirstName());
        userOnUpdate.setLastName(updatedUser.getLastName());
        userOnUpdate.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User getUserById (long id){
        return entityManager.find(User.class, id);
    }


}
