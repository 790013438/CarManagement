package snippets.jee.car_management.rest.ws.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;

@Path("/info")
public class InfoService1 {

    private InfoDAO infoDAO;

    @Autowired
    private @Qualifier("jpaEntityFactoryBean") JPAEntityFactoryBean jpaEntityFactoryBean;

    @PostConstruct
    public void init() {
        infoDAO = new InfoDAO(jpaEntityFactoryBean.getEntityManagerFactory());
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("getlist")
    public List<InfoDTO> getInfo () {
        return infoDAO.getInfos();
    }

    public InfoDAO getInfoDAO() {
        return infoDAO;
    }

    @Autowired
    public void setInfoDAO(InfoDAO infoDAO) {
        this.infoDAO = infoDAO;
    }

    public JPAEntityFactoryBean getJpaEntityFactoryBean() {
        return jpaEntityFactoryBean;
    }

    @Autowired
    public void setJpaEntityFactoryBean(@Qualifier("jpaEntityFactoryBean") JPAEntityFactoryBean jpaEntityFactoryBean) {
        this.jpaEntityFactoryBean = jpaEntityFactoryBean;
    }
}