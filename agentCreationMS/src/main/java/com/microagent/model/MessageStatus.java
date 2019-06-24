//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.06.14 at 06:43:02 PM CEST 
//


package com.microagent.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for messageStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="messageStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Sending"/>
 *     &lt;enumeration value="Deliviered"/>
 *     &lt;enumeration value="Seen"/>
 *     &lt;enumeration value="Unknown username"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "messageStatus", namespace = "http://www.megatravel.com/message")
@XmlEnum
public enum MessageStatus {

    @XmlEnumValue("Sending")
    SENDING("Sending"),
    @XmlEnumValue("Deliviered")
    DELIVIERED("Deliviered"),
    @XmlEnumValue("Seen")
    SEEN("Seen"),
    @XmlEnumValue("Unknown username")
    UNKNOWN_USERNAME("Unknown username");
    private final String value;

    MessageStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageStatus fromValue(String v) {
        for (MessageStatus c: MessageStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
