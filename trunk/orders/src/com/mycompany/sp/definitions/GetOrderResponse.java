
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}getOrderRs"/>
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
    "getOrderRs"
})
@XmlRootElement(name = "getOrderResponse")
public class GetOrderResponse {

    @XmlElement(required = true)
    protected GetOrderRs getOrderRs;

    /**
     * Obtiene el valor de la propiedad getOrderRs.
     * 
     * @return
     *     possible object is
     *     {@link GetOrderRs }
     *     
     */
    public GetOrderRs getGetOrderRs() {
        return getOrderRs;
    }

    /**
     * Define el valor de la propiedad getOrderRs.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOrderRs }
     *     
     */
    public void setGetOrderRs(GetOrderRs value) {
        this.getOrderRs = value;
    }

}
