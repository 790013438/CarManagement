package snippets.jee.car_management.rest.ws.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;

@Path("/info")
public class InfoService {

    private InfoDAO infoDAO;

    @PostConstruct
    public void init(InfoDAO infoDAO) {
        this.infoDAO = infoDAO;
    }

    @GET
    @Produces (MediaType.APPLICATION_JSON)
    @Path("getlist")
    public List<InfoDTO> getInfo () {
        return infoDAO.getInfos();
    }
}
