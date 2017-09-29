package snippets.jee.car_management.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import snippets.jee.car_management.entity.Car;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoDTO {

    private int id;

    private String date;

    private String process;

    private String punish;

    private String reason;

    private Car tbCar;
    
    public InfoDTO() {
    }

    public InfoDTO(int id, String date, String process, String punish, String reason, Car tbCar) {
        this.id = id;
        this.date = date;
        this.process = process;
        this.punish = punish;
        this.reason = reason;
        this.tbCar = tbCar;
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

    public Car getTbCar() {
        return tbCar;
    }

    public void setTbCar(Car tbCar) {
        this.tbCar = tbCar;
    }
}
