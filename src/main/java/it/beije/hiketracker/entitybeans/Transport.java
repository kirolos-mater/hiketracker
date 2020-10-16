package it.beije.hiketracker.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="transports")
public class Transport {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTransport")
	private Integer idTransport;
	
	@Column
	private String type;
	
	@Column
	private String licensePlate;
	
	public Transport() {}

	public Integer getIdTransport() {
		return idTransport;
	}

	public void setIdTransport(Integer idTransport) {
		this.idTransport = idTransport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "Transport [type=" + type + ", licensePlate=" + licensePlate + "]";
	}
}