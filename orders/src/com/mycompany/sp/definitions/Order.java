package com.mycompany.sp.definitions;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-03T18:41:30.860-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebServiceClient(name = "Order", 
                  wsdlLocation = "http://localhost:8081/orders/services/orderServicePort?wsdl",
                  targetNamespace = "http://mycompany.com/sp/definitions") 
public class Order extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://mycompany.com/sp/definitions", "Order");
    public final static QName OrderServicePort = new QName("http://mycompany.com/sp/definitions", "orderServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/orders/services/orderServicePort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Order.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8081/orders/services/orderServicePort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Order(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Order(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Order() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns OrderBinding
     */
    @WebEndpoint(name = "orderServicePort")
    public OrderBinding getOrderServicePort() {
        return super.getPort(OrderServicePort, OrderBinding.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns OrderBinding
     */
    @WebEndpoint(name = "orderServicePort")
    public OrderBinding getOrderServicePort(WebServiceFeature... features) {
        return super.getPort(OrderServicePort, OrderBinding.class, features);
    }

}
