package snippets.jee.car_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;
import snippets.jee.car_management.util.PageBean;

@Component
public class InfoService {

    @Autowired
    private static InfoDAO infoDAO;

    public PageBean<InfoDTO> listAllInfo(int page, int size) {
        return infoDAO.getInfos(page, size);
    }
}
