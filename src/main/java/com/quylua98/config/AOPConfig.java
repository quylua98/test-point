package com.quylua98.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Aspect
@Component
public class AOPConfig {

    @Autowired
    @Qualifier("customEntityManager")
    EntityManager customEntityManager;

    @Pointcut("@annotation(com.quylua98.config.annotation.Log)")
    public void log() {
    }

    @Pointcut("@annotation(com.quylua98.config.annotation.CustomTransactional)")
    public void transactional() {
    }

    @Around("log()")
    public Object doLogIntercept(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Start log");
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("End log");
        }
    }

    @Around("transactional()")
    public Object doTransactionalIntercept(ProceedingJoinPoint joinPoint) throws Throwable {
        EntityTransaction tx = null;
        try {
            tx = customEntityManager.getTransaction();
            tx.begin();
            System.out.println("Transactional begin");

            Object result = joinPoint.proceed();
            tx.commit();
            return result;
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getMessage());
            if (tx != null) {
                tx.rollback();
                System.out.println("Transaction rollback");
            }
            throw ex;
        } finally {
            customEntityManager.flush();
            customEntityManager.clear();
            customEntityManager.close();
            System.out.println("Transactional close");
        }
    }

}
