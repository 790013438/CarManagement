package snippets.jee.car_management.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the tb_user database table.
 * 
 */
@Entity
@Table(name="tb_user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String email;

    private BigDecimal username;

    //bi-directional many-to-one association to Car
    @OneToMany(mappedBy="tbUser")
    private List<Car> tbCars;

    public User() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getUsername() {
        return this.username;
    }

    public void setUsername(BigDecimal username) {
        this.username = username;
    }

    public List<Car> getTbCars() {
        return this.tbCars;
    }

    public void setTbCars(List<Car> tbCars) {
        this.tbCars = tbCars;
    }

    public Car addTbCar(Car tbCar) {
        getTbCars().add(tbCar);
        tbCar.setTbUser(this);

        return tbCar;
    }

    public Car removeTbCar(Car tbCar) {
        getTbCars().remove(tbCar);
        tbCar.setTbUser(null);

        return tbCar;
    }

}