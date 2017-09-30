package snippets.jee.car_management.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.dto.InfoDTO;

@Path("/info")
@Component
public class InfoService1 {

    @Autowired
    private @Qualifier("infoDAO") InfoDAO infoDAO;

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
    public void setInfoDAO(@Qualifier("infoDAO") InfoDAO infoDAO) {
        this.infoDAO = infoDAO;
    }
}