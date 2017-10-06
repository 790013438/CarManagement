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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCarplate() {
        return carplate;
    }

    public void setCarplate(String carplate) {
        this.carplate = carplate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((carplate == null) ? 0 : carplate.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + id;
        result = prime * result + ((process == null) ? 0 : process.hashCode());
        result = prime * result + ((punish == null) ? 0 : punish.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InfoDTO other = (InfoDTO) obj;
        if (car == null) {
            if (other.car != null)
                return false;
        } else if (!car.equals(other.car))
            return false;
        if (carplate == null) {
            if (other.carplate != null)
                return false;
        } else if (!carplate.equals(other.carplate))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (id != other.id)
            return false;
        if (process == null) {
            if (other.process != null)
                return false;
        } else if (!process.equals(other.process))
            return false;
        if (punish == null) {
            if (other.punish != null)
                return false;
        } else if (!punish.equals(other.punish))
            return false;
        if (reason == null) {
            if (other.reason != null)
                return false;
        } else if (!reason.equals(other.reason))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }
}
