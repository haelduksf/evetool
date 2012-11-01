
package com.hael.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for activityLogPK complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activityLogPK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="solarSystemID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="timeRetrieved" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activityLogPK", propOrder = {
    "solarSystemID",
    "timeRetrieved"
})
public class ActivityLogPK {

    protected int solarSystemID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timeRetrieved;

    /**
     * Gets the value of the solarSystemID property.
     * 
     */
    public int getSolarSystemID() {
        return solarSystemID;
    }

    /**
     * Sets the value of the solarSystemID property.
     * 
     */
    public void setSolarSystemID(int value) {
        this.solarSystemID = value;
    }

    /**
     * Gets the value of the timeRetrieved property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeRetrieved() {
        return timeRetrieved;
    }

    /**
     * Sets the value of the timeRetrieved property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeRetrieved(XMLGregorianCalendar value) {
        this.timeRetrieved = value;
    }

}
