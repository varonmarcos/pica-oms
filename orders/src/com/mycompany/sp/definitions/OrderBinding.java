package com.mycompany.sp.definitions;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-03T18:41:30.851-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://mycompany.com/sp/definitions", name = "OrderBinding")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface OrderBinding {

    @WebResult(name = "getOrderResponse", targetNamespace = "http://mycompany.com/sp/definitions", partName = "getOrderRs")
    @WebMethod(action = "http://mycompany.com/setTop5")
    public GetOrderResponse getOrder(
        @WebParam(partName = "getOrderRq", name = "getOrderRequest", targetNamespace = "http://mycompany.com/sp/definitions")
        GetOrderRequest getOrderRq
    );

    @WebResult(name = "createOrderResponse", targetNamespace = "http://mycompany.com/sp/definitions", partName = "createOrderRs")
    @WebMethod(action = "http://mycompany.com/setTop5")
    public CreateOrderResponse createOrder(
        @WebParam(partName = "createOrderRq", name = "createOrderRequest", targetNamespace = "http://mycompany.com/sp/definitions")
        CreateOrderRequest createOrderRq
    );
}
