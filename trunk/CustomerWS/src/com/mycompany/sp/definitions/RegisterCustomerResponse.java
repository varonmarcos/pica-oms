
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}RegisterCustomerRes"/>
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
    "registerCustomerRes"
})
@XmlRootElement(name = "RegisterCustomerResponse")
public class RegisterCustomerResponse {

    @XmlElement(name = "RegisterCustomerRes", required = true)
    protected RegisterCustomerRes registerCustomerRes;

    /**
     * Gets the value of the registerCustomerRes property.
     * 
     * @return
     *     possible object is
     *     {@link RegisterCustomerRes }
     *     
     */
    public RegisterCustomerRes getRegisterCustomerRes() {
        return registerCustomerRes;
    }

    /**
     * Sets the value of the registerCustomerRes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisterCustomerRes }
     *     
     */
    public void setRegisterCustomerRes(RegisterCustomerRes value) {
        this.registerCustomerRes = value;
    }

}
