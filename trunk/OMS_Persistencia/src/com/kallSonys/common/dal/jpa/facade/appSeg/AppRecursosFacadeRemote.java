package com.kallSonys.common.dal.jpa.facade.appSeg;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.AppRecurso;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AppRecursosFacadeRemote
{     
    void create(AppRecurso appRecurso);

    void edit(AppRecurso appRecurso);

    void remove(AppRecurso appRecurso);

    AppRecurso find(Object id);

    List<AppRecurso> findAll();

    List<AppRecurso> findRange(int[] range);

    int count();
    
    public List<AppRecurso> findRecursosByUser(String emailUserID);

}
