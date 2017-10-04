package snippets.jee.car_management.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import snippets.jee.car_management.entity.JPAEntityFactoryBean;
import snippets.jee.car_management.entity.User;
import snippets.jee.car_management.rest.ws.dto.UserDTO;

@Component
@Service
@Configurable
@Qualifier("infoDAO")
public class UserDAO {

    private EntityManagerFactory entityManagerFactory;
    @Autowired
    private JPAEntityFactoryBean jpaEntityFactoryBean;

    @PostConstruct
    public void init() {
        entityManagerFactory = jpaEntityFactoryBean.getEntityManagerFactory();
    }

    public List<User> getUserEntities () {
        //Get entity manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Execute Query
        TypedQuery<User> userTypedQuery = entityManager.createNamedQuery("User.findAll", User.class);
        List<User> users = userTypedQuery.getResultList();
        entityManager.close();
        return users;
    }

    public List<UserDTO> getUsers() {
        //get user entities first
        List<User> userEntities = getUserEntities();
        
        //Create list of user DTO. This is the result we will return
        List<UserDTO> users = new ArrayList<UserDTO>();

        for (User userEntity : userEntities) {
            //Create UserDTO from User entity
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userEntity.getId());
            userDTO.setUsername(userEntity.getUsername());
            users.add(userDTO);
        }
        return users;
    }
}
