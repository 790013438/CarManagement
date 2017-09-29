package snippets.jee.car_management.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tb_car database table.
 * 
 */
@Entity
@Table(name="tb_car")
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="carname")
    private String name;

    @Column(name="carplate")
    private String plate;

    //bi-directional many-to-one association to User
    @ManyToOne
    @JoinColumn(name="tb_user_id")
    private User tbUser;

    //bi-directional many-to-one association to Info
    @OneToMany(mappedBy="car")
    private List<Info> tbInfos;

    public Car() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public User getTbUser() {
        return this.tbUser;
    }

    public void setTbUser(User tbUser) {
        this.tbUser = tbUser;
    }

    public List<Info> getTbInfos() {
        return this.tbInfos;
    }

    public void setTbInfos(List<Info> tbInfos) {
        this.tbInfos = tbInfos;
    }

    public Info addTbInfo(Info tbInfo) {
        getTbInfos().add(tbInfo);
        tbInfo.setCar(this);

        return tbInfo;
    }

    public Info removeTbInfo(Info tbInfo) {
        getTbInfos().remove(tbInfo);
        tbInfo.setCar(null);

        return tbInfo;
    }

}