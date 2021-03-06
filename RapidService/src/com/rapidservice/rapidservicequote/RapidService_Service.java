package com.rapidservice.rapidservicequote;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-11T20:32:13.998-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebServiceClient(name = "RapidService", 
                  wsdlLocation = "http://localhost:8081/rapidservice/services/rapidserviceQuoteSOAP2?wsdl",
                  targetNamespace = "http://www.rapidservice.com/rapidserviceQuote/") 
public class RapidService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.rapidservice.com/rapidserviceQuote/", "RapidService");
    public final static QName RapidService = new QName("http://www.rapidservice.com/rapidserviceQuote/", "RapidService");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/rapidservice/services/rapidserviceQuoteSOAP2?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RapidService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8081/rapidservice/services/rapidserviceQuoteSOAP2?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RapidService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RapidService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RapidService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns RapidService
     */
    @WebEndpoint(name = "RapidService")
    public RapidService getRapidService() {
        return super.getPort(RapidService, RapidService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RapidService
     */
    @WebEndpoint(name = "RapidService")
    public RapidService getRapidService(WebServiceFeature... features) {
        return super.getPort(RapidService, RapidService.class, features);
    }

}
