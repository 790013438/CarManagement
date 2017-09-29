package snippets.jee.car_management.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import snippets.jee.car_management.entity.Info;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;

@Component
public class InfoDAO {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public InfoDAO (JPAEntityFactoryBean entityFactoryBean) {
        entityManagerFactory = entityFactoryBean.getEntityManagerFactory();
    }

    public List<Info> getInfos() {
        //Get entity manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<Info> infoTypeQuery = entityManager.createNamedQuery("Info.findAll", Info.class);
        List<Info> infos = infoTypeQuery.getResultList();
        entityManager.close();
        return infos;
    }

    public void addInfo (Info info) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(info);
        entityTransaction.commit();
    }

    public void updateInfo (Info info) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(info);
        entityTransaction.commit();
    }

    public Info getCourse (int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Info.class, id);
    }

    public void deleteInfo (Info info) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Info mergedInfo = entityManager.find(Info.class, info.getId());
        entityManager.remove(mergedInfo);
        entityTransaction.commit();
    }
}
