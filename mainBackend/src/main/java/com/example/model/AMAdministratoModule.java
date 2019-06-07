//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.06 at 04:09:54 PM CEST 
//


package com.example.model;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AMAdministratoModule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AMAdministratoModule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CodeBook">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Type" type="{http://www.megatravel.com/accommodation}Accommodation"/>
 *                   &lt;element name="Category" type="{http://www.megatravel.com/accommodation}Accommodation"/>
 *                   &lt;element name="OtherServices" type="{http://www.megatravel.com/accommodation}Accommodation"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Users" type="{htttp://www.megatravel.com/users}UUser"/>
 *         &lt;element name="Agents" type="{htttp://www.megatravel.com/users}UAgent"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AMAAdministrationModule", namespace = "http://www.megatravel.com/admin-module", propOrder = {
    "codeBook",
    "id",
    "users",
    "agents"
})
public class AMAdministratoModule {

    @XmlElement(name = "CodeBook", required = true)
    protected AMAdministratoModule.CodeBook codeBook;
    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(name = "Users", required = true)
    protected UUser users;
    @XmlElement(name = "Agents", required = true)
    protected UAgent agents;

    /**
     * Gets the value of the codeBook property.
     * 
     * @return
     *     possible object is
     *     {@link AMAdministratoModule.CodeBook }
     *     
     */
    public AMAdministratoModule.CodeBook getCodeBook() {
        return codeBook;
    }

    /**
     * Sets the value of the codeBook property.
     * 
     * @param value
     *     allowed object is
     *     {@link AMAdministratoModule.CodeBook }
     *     
     */
    public void setCodeBook(AMAdministratoModule.CodeBook value) {
        this.codeBook = value;
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
     * Gets the value of the users property.
     * 
     * @return
     *     possible object is
     *     {@link UUser }
     *     
     */
    public UUser getUsers() {
        return users;
    }

    /**
     * Sets the value of the users property.
     * 
     * @param value
     *     allowed object is
     *     {@link UUser }
     *     
     */
    public void setUsers(UUser value) {
        this.users = value;
    }

    /**
     * Gets the value of the agents property.
     * 
     * @return
     *     possible object is
     *     {@link UAgent }
     *     
     */
    public UAgent getAgents() {
        return agents;
    }

    /**
     * Sets the value of the agents property.
     * 
     * @param value
     *     allowed object is
     *     {@link UAgent }
     *     
     */
    public void setAgents(UAgent value) {
        this.agents = value;
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
     *         &lt;element name="Type" type="{http://www.megatravel.com/accommodation}Accommodation"/>
     *         &lt;element name="Category" type="{http://www.megatravel.com/accommodation}Accommodation"/>
     *         &lt;element name="OtherServices" type="{http://www.megatravel.com/accommodation}Accommodation"/>
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
        "type",
        "category",
        "otherServices"
    })
    public static class CodeBook {

        @XmlElement(name = "Type", namespace = "http://www.megatravel.com/admin-module", required = true)
        protected Accommodation type;
        @XmlElement(name = "Category", namespace = "http://www.megatravel.com/admin-module", required = true)
        protected Accommodation category;
        @XmlElement(name = "OtherServices", namespace = "http://www.megatravel.com/admin-module", required = true)
        protected Accommodation otherServices;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link Accommodation }
         *     
         */
        public Accommodation getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link Accommodation }
         *     
         */
        public void setType(Accommodation value) {
            this.type = value;
        }

        /**
         * Gets the value of the category property.
         * 
         * @return
         *     possible object is
         *     {@link Accommodation }
         *     
         */
        public Accommodation getCategory() {
            return category;
        }

        /**
         * Sets the value of the category property.
         * 
         * @param value
         *     allowed object is
         *     {@link Accommodation }
         *     
         */
        public void setCategory(Accommodation value) {
            this.category = value;
        }

        /**
         * Gets the value of the otherServices property.
         * 
         * @return
         *     possible object is
         *     {@link Accommodation }
         *     
         */
        public Accommodation getOtherServices() {
            return otherServices;
        }

        /**
         * Sets the value of the otherServices property.
         * 
         * @param value
         *     allowed object is
         *     {@link Accommodation }
         *     
         */
        public void setOtherServices(Accommodation value) {
            this.otherServices = value;
        }

    }

}
