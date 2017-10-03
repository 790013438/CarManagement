package snippets.jee.car_management.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_info database table.
 * 
 */
@Entity
@Table(name="tb_info")
@NamedQueries({
    @NamedQuery(name="Info.findAll", query="SELECT i FROM Info i"),
    @NamedQuery(name="Info.findInfo", query="SELECT i FROM Info i LEFT OUTER JOIN FETCH i.car")
})
public class Info implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="idate")
    private String date;

    @Column(name="iprocess")
    private String process;

    @Column(name="ipunish")
    private String punish;

    @Column(name="ireason")
    private String reason;

    //bi-directional many-to-one association to Car
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;

    public Info() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProcess() {
        return this.process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getPunish() {
        return this.punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car tbCar) {
        this.car = tbCar;
    }

}