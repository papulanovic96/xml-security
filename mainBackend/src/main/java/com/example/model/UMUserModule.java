//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.06 at 04:11:06 PM CEST 
//


package com.example.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UMUserModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UMUserModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AccomodationSearch" type="{http://www.megatravel.com/accommodation}Accommodation"/>
 *         &lt;element name="Reservations" type="{http://www.megatravel.com/reservation}RReservation"/>
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UMUserModule", namespace = "http://www.megatravel.com/user-module", propOrder = {
    "accomodationSearch",
    "reservations",
    "id"
})
public class UMUserModule {

    @XmlElement(name = "AccomodationSearch", required = true)
    protected Accommodation accomodationSearch;
    @XmlElement(name = "Reservations", required = true)
    protected RReservation reservations;
    @XmlElement(required = true)
    protected BigInteger id;

    /**
     * Gets the value of the accomodationSearch property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation }
     *     
     */
    public Accommodation getAccomodationSearch() {
        return accomodationSearch;
    }

    /**
     * Sets the value of the accomodationSearch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation }
     *     
     */
    public void setAccomodationSearch(Accommodation value) {
        this.accomodationSearch = value;
    }

    /**
     * Gets the value of the reservations property.
     * 
     * @return
     *     possible object is
     *     {@link RReservation }
     *     
     */
    public RReservation getReservations() {
        return reservations;
    }

    /**
     * Sets the value of the reservations property.
     * 
     * @param value
     *     allowed object is
     *     {@link RReservation }
     *     
     */
    public void setReservations(RReservation value) {
        this.reservations = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

}
