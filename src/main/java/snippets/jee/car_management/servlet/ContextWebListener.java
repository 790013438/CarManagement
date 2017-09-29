package snippets.jee.car_management.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

import snippets.jee.car_management.dao.InfoDAO;

@WebListener
public class ContextWebListener implements ServletContextListener {

    @SuppressWarnings("unused")
    @Autowired
    private InfoDAO infoDAO;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
