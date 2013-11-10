package com.kallsonys.mock.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public final class PersistenceFile {
	
	public static final void writeFile(Customer customer){
		try {
							
			File file = new File("C:/PersistenceCustomers/Customers.txt");
 			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Fecha de Registro :"+new Date()+"\n");
			bw.write("ID :"+customer.getCustid()+"\n");
			bw.write("Nombre :"+customer.getFname()+"\n");
			bw.write("Apellido :"+customer.getLname()+"\n");
			bw.write("E-mail :"+customer.getEmail()+"\n");
			bw.write("Telefono :"+customer.getPhoneNumber()+"\n");
			bw.write("Password :"+customer.getPassword()+"\n");
			bw.write("\n");
			
			bw.close();
 
			System.out.println("Done");
 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
