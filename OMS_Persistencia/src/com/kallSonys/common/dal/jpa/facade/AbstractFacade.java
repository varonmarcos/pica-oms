/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kallSonys.common.dal.jpa.facade;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Frank
 */
public abstract class AbstractFacade<T> implements  IAbstractFacade<T>{
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    @Override
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    @Override
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery("select object(o) from " + entityClass.getSimpleName() + " as o").getResultList();
    }

    @Override
    public List<T> findRange(int[] range) {
        javax.persistence.Query q = getEntityManager().createQuery("select object(o) from " + entityClass.getSimpleName() + " as o");
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int count() {
        return ((Long) getEntityManager().createQuery("select count(o) from " + entityClass.getSimpleName() + " as o").getSingleResult()).intValue();
    }

    @Override
    public boolean createAndConfirm(T entity) 
    {
        try
        {
            getEntityManager().persist(entity);           
        }catch(Exception e){return false;}
        
        return true;
    }
    
}
