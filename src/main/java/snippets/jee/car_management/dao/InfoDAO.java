package snippets.jee.car_management.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import snippets.jee.car_management.entity.Car;
import snippets.jee.car_management.entity.Info;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;
import snippets.jee.car_management.entity.User;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;
import snippets.jee.car_management.util.PageBean;

@Component
@Service
@Configurable
@Qualifier("infoDAO")
public class InfoDAO {

    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private JPAEntityFactoryBean jpaEntityFactoryBean;

    @PostConstruct
    public void init() {
        entityManagerFactory = jpaEntityFactoryBean.getEntityManagerFactory();
    }

    public List<Info> getInfoEntities() {
        //Get entity manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<Info> infoTypeQuery = entityManager.createNamedQuery("Info.findInfo", Info.class);
        List<Info> infos = infoTypeQuery.getResultList();
        entityManager.close();
        return infos;
    }

    public List<InfoDTO> getInfos() {
        //get Info entities first
        List<Info> infoEntities = getInfoEntities();

        //Create list of info DTOs. This is the result we will return
        List<InfoDTO> infos = new ArrayList<InfoDTO>();

        for (Info infoEntity : infoEntities) {
            //Create InfoDTO from Info entity
            InfoDTO infoDTO = new InfoDTO();
            infoDTO.setId(infoEntity.getId());
            infoDTO.setDate(infoEntity.getDate());
            infoDTO.setProcess(infoEntity.getProcess());
            infoDTO.setPunish(infoEntity.getPunish());
            infoDTO.setReason(infoEntity.getReason());
            infos.add(infoDTO);

            Car car = infoEntity.getCar();
            //check whether car was null in the table
            if (null == car) {
                //on car set for this info
                continue;
            }
            infoDTO.setCar(infoEntity.getCar());
            infoDTO.setCarplate(infoEntity.getCar().getPlate());

            User user = car.getTbUser();
            //check whether user was null in the table
            if (null == user) {
                //on user set for this info
                continue;
            }
            infoDTO.setUsername(user.getUsername());
        }
        return infos;
    }

    public PageBean<InfoDTO> getInfos (int page, int size) {
        List<InfoDTO> list = getInfos();
        int listSize = list.size();
        int totalPage = (listSize - 1) / size + 1;
        if (listSize == 0) {
            return new PageBean<>(Collections.emptyList(), totalPage, page, size);
        }
        int startIndex = (page - 1) * size;
        if (startIndex + size > listSize) {
            return new PageBean<>(list.subList(startIndex, listSize), totalPage, page, size);
        }
        list = listSize > 5 ? list.subList(startIndex, startIndex + size) : list;
        return new PageBean<>(list, totalPage, page, size);
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

    public Info getInfo (int id) {
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
