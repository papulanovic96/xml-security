//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.08.11 at 11:34:41 PM CEST 
//


package com.megatravel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EndUser complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EndUser">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.megatravel.com/users}User">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.megatravel.com/users}userStatus"/>
 *         &lt;element name="reservations" type="{http://www.megatravel.com/reservation}Reservation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EndUser", namespace = "http://www.megatravel.com/users", propOrder = {
    "status",
    "reservations"
})
@Entity
public class EndUser
    extends User
{

    @XmlElement(required = true)
	@Enumerated(EnumType.STRING)
    protected UserStatus status;
    
    @ManyToMany
    protected List<Reservation> reservations;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link UserStatus }
     *     
     */
    public UserStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserStatus }
     *     
     */
    public void setStatus(UserStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reservations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReservations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getReservations() {
        if (reservations == null) {
            reservations = new ArrayList<Reservation>();
        }
        return this.reservations;
    }

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
