
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}createOrderRq"/>
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
    "createOrderRq"
})
@XmlRootElement(name = "createOrderRequest")
public class CreateOrderRequest {

    @XmlElement(required = true)
    protected CreateOrderRq createOrderRq;

    /**
     * Obtiene el valor de la propiedad createOrderRq.
     * 
     * @return
     *     possible object is
     *     {@link CreateOrderRq }
     *     
     */
    public CreateOrderRq getCreateOrderRq() {
        return createOrderRq;
    }

    /**
     * Define el valor de la propiedad createOrderRq.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOrderRq }
     *     
     */
    public void setCreateOrderRq(CreateOrderRq value) {
        this.createOrderRq = value;
    }

}
