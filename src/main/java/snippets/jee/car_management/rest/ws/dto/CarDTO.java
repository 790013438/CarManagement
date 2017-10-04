package snippets.jee.car_management.rest.ws.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import snippets.jee.car_management.entity.Info;
import snippets.jee.car_management.entity.User;

@XmlRootElement
public class CarDTO {

    private int id;
    private String name;
    private String plate;
    private User user;
    private List<Info> infos;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlate() {
        return plate;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Info> getInfos() {
        return infos;
    }
    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }
}
