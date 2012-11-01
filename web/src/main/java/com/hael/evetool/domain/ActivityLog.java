package com.hael.evetool.domain;

//import javax.persistence.EmbeddedId;

public abstract class ActivityLog {




	public abstract int getValue();

	public abstract void setValue(int val);

	public abstract ActivityLogPK getPk();
	public abstract void setPk(ActivityLogPK pk);
	
}