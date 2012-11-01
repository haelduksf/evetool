package com.hael.evetool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the mapsolarsystempckilllog database table.
 * 
 */
@Entity
@Table(name="mapsolarsystempckilllog")
@NamedQueries({@NamedQuery(name="MapSolarSystemPcKillLog.getKillsFor",
query="SELECT k FROM MapSolarSystemPcKillLog k " +
		"WHERE k.pk.solarSystemID = :solarSystemID " +
		"AND k.pk.timeRetrieved BETWEEN :from AND :to"),
		@NamedQuery(name="MapSolarSystemPcKillLog.getLastKillCheck", query = "SELECT MAX(d.pk.timeRetrieved) FROM MapSolarSystemPcKillLog d")})
public class MapSolarSystemPcKillLog extends ActivityLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ActivityLogPK pk;
	private int val;



    public MapSolarSystemPcKillLog() {
    }
    
    public MapSolarSystemPcKillLog(int ssid, Date timeRetrieved,
			Integer pcKillCount) {
    	ActivityLogPK pk = new ActivityLogPK();
		pk.setSolarSystemID(ssid);
		pk.setTimeRetrieved(timeRetrieved);
		this.setValue(pcKillCount);
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