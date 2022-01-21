package entities;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Smartphone
 *
 */

@Entity
public class Smartphone implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long imei;
	private String marque;
	@ManyToOne
	private User user;
	@Transient
	@OneToMany(mappedBy = "smartphone", fetch = FetchType.EAGER)
	private List<Position> positions;
	private static final long serialVersionUID = 1L;

	public Smartphone() {
		super();
		user = new User();
	}

	public Smartphone(int imei, String marque, User u) {
		super();
		this.imei = imei;
		this.marque = marque;
		this.user = u;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getImei() {
		return this.imei;
	}

	public void setImei(long imei) {
		this.imei = imei;
	}

	public String getMarque() {
		return this.marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

}
