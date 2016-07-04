package org.numisoft.ejbmodule;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by alku0116 on 22.06.2016.
 */

@Stateless
public class UserDao implements Serializable {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("mypu");
    EntityManager em = factory.createEntityManager();

    public UserDao() {
    }

    public List<User> getAllUsers() {
        System.out.println(">>UserDao>>getAllUsers");
        Query q = em.createQuery("SELECT x FROM User x");
        return (List<User>) q.getResultList();
    }

    public void persistUser(User user) {
        System.out.println(">>UserDao>>persistUser");
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void removeUser(int id) {
        System.out.println(">>UserDao>>removeUser");
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }

}
