package snippets.jee.car_management.entity;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class JPAEntityFactoryBean {

    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("CarManagement");
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
