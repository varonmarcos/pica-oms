package com.sony.sony;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-11T12:33:33.548-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebServiceClient(name = "sony", 
                  wsdlLocation = "http://localhost:8081/sony/services/sonySOAP?wsdl",
                  targetNamespace = "http://www.sony.com/sony/") 
public class Sony extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.sony.com/sony/", "sony");
    public final static QName SonySOAP = new QName("http://www.sony.com/sony/", "sonySOAP");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/sony/services/sonySOAP?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(Sony.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8081/sony/services/sonySOAP?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public Sony(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public Sony(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Sony() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns SonyOrderService
     */
    @WebEndpoint(name = "sonySOAP")
    public SonyOrderService getSonySOAP() {
        return super.getPort(SonySOAP, SonyOrderService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SonyOrderService
     */
    @WebEndpoint(name = "sonySOAP")
    public SonyOrderService getSonySOAP(WebServiceFeature... features) {
        return super.getPort(SonySOAP, SonyOrderService.class, features);
    }

}
