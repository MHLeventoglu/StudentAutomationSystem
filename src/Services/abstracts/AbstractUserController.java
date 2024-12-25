package Services.abstracts;

import Entities.User;
import Managers.abstracts.AbstractBaseManager;

public abstract class AbstractUserController<T> implements IController<T> {
    @Override
    public T getById(long id) {
        return null;
    }

    @Override
    public T getByUserId(long userId) {
        return null;
    }

    @Override
    public T getByMail(String mail) {
        return null;
    }

    @Override
    public User checkPassword(String mail, String password) {
        //eğer şifre doğruysa kullanıcı nesnesini döndürür
        User usr = AbstractBaseManager.usersList.stream()
                .filter(user -> user.getMail() == mail)
                .findFirst()
                .orElse(null);
        if (usr==null){
            return null;
        }else if (password != usr.getPassword()){
            return null;
        }
        return usr;
    }
}
