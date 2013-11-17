
package com.mycompany.sp.definitions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
     * Obtiene el valor de la propiedad registerCustomerReq.
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
     * Define el valor de la propiedad registerCustomerReq.
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
