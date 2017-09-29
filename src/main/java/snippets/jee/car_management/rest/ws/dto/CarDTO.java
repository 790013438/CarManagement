package snippets.jee.car_management.dto;

import javax.xml.bind.annotation.XmlRootElement;

import snippets.jee.car_management.entity.User;

@XmlRootElement
public class CarDTO {

    private int id;

    private String name;

    private String plate;

    private User tbUser;

    public CarDTO() {
    }

    public CarDTO(int id, String name, String plate, User tbUser) {
        this.id = id;
        this.name = name;
        this.plate = plate;
        this.tbUser = tbUser;
    }

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

    public User getTbUser() {
        return tbUser;
    }

    public void setTbUser(User tbUser) {
        this.tbUser = tbUser;
    }
}
