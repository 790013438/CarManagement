package snippets.jee.car_management.entity;

import java.io.Serializable;
import javax.persistence.*;
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

    private String username;

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

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + id;
        result = prime * result + ((tbCars == null) ? 0 : tbCars.hashCode());
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
        User other = (User) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (id != other.id)
            return false;
        if (tbCars == null) {
            if (other.tbCars != null)
                return false;
        } else if (!tbCars.equals(other.tbCars))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

}