
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.mycompany.sp.definitions;

import java.util.logging.Logger;

import com.kallsonys.mock.persistence.Customer;
import com.kallsonys.mock.persistence.PersistenceFile;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-09-04T23:41:38.690-05:00
 * Generated source version: 2.7.6
 * 
 */

@javax.jws.WebService(
                      serviceName = "Customer",
                      portName = "customerServicePort",
                      targetNamespace = "http://mycompany.com/sp/definitions",
                      wsdlLocation = "http://localhost:8080/CustomerWS/services/customerServicePort?wsdl",
                      endpointInterface = "com.mycompany.sp.definitions.CustomerBinding")
                      
public class CustomerBindingImpl implements CustomerBinding {

    private static final Logger LOG = Logger.getLogger(CustomerBindingImpl.class.getName());

    /* (non-Javadoc)
     * @see com.mycompany.sp.definitions.CustomerBinding#registerCustomer(com.mycompany.sp.definitions.RegisterCustomerRequest  registerCustomerReq )*
     */
    public RegisterCustomerResponse registerCustomer(RegisterCustomerRequest registerCustomerReq) { 
        LOG.info("Executing operation registerCustomer");
        System.out.println(registerCustomerReq);
        try {
        	 RegisterCustomerResponse response = new RegisterCustomerResponse();
             RegisterCustomerRes returnRegisterCustomerRes = new RegisterCustomerRes();
             returnRegisterCustomerRes.setCodigo("COD000");
             returnRegisterCustomerRes.setDescripcion("El Registro se realizo correctamente");
             response.setRegisterCustomerRes(returnRegisterCustomerRes);
             persistCustomerData(registerCustomerReq);
            return response;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    
    private void persistCustomerData(RegisterCustomerRequest request)
    {
    	Customer cus=populateCustomer(request);
    	PersistenceFile.writeFile(cus);
    }
    
    private Customer populateCustomer(RegisterCustomerRequest request){
    	
    	Customer cus=new Customer();
    	cus.setCustid(request.registerCustomerReq.customer.custId);
    	cus.setFname(request.registerCustomerReq.customer.fName);
    	cus.setLname(request.registerCustomerReq.customer.lName);
    	cus.setEmail(request.registerCustomerReq.customer.email);
    	//cus.setPhoneNumber(request.registerCustomerReq.customer.phoneNumber);
    	cus.setPassword(request.registerCustomerReq.customer.password);
    	
		return cus;
	}

}
