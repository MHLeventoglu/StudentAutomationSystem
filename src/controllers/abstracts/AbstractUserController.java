package controllers.abstracts;

import entities.User;
import managers.abstracts.AbstractBaseManager;

public abstract class AbstractUserController implements IController<User> {
    @Override
    public User getById(long id) {
        return null;
    }

    @Override
    public User getByUserId(long userId) {
        return AbstractBaseManager.usersList.stream()
                .filter(user -> user.getUserId() == userId)
                .findFirst()
                .orElse(null);

    }

    @Override
    public User getByMail(String mail) {
        return AbstractBaseManager.usersList.stream()
                .filter(user -> user.getMail().equals(mail))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User checkPassword(String mail, String password) {
        // Check if the email is valid
        User usr = getByMail(mail);

        if (usr == null) {
            return null;  // No user found with the provided email
        } else if (!password.equals(new String(usr.getPassword()))) {
            return null;  // Password mismatch
        }
        return usr;  // Return the user object if both email and password match
    }

}
