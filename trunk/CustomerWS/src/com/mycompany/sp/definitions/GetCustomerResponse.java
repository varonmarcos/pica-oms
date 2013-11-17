
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}GetCustomerRes"/>
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
    "getCustomerRes"
})
@XmlRootElement(name = "GetCustomerResponse")
public class GetCustomerResponse {

    @XmlElement(name = "GetCustomerRes", required = true)
    protected GetCustomerRes getCustomerRes;

    /**
     * Obtiene el valor de la propiedad getCustomerRes.
     * 
     * @return
     *     possible object is
     *     {@link GetCustomerRes }
     *     
     */
    public GetCustomerRes getGetCustomerRes() {
        return getCustomerRes;
    }

    /**
     * Define el valor de la propiedad getCustomerRes.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCustomerRes }
     *     
     */
    public void setGetCustomerRes(GetCustomerRes value) {
        this.getCustomerRes = value;
    }

}
