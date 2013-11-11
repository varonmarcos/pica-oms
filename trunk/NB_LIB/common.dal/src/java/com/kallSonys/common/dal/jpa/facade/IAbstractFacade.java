/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Indra
 */
@Remote
public interface IAbstractFacade<T> {

    int count();

    void create(T entity);

    void edit(T entity);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int[] range);

    void remove(T entity);
    
    boolean createAndConfirm(T entity);
    
}
