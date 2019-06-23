//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.22 at 08:56:14 PM CEST 
//


package com.megatravel.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * <p>Java class for Agent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Agent">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.megatravel.com/users}User">
 *       &lt;sequence>
 *         &lt;element name="BRN" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="address" type="{http://www.megatravel.com/accommodation}Address"/>
 *         &lt;element name="achats" type="{http://www.megatravel.com/message}Message" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="accommodations" type="{http://www.megatravel.com/accommodation}Accommodation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent", namespace = "http://www.megatravel.com/users", propOrder = {
    "id",
    "brn",
    "address",
    "achats",
    "accommodations"
})
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Agent
    extends User
{

    @XmlElement(name = "BRN")
    protected int brn;
    
    @XmlElement(required = true)
    @ManyToOne
    protected Address address;
    
    @ManyToMany
    protected List<Message> achats;
    
    @ManyToMany
    protected List<Accommodation> accommodations;

    /**
     * Gets the value of the brn property.
     * 
     */
    public int getBRN() {
        return brn;
    }

    /**
     * Sets the value of the brn property.
     * 
     */
    public void setBRN(int value) {
        this.brn = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Address }
     *     
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Address }
     *     
     */
    public void setAddress(Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the achats property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the achats property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAchats().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Message }
     * 
     * 
     */
    public List<Message> getAchats() {
        if (achats == null) {
            achats = new ArrayList<Message>();
        }
        return this.achats;
    }

    /**
     * Gets the value of the accommodations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the accommodations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccommodations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Accommodation }
     * 
     * 
     */
    public List<Accommodation> getAccommodations() {
        if (accommodations == null) {
            accommodations = new ArrayList<Accommodation>();
        }
        return this.accommodations;
    }

}
