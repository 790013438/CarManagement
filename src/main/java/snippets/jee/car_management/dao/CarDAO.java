package snippets.jee.car_management.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import snippets.jee.car_management.entity.Car;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;

public class CarDAO {

    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private JPAEntityFactoryBean jpaEntityFactoryBean;

    @PostConstruct
    public void init() {
        entityManagerFactory = jpaEntityFactoryBean.getEntityManagerFactory();
    }

    public List<Car> getCarEntities() {
        //Get entity manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<Car> infoTypeQuery = entityManager.createNamedQuery("Car.findAll", Car.class);
        List<Car> cars = infoTypeQuery.getResultList();
        entityManager.close();
        return cars;
    }

}
