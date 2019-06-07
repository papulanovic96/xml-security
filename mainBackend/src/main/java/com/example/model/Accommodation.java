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
 * <p>Java class for Accommodation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Accommodation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Hotel"/>
 *               &lt;enumeration value="Bed&amp;Breakfast"/>
 *               &lt;enumeration value="Apartment"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Distance" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Image" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Capacity" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Address">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="Zip" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="newElement" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                   &lt;element name="Coordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PriceInSeason" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="AdditionalServices">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Parking"/>
 *               &lt;enumeration value="WiFi"/>
 *               &lt;enumeration value="Breakfast"/>
 *               &lt;enumeration value="Half Board"/>
 *               &lt;enumeration value="Full Board"/>
 *               &lt;enumeration value="All Inclusive"/>
 *               &lt;enumeration value="Pets Allowed"/>
 *               &lt;enumeration value="TV"/>
 *               &lt;enumeration value="Kitchen"/>
 *               &lt;enumeration value="Private Bath"/>
 *               &lt;enumeration value="Free Cancellation"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Rate" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
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
@XmlType(name = "Accommodation", namespace = "http://www.megatravel.com/accomodation", propOrder = {
    "type",
    "category",
    "distance",
    "description",
    "image",
    "capacity",
    "address",
    "priceInSeason",
    "additionalServices",
    "rate",
    "comment",
    "id"
})
public class Accommodation {

    @XmlElement(name = "Type", required = true, defaultValue = "Hotel")
    protected String type;
    @XmlElement(name = "Category", required = true)
    protected Object category;
    @XmlElement(name = "Distance", required = true)
    protected Object distance;
    @XmlElement(name = "Description", required = true)
    protected Object description;
    @XmlElement(name = "Image", required = true)
    protected Object image;
    @XmlElement(name = "Capacity", required = true)
    protected Object capacity;
    @XmlElement(name = "Address", required = true)
    protected Accommodation.Address address;
    @XmlElement(name = "PriceInSeason", required = true)
    protected Object priceInSeason;
    @XmlElement(name = "AdditionalServices", required = true)
    protected String additionalServices;
    @XmlElement(name = "Rate", required = true)
    protected Object rate;
    @XmlElement(name = "Comment", required = true)
    protected Object comment;
    @XmlElement(required = true)
    protected BigInteger id;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCategory(Object value) {
        this.category = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDistance(Object value) {
        this.distance = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDescription(Object value) {
        this.description = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setImage(Object value) {
        this.image = value;
    }

    /**
     * Gets the value of the capacity property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getCapacity() {
        return capacity;
    }

    /**
     * Sets the value of the capacity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setCapacity(Object value) {
        this.capacity = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link Accommodation.Address }
     *     
     */
    public Accommodation.Address getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accommodation.Address }
     *     
     */
    public void setAddress(Accommodation.Address value) {
        this.address = value;
    }

    /**
     * Gets the value of the priceInSeason property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPriceInSeason() {
        return priceInSeason;
    }

    /**
     * Sets the value of the priceInSeason property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPriceInSeason(Object value) {
        this.priceInSeason = value;
    }

    /**
     * Gets the value of the additionalServices property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalServices() {
        return additionalServices;
    }

    /**
     * Sets the value of the additionalServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalServices(String value) {
        this.additionalServices = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRate(Object value) {
        this.rate = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setComment(Object value) {
        this.comment = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Country" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="Zip" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="Street" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="newElement" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *         &lt;element name="Coordinates" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "country",
        "city",
        "zip",
        "street",
        "newElement",
        "coordinates"
    })
    public static class Address {

        @XmlElement(name = "Country", namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object country;
        @XmlElement(name = "City", namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object city;
        @XmlElement(name = "Zip", namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object zip;
        @XmlElement(name = "Street", namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object street;
        @XmlElement(namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object newElement;
        @XmlElement(name = "Coordinates", namespace = "http://www.megatravel.com/accommodation", required = true)
        protected Object coordinates;

        /**
         * Gets the value of the country property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCountry() {
            return country;
        }

        /**
         * Sets the value of the country property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCountry(Object value) {
            this.country = value;
        }

        /**
         * Gets the value of the city property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCity() {
            return city;
        }

        /**
         * Sets the value of the city property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCity(Object value) {
            this.city = value;
        }

        /**
         * Gets the value of the zip property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getZip() {
            return zip;
        }

        /**
         * Sets the value of the zip property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setZip(Object value) {
            this.zip = value;
        }

        /**
         * Gets the value of the street property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getStreet() {
            return street;
        }

        /**
         * Sets the value of the street property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setStreet(Object value) {
            this.street = value;
        }

        /**
         * Gets the value of the newElement property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getNewElement() {
            return newElement;
        }

        /**
         * Sets the value of the newElement property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setNewElement(Object value) {
            this.newElement = value;
        }

        /**
         * Gets the value of the coordinates property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCoordinates() {
            return coordinates;
        }

        /**
         * Sets the value of the coordinates property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCoordinates(Object value) {
            this.coordinates = value;
        }

    }

}
