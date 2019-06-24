//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.23 at 02:14:56 PM CEST 
//


package com.megatravel.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


/**
 * <p>Java class for Administrator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Administrator">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.megatravel.com/users}User">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Administrator", namespace = "http://www.megatravel.com/users")
@Entity
@JsonTypeName("Administrator")
@JsonDeserialize(as = Administrator.class)
public class Administrator
    extends User
{
	
	public Administrator() {
		
	}

	public Administrator(String un, String pw, String e, String fn, String ln) {
		this.username = un;
    	this.password = pw;
    	this.email = e;
    	this.firstName = fn;
    	this.lastName = ln;
	}
	
}
