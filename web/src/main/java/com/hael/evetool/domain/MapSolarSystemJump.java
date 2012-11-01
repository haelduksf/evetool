package com.hael.evetool.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the mapsolarsystemjumps database table.
 * 
 */
@Entity
@Table(name = "mapsolarsystemjumps")
@NamedQueries({
	@NamedQuery(name = "SolarSystem.getNeighbours", query = "SELECT s.solarSystemName FROM MapSolarSystem s WHERE s.solarSystemID IN (SELECT d.toSolarSystemID from MapSolarSystemJump d WHERE d.fromSolarSystemID = (SELECT f.solarSystemID FROM MapSolarSystem f WHERE f.solarSystemName=:from))"),
	@NamedQuery(name = "SolarSystem.getNeighboursID", query = "SELECT d.toSolarSystemID from MapSolarSystemJump d WHERE d.fromSolarSystemID=:from") 
})
public class MapSolarSystemJump implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int fromSolarSystemID;
	@Id
	private int toSolarSystemID;

	public MapSolarSystemJump() {
	}

	public void setToSolarSystemID(int toSolarSystemID) {
		this.toSolarSystemID = toSolarSystemID;
	}

	public int getToSolarSystemID() {
		return toSolarSystemID;
	}

	public void setFromSolarSystemID(int fromSolarSystemID) {
		this.fromSolarSystemID = fromSolarSystemID;
	}


	public int getFromSolarSystemID() {
		return fromSolarSystemID;
	}

}