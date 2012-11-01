package com.hael.evetool.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * SolarSystem represents an Eve Online solar system.
 * 
 * @author alecross
 * 
 */
public class SolarSystem implements Comparable<SolarSystem>, Serializable {

	private static final long serialVersionUID = 1L;
	private MapSolarSystem mapSolarSystem;
	private List<SolarSystem> neighbours = new ArrayList<SolarSystem>();

	/**
	 * Constructs a SolarSystem based on its db entry.
	 * 
	 * @param mapSolarSystem
	 *            the DB entry describing this solar system
	 */
	public SolarSystem(MapSolarSystem mapSolarSystem) {
		this.mapSolarSystem = mapSolarSystem;
	}

	@SuppressWarnings("unused")
	private SolarSystem() {
	}

	/**
	 * The string representation of this solar system (ie its name).
	 * 
	 * @return a string representation of this solar system
	 */
	public String toString() {
		return this.getName();
	}

	/**
	 * The name of this solar system.
	 * 
	 * @return the name of this solar system
	 */
	@XmlElement
	public String getName() {
		return mapSolarSystem.getSolarSystemName();
	}
	
	public void setName(String name) {
		if (mapSolarSystem == null) {
			mapSolarSystem = new MapSolarSystem();
		}
		this.mapSolarSystem.setSolarSystemName(name);
	}

	/**
	 * The unique ID of this solar system.
	 * 
	 * @return this solar system's ID number
	 */
	@XmlElement
	public int getSolarSystemID() {
		return mapSolarSystem.getSolarSystemID();
	}
	
	public void setSolarSystemID(int id) {
		if (mapSolarSystem == null) {
			mapSolarSystem = new MapSolarSystem();
		}
		this.mapSolarSystem.setSolarSystemID(id);
	}

	/**
	 * Gets a list of the solar systems reachable from this one.
	 * 
	 * @return a list of adjacent solar systems
	 */
	@XmlTransient
	public List<SolarSystem> getNeighbours() {
		return neighbours;
	}

	/**
	 * Sets the list of solar systems reachable from this one.
	 * 
	 * @param neighbours
	 *            the adjacent solar systems
	 */
	public void setNeighbours(List<SolarSystem> neighbours) {
		this.neighbours = neighbours;
	}

	/**
	 * The names of the neighbouring systems. Partly for convenience, and partly
	 * because undirected graphs don't convert well to XML.
	 * 
	 * @return a list of the names of all the systems reachable from this one
	 */
	@XmlElement
	public List<String> getNeighbourNames() {
		List<String> names = new ArrayList<String>();
		for (SolarSystem s : this.getNeighbours()) {
			names.add(s.getName());
		}
		return names;
	}
	
	@Override
	public int compareTo(SolarSystem o) {

		return this.getSolarSystemID() - o.getSolarSystemID();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.getName() == null) ? 0 : this.getName().hashCode());
		result = prime * result + getSolarSystemID();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SolarSystem other = (SolarSystem) obj;
		return this.getSolarSystemID() == other.getSolarSystemID() || this.getName().equals(
				other.getName());
	}
	
	/**
	 * Add a single neighbour to this system's list of neighbours.
	 * @param neighbour a new adjacent system
	 */
	public void addNeighbour(SolarSystem neighbour) {
		this.neighbours.add(neighbour);

	}

}
