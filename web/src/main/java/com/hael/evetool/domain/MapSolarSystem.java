package com.hael.evetool.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the mapsolarsystems database table.
 * 
 */
@Entity
@Table(name = "mapsolarsystems")
@NamedQueries({
		@NamedQuery(name = "SolarSystem.isReal", 
				query = "SELECT s FROM MapSolarSystem s WHERE s.solarSystemName=:name"),
		@NamedQuery(name = "SolarSystem.nameLookup", 
				query = "SELECT s.solarSystemName FROM MapSolarSystem s WHERE s.solarSystemName LIKE :name"),
		@NamedQuery(name = "getSolarSystems", 
				query = "SELECT s FROM MapSolarSystem s"),
		@NamedQuery(name = "SolarSystem.getSolarSystemFromName", 
				query = "SELECT s FROM MapSolarSystem s WHERE s.solarSystemName = :name"),
		@NamedQuery(name = "SolarSystem.getSolarSystemFromId", 
				query = "SELECT s FROM MapSolarSystem s WHERE s.solarSystemID = :id") })
public class MapSolarSystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int solarSystemID;

	private String solarSystemName;

	public MapSolarSystem() {
	}

	public int getSolarSystemID() {
		return this.solarSystemID;
	}

	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
	}

	public String getSolarSystemName() {
		return this.solarSystemName;
	}

	public void setSolarSystemName(String solarSystemName) {
		this.solarSystemName = solarSystemName;
	}

}