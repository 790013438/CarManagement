package snippets.jee.car_management.servlet;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;

import snippets.jee.car_management.service.InfoService;
import snippets.jee.car_management.service.ServiceFactory;

@Controller
public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * 获取用户业务对象
     */
    protected InfoService getInfoService() {
        return ServiceFactory.create(InfoService.class);
    }

}
