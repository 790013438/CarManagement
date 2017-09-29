package snippets.jee.car_management.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the info database table.
 * 
 */
@Entity
@NamedQuery(name="Info.findAll", query="SELECT i FROM Info i")
public class Info implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String date;

	private byte process;

	private String punish;

	private String reason;

	//bi-directional many-to-one association to Car
	@ManyToOne
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

	public byte getProcess() {
		return this.process;
	}

	public void setProcess(byte process) {
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

	public void setCar(Car car) {
		this.car = car;
	}

}