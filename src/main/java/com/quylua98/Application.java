package com.quylua98;

import com.quylua98.config.ControllerLogger;
import com.quylua98.config.annotation.CustomTransactional;
import com.quylua98.entity.User;
import com.quylua98.repo.UserRepo;
import com.quylua98.service.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;


@SpringBootApplication
@RestController
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	CGLIBService cglibService;

	@Autowired
	JDKDynamicProxyService jDKDynamicProxyService;

	@Autowired
	LogService logService;

	@Autowired
	UserRepo userRepo;

	@Autowired
	EntityManager entityManager;

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Bean("customEntityManager")
	public EntityManager customEntityManager() {
		return entityManagerFactory.createEntityManager();
	}

	@Autowired
	@Qualifier("customEntityManager")
	EntityManager customEntityManager;

	@GetMapping("/")
	public void asd() {
		cglibService.out(cglibService.getClass().toString());
		jDKDynamicProxyService.out(jDKDynamicProxyService.getClass().toString());
		logService.out(logService.getClass().toString());
//
//		User user = userRepo.findById(1L).orElse(null);
//		System.out.println(user.getName());
	}

	@GetMapping("/saveUser")
	@Transactional
//	@CustomTransactional
	public void save() {
		User user = new User();
		user.setId(2L);
		user.setName("Abc");
//		userRepo.save(user);
//		entityManager.persist(user);
		customEntityManager.persist(user);
	}

}
