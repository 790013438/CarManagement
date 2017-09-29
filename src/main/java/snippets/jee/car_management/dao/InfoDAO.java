package snippets.jee.car_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import snippets.jee.car_management.entity.Info;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;

@Component
public class InfoDAO {

    @Autowired
    JPAEntityFactoryBean entityFactoryBean;

    public List<Info> getInfos() {
        //Get entity manager
        EntityManagerFactory entityManagerFactory = entityFactoryBean.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<Info> infoTypeQuery = entityManager.createNamedQuery("Info.findAll", Info.class);
        List<Info> infos = infoTypeQuery.getResultList();
        entityManager.close();
        return infos;
    }
}
