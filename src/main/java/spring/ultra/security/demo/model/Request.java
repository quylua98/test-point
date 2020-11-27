package spring.ultra.security.demo.model;

import spring.ultra.security.demo.KeySupplier;

public class Request implements KeySupplier {
    public String getPrivateKey(User user) {
        return "quylua98";
    }
}
