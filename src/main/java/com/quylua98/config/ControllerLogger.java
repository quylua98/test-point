package com.quylua98.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ControllerLogger {

    @Before("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void beforeAdvice(){
        System.out.println("Receive a get request.");
    }
}
