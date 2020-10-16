package it.beije.hiketracker.entitybeans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="routes")
public class Route {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idRoute")
	private Integer idRoute;
	
	@ManyToOne
	@JoinColumn(name = "idTransport")
	private Transport transport;
	
	@ManyToOne
	@JoinColumn(name = "idUser")
	private User user;
	
	@Column
	private String start;
	
	@Column
	private LocalDateTime startDateTime;
	
	@Column
	private String finish;
	
	@Column
	private LocalDateTime finishDateTime;
	
	@Column
	private String fullRoute;
	
	public Route() {}

	public Integer getIdRoute() {
		return idRoute;
	}

	public void setIdRoute(Integer idRoute) {
		this.idRoute = idRoute;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = LocalDateTime.parse(startDateTime);
	}

	public String getFinish() {
		return finish;
	}

	public void setFinish(String finish) {
		this.finish = finish;
	}

	public LocalDateTime getFinishDateTime() {
		return finishDateTime;
	}

	public void setFinishDateTime(LocalDateTime finishDateTime) {
		this.finishDateTime = finishDateTime;
	}
	
	public void setFinishDateTime(String finishDateTime) {
		this.finishDateTime = LocalDateTime.parse(finishDateTime);
	}

	public String getFullRoute() {
		return fullRoute;
	}

	public void setFullRoute(String fullRoute) {
		this.fullRoute = fullRoute;
	}

	@Override
	public String toString() {
		return "Route [idRoute=" + idRoute + ", transport=" + transport + ", user=" + user + ", start=" + start
				+ ", finish=" + finish + "]";
	}
}