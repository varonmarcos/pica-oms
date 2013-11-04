
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
 *         &lt;element ref="{http://mycompany.com/sp/definitions}createOrderRs"/>
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
    "createOrderRs"
})
@XmlRootElement(name = "createOrderResponse")
public class CreateOrderResponse {

    @XmlElement(required = true)
    protected CreateOrderRs createOrderRs;

    /**
     * Obtiene el valor de la propiedad createOrderRs.
     * 
     * @return
     *     possible object is
     *     {@link CreateOrderRs }
     *     
     */
    public CreateOrderRs getCreateOrderRs() {
        return createOrderRs;
    }

    /**
     * Define el valor de la propiedad createOrderRs.
     * 
     * @param value
     *     allowed object is
     *     {@link CreateOrderRs }
     *     
     */
    public void setCreateOrderRs(CreateOrderRs value) {
        this.createOrderRs = value;
    }

}
