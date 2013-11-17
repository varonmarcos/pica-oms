
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}GetCustomerReq"/>
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
    "getCustomerReq"
})
@XmlRootElement(name = "GetCustomerRequest")
public class GetCustomerRequest {

    @XmlElement(name = "GetCustomerReq", required = true)
    protected GetCustomerReq getCustomerReq;

    /**
     * Obtiene el valor de la propiedad getCustomerReq.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerReq }
     *     
     */
    public GetCustomerReq getGetCustomerReq() {
        return getCustomerReq;
    }

    /**
     * Define el valor de la propiedad getCustomerReq.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerReq }
     *     
     */
    public void setGetCustomerReq(GetCustomerReq value) {
        this.getCustomerReq = value;
    }

}
