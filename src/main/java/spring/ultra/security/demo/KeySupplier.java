package spring.ultra.security.demo;

import spring.ultra.security.demo.model.User;

public interface KeySupplier {
    String getPrivateKey(User user);
}
