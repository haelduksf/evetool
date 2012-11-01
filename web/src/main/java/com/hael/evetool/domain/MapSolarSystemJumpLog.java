package com.hael.evetool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the mapsolarsystemjumplog database table.
 * 
 */
@Entity
@Table(name = "mapsolarsystemjumplog")
@NamedQueries({@NamedQuery(name="MapSolarSystemJumpLog.getJumpsFor",
		query="SELECT j FROM MapSolarSystemJumpLog j " +
				"WHERE j.pk.solarSystemID = :solarSystemID " +
				"AND j.pk.timeRetrieved BETWEEN :from AND :to"),
				@NamedQuery(name="MapSolarSystemJumpLog.getLastJumpCheck", query = "SELECT MAX(d.pk.timeRetrieved) FROM MapSolarSystemJumpLog d")})
public class MapSolarSystemJumpLog extends ActivityLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int val;
	@EmbeddedId
	private ActivityLogPK pk;
	

	
	public MapSolarSystemJumpLog() {
    	
    }
	
	public MapSolarSystemJumpLog(int id, Date timeRetrieved, int value) {
		ActivityLogPK pk = new ActivityLogPK();
    	pk.setSolarSystemID(id);
    	pk.setTimeRetrieved(timeRetrieved);
    	this.setValue(value);
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