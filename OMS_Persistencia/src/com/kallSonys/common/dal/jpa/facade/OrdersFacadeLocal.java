/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.Orders;

/**
 *
 * @author Frank
 */
@Remote
public interface OrdersFacadeLocal {

    void create(Orders orders);
    
    boolean createAndConfirm(Orders orders);
    
    String createAndReturnID(Orders orders);

    void edit(Orders orders);

    void remove(Orders orders);

    Orders find(Object id);

    List<Orders> findAll();

    List<Orders> findRange(int[] range);

    int count();
    
    List<Orders> getOrderByCustomer (String customerID);
}
