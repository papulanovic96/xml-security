//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.18 at 01:08:10 PM CEST 
//


package com.microagent.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for roles.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="roles">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Admin"/>
 *     &lt;enumeration value="Agent"/>
 *     &lt;enumeration value="EndUser"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "roles", namespace = "http://www.megatravel.com/users")
@XmlEnum
public enum Roles {

    @XmlEnumValue("Admin")
    ADMIN("Admin"),
    @XmlEnumValue("Agent")
    AGENT("Agent"),
    @XmlEnumValue("EndUser")
    END_USER("EndUser");
    private final String value;

    Roles(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Roles fromValue(String v) {
        for (Roles c: Roles.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
