/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;


import java.util.List;
import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.Items;

/**
 *
 * @author Frank
 */
@Remote
public interface ItemsFacadeLocal {

    void create(Items items);

    void edit(Items items);

    void remove(Items items);

    Items find(Object id);

    List<Items> findAll();

    List<Items> findRange(int[] range);

    int count();
    
}
