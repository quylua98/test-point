package spring.ultra.security.demo;

import spring.ultra.security.demo.interceptor.AuthenticationInterceptor;
import spring.ultra.security.demo.model.Request;
import spring.ultra.security.demo.model.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        Request request = new Request();
        InvocationHandler handler = new AuthenticationInterceptor(request);
        Object proxy = Proxy.newProxyInstance(Application.class.getClassLoader(), new Class[] { KeySupplier.class }, handler);
        KeySupplier proxyRequest = (KeySupplier) proxy;
        User user = new User(false);
        proxyRequest.getPrivateKey(user);
    }
}
