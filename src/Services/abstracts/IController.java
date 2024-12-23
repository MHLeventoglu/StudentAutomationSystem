package Services.abstracts;

import Entities.User;
import Managers.abstracts.AbstractBaseManager;

import java.util.List;

//managers package'ı Database manipülasyonlarını tutuyorken
//services package'ı Her bir User tipi için api controllerı görevi görüyor
public interface IController<T> {
    public List<User> list = AbstractBaseManager.usersList;
    public T getById(long id);
    public T getByUserId(long userId);
    public T getByMail(String mail);
    public User checkPassword(String mail, String password);
}
