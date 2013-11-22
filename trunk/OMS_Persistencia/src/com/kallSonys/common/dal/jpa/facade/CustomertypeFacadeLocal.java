/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import com.kallSonys.common.dal.jpa.entitys.Customertype;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Frank
 */
@Remote
public interface CustomertypeFacadeLocal {

    void create(Customertype customertype);
    
    boolean createAndConfirm(Customertype customertype) ;

    void edit(Customertype customertype);

    void remove(Customertype customertype);

    Customertype find(Object id);

    List<Customertype> findAll();

    List<Customertype> findRange(int[] range);

    int count();
    
}
