
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.sony.sonyquote;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-11T12:23:28.327-05:00
 * Generated source version: 2.7.6
 * 
 */

@javax.jws.WebService(
                      serviceName = "sonyQuote",
                      portName = "sonyQuoteSOAP2",
                      targetNamespace = "http://www.sony.com/sonyQuote/",
                      wsdlLocation = "http://localhost:8081/sony/services/sonyQuoteSOAP?wsdl",
                      endpointInterface = "com.sony.sonyquote.SonyQuoteService")
                      
public class SonyQuoteServiceImpl implements SonyQuoteService {

    private static final Logger LOG = Logger.getLogger(SonyQuoteServiceImpl.class.getName());

    /* (non-Javadoc)
     * @see com.sony.sonyquote.SonyQuoteService#initiate(com.oracle.xmlns.sonyquoteservice.SonyQuoteServiceProcessRequest  payload )*
     */
    public com.oracle.xmlns.sonyquoteservice.SonyQuoteServiceProcessResponse initiate(com.oracle.xmlns.sonyquoteservice.SonyQuoteServiceProcessRequest payload) { 
        LOG.info("Executing operation initiate");
        System.out.println(payload);
        try {
            com.oracle.xmlns.sonyquoteservice.SonyQuoteServiceProcessResponse _return = new com.oracle.xmlns.sonyquoteservice.SonyQuoteServiceProcessResponse();
            com.oracle.xmlns.sonyquoteservice.Quote _returnResult = new com.oracle.xmlns.sonyquoteservice.Quote();
            _returnResult.setSupplierPrice("85000");
            _return.setResult(_returnResult);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
