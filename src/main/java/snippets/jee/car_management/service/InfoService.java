package snippets.jee.car_management.service;

import snippets.jee.car_management.dao.InfoDAO;
import snippets.jee.car_management.entity.JPAEntityFactoryBean;
import snippets.jee.car_management.rest.ws.dto.InfoDTO;
import snippets.jee.car_management.util.PageBean;

public class InfoService {

    private static InfoDAO infoDAO;

    private static JPAEntityFactoryBean entityManagerFactoryBean;

    static {
        entityManagerFactoryBean = new JPAEntityFactoryBean();
        infoDAO = new InfoDAO(entityManagerFactoryBean);
    }

    public PageBean<InfoDTO> listAllInfo(int page, int size) {
        return infoDAO.getInfos(page, size);
    }
}
