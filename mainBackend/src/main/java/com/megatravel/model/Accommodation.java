//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.30 at 09:18:59 AM CEST 
//


package com.megatravel.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * <p>Java class for Accommodation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Accommodation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.megatravel.com/codebook}AccommodationType"/>
 *         &lt;element name="category" type="{http://www.megatravel.com/codebook}AccommodationCategory"/>
 *         &lt;element name="ownedBy" type="{http://www.megatravel.com/users}Agent"/>
 *         &lt;element name="fromDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="tillDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="image" type="{http://www.megatravel.com/accommodation}ImageResource" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.megatravel.com/accommodation}Address"/>
 *         &lt;element name="capacity" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="priceInSeason" type="{http://www.megatravel.com/accommodation}PriceInSeason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="additionalService" type="{http://www.megatravel.com/codebook}AdditionalServices" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="available" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="cancellation" type="{http://www.megatravel.com/accommodation}Cancellation"/>
 *         &lt;element name="rate" type="{http://www.megatravel.com/accommodation}rate"/>
 *         &lt;element name="comments" type="{http://www.megatravel.com/accommodation}Comment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Accommodation", propOrder = {
    "id",
    "name",
    "type",
    "category",
    "ownedBy",
    "fromDate",
    "tillDate",
    "distance",
    "description",
    "image",
    "address",
    "capacity",
    "priceInSeason",
    "additionalService",
    "available",
    "cancellation",
    "rate",
    "comments"
})
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="id", scope = Accommodation.class)
public class Accommodation {

	@Id
	@GeneratedValue
    protected long id;
    @XmlElement(required = true)
    protected String name;
    
    @XmlElement(required = true)
    @ManyToOne
    protected AccommodationType type;
    
    @XmlElement(required = true)
    @ManyToOne
    protected AccommodationCategory category;
    
    @XmlElement(required = true)
    @ManyToOne
    protected Agent ownedBy;
    
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date fromDate;
    
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected Date tillDate;
    
    protected int distance;
    
    @XmlElement(required = true)
    protected String description;
    
    @OneToMany
    protected List<ImageResource> image;
    
    @XmlElement(required = true)
    @OneToOne
    protected Address address;
    
    @XmlSchemaType(name = "unsignedInt")
    protected long capacity;
    
    @OneToMany
    protected List<PriceInSeason> priceInSeason;
    
    @ManyToMany
    protected List<AdditionalServices> additionalService;
    
    protected boolean available;
    
    @XmlElement(required = true)
    @ManyToOne
    protected Cancellation cancellation;
    
    @XmlElement(required = true)
    protected String rate;
    
    @OneToMany
    protected List<Comment> comments;
    

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationType }
     *     
     */
    public AccommodationType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationType }
     *     
     */
    public void setType(AccommodationType value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link AccommodationCategory }
     *     
     */
    public AccommodationCategory getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccommodationCategory }
     *     
     */
    public void setCategory(AccommodationCategory value) {
        this.category = value;
    }

    /**
     * Gets the value of the ownedBy property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getOwnedBy() {
        return ownedBy;
    }

    /**
     * Sets the value of the ownedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setOwnedBy(Agent value) {
        this.ownedBy = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFromDate(Date value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the tillDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getTillDate() {
        return tillDate;
    }

    /**
     * Sets the value of the tillDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTillDate(Date value) {
        this.tillDate = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     */
    public void setDistance(int value) {
        this.distance = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageResource }
     * 
     * 
     */
    public List<ImageResource> getImage() {
        if (image == null) {
            image = new ArrayList<ImageResource>();
        }
        return this.image;
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
     * Gets the value of the capacity property.
     * 
     */
    public long getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     */
    public void setCapacity(long value) {
        this.capacity = value;
    }

    public void setImage(List<ImageResource> image) {
		this.image = image;
	}

	public void setAdditionalService(List<AdditionalServices> additionalService) {
		this.additionalService = additionalService;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
     * Gets the value of the priceInSeason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the priceInSeason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPriceInSeason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PriceInSeason }
     * 
     * 
     */
    public List<PriceInSeason> getPriceInSeason() {
        if (priceInSeason == null) {
            priceInSeason = new ArrayList<PriceInSeason>();
        }
        return this.priceInSeason;
    }
    
    public void setPriceInSeason(List<PriceInSeason> prices) {
           this.priceInSeason = prices;
    }

    /**
     * Gets the value of the additionalService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalServices }
     * 
     * 
     */
    public List<AdditionalServices> getAdditionalService() {
        if (additionalService == null) {
            additionalService = new ArrayList<AdditionalServices>();
        }
        return this.additionalService;
    }

    /**
     * Gets the value of the available property.
     * 
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Sets the value of the available property.
     * 
     */
    public void setAvailable(boolean value) {
        this.available = value;
    }

    /**
     * Gets the value of the cancellation property.
     * 
     * @return
     *     possible object is
     *     {@link Cancellation }
     *     
     */
    public Cancellation getCancellation() {
        return cancellation;
    }

    /**
     * Sets the value of the cancellation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cancellation }
     *     
     */
    public void setCancellation(Cancellation value) {
        this.cancellation = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRate(String value) {
        this.rate = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comment }
     * 
     * 
     */
    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<Comment>();
        }
        return this.comments;
    }

}
