package snippets.jee.car_management.rest.ws.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import snippets.jee.car_management.entity.Car;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoDTO {

    private int id;

    private String username;

    private String carplate;

    private String date;

    private String process;

    private String punish;

    private String reason;

    private Car car;
    
    public InfoDTO() {
    }

    public InfoDTO(int id, String date, String process, String punish, String reason, Car tbCar) {
        this.id = id;
        this.date = date;
        this.process = process;
        this.punish = punish;
        this.reason = reason;
        this.car = tbCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car tbCar) {
        this.car = tbCar;
    }
}
