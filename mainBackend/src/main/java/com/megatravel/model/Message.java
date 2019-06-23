//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.23 at 02:14:56 PM CEST 
//


package com.megatravel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Message complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Message">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="agent_un" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="endUser_un" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="messageStatus" type="{http://www.megatravel.com/message}messageStatus"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Message", namespace = "http://www.megatravel.com/message", propOrder = {
    "id",
    "agentUn",
    "endUserUn",
    "content",
    "messageStatus"
})
@Entity
public class Message {

	@Id
	@GeneratedValue
    protected long id;
	
    @XmlElement(name = "agent_un", required = true)
    protected String agentUn;
    
    @XmlElement(name = "endUser_un", required = true)
    protected String endUserUn;
    
    @XmlElement(required = true)
    protected String content;
    
    @XmlElement(required = true)
    protected MessageStatus messageStatus;

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
     * Gets the value of the agentUn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentUn() {
        return agentUn;
    }

    /**
     * Sets the value of the agentUn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentUn(String value) {
        this.agentUn = value;
    }

    /**
     * Gets the value of the endUserUn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndUserUn() {
        return endUserUn;
    }

    /**
     * Sets the value of the endUserUn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndUserUn(String value) {
        this.endUserUn = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the messageStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MessageStatus }
     *     
     */
    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    /**
     * Sets the value of the messageStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageStatus }
     *     
     */
    public void setMessageStatus(MessageStatus value) {
        this.messageStatus = value;
    }

}
