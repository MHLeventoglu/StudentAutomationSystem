package Entities;

import java.time.LocalDateTime;

public class User extends BaseEntity {
    private String username;
    private String password;
    private String role; // Student, Lecturer, Admin gibi rolleri tutabilir.

    // constructor
    public User(long id, String username, String password, String role) {
        super(id);
        this.username = username;
        this.password = password;
        this.role = role;
    }


    public String getName(){ return username; }

    public void setName(String username){ this.username = username; }

    public String getPassword(){ return password; }

    public void setPassword(String password){ this.password = password; }

    public String getRole(){ return role; }

    public void setRole(String role){ this.role = role; }

}
