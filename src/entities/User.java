package entities;

public class User extends BaseEntity {
    private long userId; // Bu genel kullanıcı id sini tutar
    private static long lastUserId = 0; //bu da son kullanılan kullanıcı id'sini tutar
    private String mail;
    private String username;
    private String password;
    private String role; // Student, Lecturer gibi rolleri tutabilir.

    // constructorlar
    public User(long id, String username, String password, String role, String mail) {
        super(id);
        this.userId = ++lastUserId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.mail = mail;
    }

    public String getMail(){return mail;}
    public void setMail (String mail){this.mail = mail;}

    public long getUserId(){return userId;}

    public void setUserId(long userId){this.userId = userId;}

    public String getName(){ return username; }

    public void setName(String username){ this.username = username; }

    public String getPassword(){ return password; }

    public void setPassword(String password){ this.password = password; }

    public String getRole(){ return role; }

    public void setRole(String role){ this.role = role; }

}
