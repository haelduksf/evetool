package com.hael.evetool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class ActivityLogPK implements Serializable {
	private static final long serialVersionUID = 1L;
	private int solarSystemID;
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeRetrieved;
	public void setTimeRetrieved(Date timeRetrieved) {
		this.timeRetrieved = timeRetrieved;
	}
	
	public Date getTimeRetrieved() {
		return timeRetrieved;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + solarSystemID;
		result = prime * result
				+ ((timeRetrieved == null) ? 0 : timeRetrieved.hashCode());
		return result;
	}
	
	
	public void setSolarSystemID(int solarSystemID) {
		this.solarSystemID = solarSystemID;
		
	}
	
	public int getSolarSystemID() {
		return solarSystemID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityLogPK other = (ActivityLogPK) obj;
		if (solarSystemID != other.solarSystemID)
			return false;
		if (timeRetrieved == null) {
			if (other.timeRetrieved != null)
				return false;
		} else if (!timeRetrieved.equals(other.timeRetrieved))
			return false;
		return true;
	}
}
