/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Address;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Frank
 */
@Stateless(name="AddressFacadeBean", mappedName = "AddressFacadeBean")
@Remote(AddressFacadeLocal.class)
public class AddressFacade extends AbstractFacade<Address> implements AddressFacadeLocal {
    @PersistenceContext(unitName = "OMS_Persistencia")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AddressFacade() {
        super(Address.class);
    }

	@Override
	public String createAndReturnID(Address address) 
	{		
	  try
        {
            getEntityManager().persist(address);  
            getEntityManager().flush(); 
            String id = address.getAddrid();
            System.out.println("ID DE ADRRESS CREADO: "+id);
            return id;
        }
        catch(Exception e)
        {
        	System.out.println("ERROR:AddressFacade:createAndReturnID: "+e.getMessage());
        	return null;
        }
	}  
}
