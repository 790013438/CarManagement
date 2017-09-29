package snippets.jee.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the car database table.
 * 
 */
@Entity
@NamedQuery(name="Car.findAll", query="SELECT c FROM Car c")
public class Car implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	private String plate;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to Info
	@OneToMany(mappedBy="car")
	private List<Info> infos;

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

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Info> getInfos() {
		return this.infos;
	}

	public void setInfos(List<Info> infos) {
		this.infos = infos;
	}

	public Info addInfo(Info info) {
		getInfos().add(info);
		info.setCar(this);

		return info;
	}

	public Info removeInfo(Info info) {
		getInfos().remove(info);
		info.setCar(null);

		return info;
	}

}