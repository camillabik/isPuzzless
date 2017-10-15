package pojo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private boolean isAdmin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmim(boolean admin) {
        isAdmin = admin;
    }

    public User(){}

    public User(int id, String name, String login, String password, boolean isAdmin) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String login, String password, boolean isAdmin) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getName() {
        return name;
    }
    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }
    @XmlElement
    public void setLogin(String login) {
        this.login = login;
    }

}
