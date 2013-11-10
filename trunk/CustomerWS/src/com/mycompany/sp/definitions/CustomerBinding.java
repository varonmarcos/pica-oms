package com.mycompany.sp.definitions;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-09-04T23:41:38.854-05:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://mycompany.com/sp/definitions", name = "CustomerBinding")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerBinding {

    @WebResult(name = "RegisterCustomerResponse", targetNamespace = "http://mycompany.com/sp/definitions", partName = "RegisterCustomerRes")
    @WebMethod(operationName = "RegisterCustomer", action = "http://mycompany.com/RegisterCustomer")
    public RegisterCustomerResponse registerCustomer(
        @WebParam(partName = "RegisterCustomerReq", name = "RegisterCustomerRequest", targetNamespace = "http://mycompany.com/sp/definitions")
        RegisterCustomerRequest registerCustomerReq
    );
}
