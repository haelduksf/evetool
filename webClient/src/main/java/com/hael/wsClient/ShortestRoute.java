
package com.hael.wsClient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for shortestRoute complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="shortestRoute">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="minSecurity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maxSecurity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "shortestRoute", propOrder = {
    "from",
    "to",
    "minSecurity",
    "maxSecurity"
})
public class ShortestRoute {

    protected String from;
    protected String to;
    protected float minSecurity;
    protected float maxSecurity;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrom(String value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTo(String value) {
        this.to = value;
    }

    /**
     * Gets the value of the minSecurity property.
     * 
     */
    public float getMinSecurity() {
        return minSecurity;
    }

    /**
     * Sets the value of the minSecurity property.
     * 
     */
    public void setMinSecurity(float value) {
        this.minSecurity = value;
    }

    /**
     * Gets the value of the maxSecurity property.
     * 
     */
    public float getMaxSecurity() {
        return maxSecurity;
    }

    /**
     * Sets the value of the maxSecurity property.
     * 
     */
    public void setMaxSecurity(float value) {
        this.maxSecurity = value;
    }

}
