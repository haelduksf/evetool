
package com.hael.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activityLog complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activityLog">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="pk" type="{http://evetool.hael.com/}activityLogPK" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activityLog", propOrder = {
    "pk",
    "value"
})
@XmlSeeAlso({
    MapSolarSystemNpcKillLog.class,
    MapSolarSystemJumpLog.class,
    MapSolarSystemPcKillLog.class
})
public abstract class ActivityLog {

    protected ActivityLogPK pk;
    protected int value;

    /**
     * Gets the value of the pk property.
     * 
     * @return
     *     possible object is
     *     {@link ActivityLogPK }
     *     
     */
    public ActivityLogPK getPk() {
        return pk;
    }

    /**
     * Sets the value of the pk property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActivityLogPK }
     *     
     */
    public void setPk(ActivityLogPK value) {
        this.pk = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(int value) {
        this.value = value;
    }

}
