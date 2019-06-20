//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.14 at 07:04:09 PM CEST 
//


package com.megatravel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PriceInSeason complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PriceInSeason">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="inMonth" type="{http://www.megatravel.com/accommodation}months"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="currency" type="{http://www.megatravel.com/accommodation}currencies"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PriceInSeason", propOrder = {
    "id",
    "inMonth",
    "price",
    "currency"
})
@Entity
public class PriceInSeason {

	@Id
	@GeneratedValue
    protected long id;
	
    @XmlElement(required = true)
    protected Months inMonth;
    
    @XmlSchemaType(name = "unsignedInt")
    protected long price;
    
    @XmlElement(required = true)
    protected Currencies currency;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the inMonth property.
     * 
     * @return
     *     possible object is
     *     {@link Months }
     *     
     */
    public Months getInMonth() {
        return inMonth;
    }

    /**
     * Sets the value of the inMonth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Months }
     *     
     */
    public void setInMonth(Months value) {
        this.inMonth = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public long getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(long value) {
        this.price = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link Currencies }
     *     
     */
    public Currencies getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Currencies }
     *     
     */
    public void setCurrency(Currencies value) {
        this.currency = value;
    }

}
