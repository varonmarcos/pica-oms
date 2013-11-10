
package com.mycompany.sp.definitions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}RegisterCustomerReq"/>
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
    "registerCustomerReq"
})
@XmlRootElement(name = "RegisterCustomerRequest")
public class RegisterCustomerRequest {

    @XmlElement(name = "RegisterCustomerReq", required = true)
    protected RegisterCustomerReq registerCustomerReq;

    /**
     * Gets the value of the registerCustomerReq property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterCustomerReq }
     *     
     */
    public RegisterCustomerReq getRegisterCustomerReq() {
        return registerCustomerReq;
    }

    /**
     * Sets the value of the registerCustomerReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterCustomerReq }
     *     
     */
    public void setRegisterCustomerReq(RegisterCustomerReq value) {
        this.registerCustomerReq = value;
    }

}
