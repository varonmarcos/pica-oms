package com.sony.sony;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-11T12:33:33.536-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://www.sony.com/sony/", name = "SonyOrderService")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SonyOrderService {

    @WebResult(name = "orderQuouteResponseElement", targetNamespace = "http://www.sony.com/sony/", partName = "parameters")
    @WebMethod(action = "http://www.sony.com/sony/orderQuoute")
    public OrderQuouteResponseElement orderQuoute(
        @WebParam(partName = "parameters", name = "orderQuouteElement", targetNamespace = "http://www.sony.com/sony/")
        OrderQuouteElement parameters
    );
}
