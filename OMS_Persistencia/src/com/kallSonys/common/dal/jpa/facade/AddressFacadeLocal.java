/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Address;
import com.kallSonys.common.dal.jpa.entitys.Orders;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Frank
 */
@Remote
public interface AddressFacadeLocal {

    void create(Address address);
    
    boolean createAndConfirm(Address address); 
    
    String createAndReturnID(Address address);

    void edit(Address address);

    void remove(Address address);

    Address find(Object id);

    List<Address> findAll();

    List<Address> findRange(int[] range);

    int count();
    
}
