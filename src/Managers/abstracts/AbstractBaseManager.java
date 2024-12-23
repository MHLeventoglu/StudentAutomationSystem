package Managers.abstracts;

import Entities.User;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBaseManager<T> implements IBaseManager<T> {

    public static List<User> usersList = new ArrayList<User>();
    //Rol farketmeksizi bütün Kullanıcıların bilgilerini tutan arraylist
    public void generalAdd(User user){
        usersList.add(user);
    }

    public void generalDelete(long userId){
        boolean removed = usersList.removeIf(user -> user.getUserId() == userId);
        if (removed) {
            System.out.println("User with id \"" + userId + "\" is removed.");
        }
        else {

            System.out.println("User with id " + userId + " not found.");
        }
    }

    public List<User> getAllUsers(){
        return  usersList;
    }

    /*
    public User getUserById(){
        return
    }
    */

    @Override
    public abstract void add(T object);

    @Override
    public abstract void delete(long id);

    @Override
    public abstract void update(T object);

    @Override
    public abstract List<T> getAll();

    @Override
    public abstract T getById(long id);

    @Override
    public abstract List<T> getByName(String name);
}
