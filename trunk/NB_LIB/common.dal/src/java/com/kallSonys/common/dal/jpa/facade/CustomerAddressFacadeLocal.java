/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.CustomerAddress;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Frank
 */
@Remote
public interface CustomerAddressFacadeLocal {

    void create(CustomerAddress customerAddress);

    void edit(CustomerAddress customerAddress);

    void remove(CustomerAddress customerAddress);

    CustomerAddress find(Object id);

    List<CustomerAddress> findAll();

    List<CustomerAddress> findRange(int[] range);

    int count();
    
}
