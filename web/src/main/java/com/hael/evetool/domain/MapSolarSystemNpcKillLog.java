package com.hael.evetool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



/**
 * The persistent class for the mapsolarsystemnpckilllog database table.
 * 
 */
@Entity
@Table(name = "mapsolarsystemnpckilllog")
@NamedQueries({@NamedQuery(name="MapSolarSystemNpcKillLog.getKillsFor",
query="SELECT k FROM MapSolarSystemNpcKillLog k " +
		"WHERE k.pk.solarSystemID = :solarSystemID " +
		"AND k.pk.timeRetrieved BETWEEN :from AND :to"),
		@NamedQuery(name="MapSolarSystemNpcKillLog.getLastKillCheck", query = "SELECT MAX(d.pk.timeRetrieved) FROM MapSolarSystemNpcKillLog d")})
public class MapSolarSystemNpcKillLog extends ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;
	private int val;
	@EmbeddedId
	private ActivityLogPK pk;


    public MapSolarSystemNpcKillLog() {
    }

	public MapSolarSystemNpcKillLog(int ssid, Date timeRetrieved,
			Integer factionKillCount) {
		ActivityLogPK pk = new ActivityLogPK();
		pk.setSolarSystemID(ssid);
		pk.setTimeRetrieved(timeRetrieved);
		this.setValue(factionKillCount);
		this.setPk(pk);
	}

	public void setPk(ActivityLogPK pk) {
		this.pk = pk;
		
	}

	public int getValue() {
		return val;
	}

	public void setValue(int val) {
		this.val = val;
		
	}

	public ActivityLogPK getPk() {
		return pk;
	}
	

}