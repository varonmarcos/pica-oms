
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.mycompany.sp.definitions;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-11-10T01:47:01.872-05:00
 * Generated source version: 2.7.6
 * 
 */

@javax.jws.WebService(
                      serviceName = "Customer",
                      portName = "customerServicePort",
                      targetNamespace = "http://mycompany.com/sp/definitions",
                      wsdlLocation = "http://localhost:8081/CustomerWS/services/customerServicePort?wsdl",
                      endpointInterface = "com.mycompany.sp.definitions.CustomerBinding")
                      
public class CustomerBindingImpl implements CustomerBinding {

    private static final Logger LOG = Logger.getLogger(CustomerBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.mycompany.sp.definitions.CustomerBinding#getCustomer(com.mycompany.sp.definitions.GetCustomerRequest  getCustomerReq )*
     */
    public com.mycompany.sp.definitions.GetCustomerResponse getCustomer(GetCustomerRequest getCustomerReq) { 
        LOG.info("Executing operation getCustomer");
        System.out.println(getCustomerReq);
        try {
            com.mycompany.sp.definitions.GetCustomerResponse _return = new com.mycompany.sp.definitions.GetCustomerResponse();
            com.mycompany.sp.definitions.GetCustomerRes _returnGetCustomerRes = new com.mycompany.sp.definitions.GetCustomerRes();
            com.mycompany.sp.definitions.CustomerType _returnGetCustomerResCustomer = new com.mycompany.sp.definitions.CustomerType();
            _returnGetCustomerResCustomer.setCustId("CustId1990180453");
            _returnGetCustomerResCustomer.setFName("FName-991342081");
            _returnGetCustomerResCustomer.setLName("LName-1561760915");
            _returnGetCustomerResCustomer.setPhoneNumber(Long.valueOf(4808461085766565093l));
            _returnGetCustomerResCustomer.setEmail("Email-2028390645");
            _returnGetCustomerResCustomer.setPassword("Password-535916357");
            _returnGetCustomerResCustomer.setCreditCardType("CreditCardType1218473850");
            _returnGetCustomerResCustomer.setCreditCardNumber("CreditCardNumber-733876744");
            _returnGetCustomerResCustomer.setStatus("Plateado");
            _returnGetCustomerRes.setCustomer(_returnGetCustomerResCustomer);
            _return.setGetCustomerRes(_returnGetCustomerRes);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see com.mycompany.sp.definitions.CustomerBinding#registerCustomer(com.mycompany.sp.definitions.RegisterCustomerRequest  registerCustomerReq )*
     */
    public com.mycompany.sp.definitions.RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerReq) { 
        LOG.info("Executing operation registerCustomer");
        System.out.println(registerCustomerReq);
        try {
            com.mycompany.sp.definitions.RegisterCustomerResponse _return = new com.mycompany.sp.definitions.RegisterCustomerResponse();
            com.mycompany.sp.definitions.RegisterCustomerRes _returnRegisterCustomerRes = new com.mycompany.sp.definitions.RegisterCustomerRes();
            _returnRegisterCustomerRes.setCodigo("Codigo897135027");
            _returnRegisterCustomerRes.setDescripcion("Descripcion-1900939579");
            _return.setRegisterCustomerRes(_returnRegisterCustomerRes);
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
