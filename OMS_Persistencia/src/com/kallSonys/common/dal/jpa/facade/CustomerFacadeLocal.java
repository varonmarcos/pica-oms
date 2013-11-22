/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.Customer;

/**
 *
 * @author Frank
 */
@Remote
public interface CustomerFacadeLocal {

    void create(Customer customer);

    boolean createAndConfirm(Customer customer);
    
    String createAndReturnID(Customer customer);
    
    void edit(Customer customer);

    void remove(Customer customer);

    Customer find(Object id);

    List<Customer> findAll();

    List<Customer> findRange(int[] range);

    int count();
    
}
