package org.numisoft.webmodule;

import org.numisoft.ejbmodule.User;
import org.numisoft.ejbmodule.UserDao;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kukolka on 04.07.16.
 */

@ManagedBean
public class UserController implements Serializable{

    @EJB
    UserDao userDao;

    private String first_name;
    private String last_name;
    private String password;

    private List<User> users = new ArrayList<User>();

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getUsers() {
        users = userDao.getAllUsers();
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


    public void persistUser(){
        User user = new User(this.first_name, this.last_name, this.password);
        userDao.persistUser(user);
    }

    public void removeUser(int id){
        userDao.removeUser(id);
    }

}
