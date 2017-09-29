package snippets.jee.car_management.rest.ws;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class CarMgmtRESTApplication extends ResourceConfig {

    public CarMgmtRESTApplication () {
        packages("snippets.jee.car_management.rest.ws.services");
    }
}
