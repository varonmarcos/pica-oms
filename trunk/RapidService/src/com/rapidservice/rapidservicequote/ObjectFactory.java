
package com.rapidservice.rapidservicequote;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.rapidservice.rapidservicequote package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.rapidservice.rapidservicequote
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OrderQuouteResponseElement }
     * 
     */
    public OrderQuouteResponseElement createOrderQuouteResponseElement() {
        return new OrderQuouteResponseElement();
    }

    /**
     * Create an instance of {@link ProcessQuoteResponseElement }
     * 
     */
    public ProcessQuoteResponseElement createProcessQuoteResponseElement() {
        return new ProcessQuoteResponseElement();
    }

    /**
     * Create an instance of {@link Quote }
     * 
     */
    public Quote createQuote() {
        return new Quote();
    }

    /**
     * Create an instance of {@link ProcessQuoteElement }
     * 
     */
    public ProcessQuoteElement createProcessQuoteElement() {
        return new ProcessQuoteElement();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link OrderQuouteElement }
     * 
     */
    public OrderQuouteElement createOrderQuouteElement() {
        return new OrderQuouteElement();
    }

}
