/**
 * 
 */
package com.kallSonys.business.test;

import java.util.ArrayList;
import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.Customer;

/**
 * @author Juan Pablo Aranda Galvis
 *
 */
public class ReturnEntitiesTest {
	
	
	public static List<Customer> returnCustomerByProductId(){
		Customer customer1=new Customer();
		customer1.setCustid("cus1");
		customer1.setFname("Juan Pablo Aranda Galvis");
		customer1.setEmail("juan.aranda.galvis@gmail.com");
		customer1.setPhonenumber("3017301496");
		customer1.setStatus("Platino");
		customer1.setCreditcardnumer("2345678876542345");
		Customer customer2=new Customer();
		customer2.setCustid("cus2");
		customer2.setFname("Frank Arregoces");
		customer2.setEmail("frank@gmail.com");
		customer2.setPhonenumber("3017301496");
		customer2.setStatus("Platino");
		customer2.setCreditcardnumer("2345678876542345");
		List<Customer> listCustomer=new ArrayList<Customer>();
		listCustomer.add(customer1);
		listCustomer.add(customer2);
		return listCustomer;
	}

}
