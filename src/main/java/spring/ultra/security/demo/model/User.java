package spring.ultra.security.demo.model;

import lombok.Getter;
import lombok.Setter;

public class User {
    private boolean login;
    public User(boolean isLogin){
     login = isLogin;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
