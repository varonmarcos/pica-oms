/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;


import java.util.List;
import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.Item;

/**
 *
 * @author Frank
 */
@Remote
public interface ItemsFacadeLocal {

    void create(Item items);

    void edit(Item items);

    void remove(Item items);

    Item find(Object id);

    List<Item> findAll();

    List<Item> findRange(int[] range);

    int count();
    
}
