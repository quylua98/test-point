package spring.ultra.security.demo.interceptor;

import spring.ultra.security.demo.model.Request;
import spring.ultra.security.demo.model.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements InvocationHandler {
    private Request request;

    public AuthenticationInterceptor(Request request) {
        this.request = request;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Authenticate............................................");
        if(args[0] instanceof User) {
            User user = (User) args[0];
            if(user.isLogin()) {
                System.out.println("Authentication successful!!!!!!!!!!!!!!!!!");
                Object result = method.invoke(request, args);
                System.out.println("The key is " + result + "!!!!!!!!!!!!!!!!!");
                return result;
            }
        }
        System.out.println("Authentication failXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        return null;
    }
}
