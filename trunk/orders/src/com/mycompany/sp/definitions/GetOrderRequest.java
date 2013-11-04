
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}getOrderRq"/>
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
    "getOrderRq"
})
@XmlRootElement(name = "getOrderRequest")
public class GetOrderRequest {

    @XmlElement(required = true)
    protected GetOrderRq getOrderRq;

    /**
     * Obtiene el valor de la propiedad getOrderRq.
     * 
     * @return
     *     possible object is
     *     {@link GetOrderRq }
     *     
     */
    public GetOrderRq getGetOrderRq() {
        return getOrderRq;
    }

    /**
     * Define el valor de la propiedad getOrderRq.
     * 
     * @param value
     *     allowed object is
     *     {@link GetOrderRq }
     *     
     */
    public void setGetOrderRq(GetOrderRq value) {
        this.getOrderRq = value;
    }

}
