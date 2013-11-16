package com.kallSonys.common.dal.jpa.facade.appSeg;

import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.AppRequerimiento;
import com.kallSonys.common.dal.jpa.entitys.AppRol;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AppRolFacadeRemote
{


    void create(AppRol appRol);

    void edit(AppRol appRol);

    void remove(AppRol appRol);

    AppRol find(Object id);

    List<AppRol> findAll();

    List<AppRol> findRange(int[] range);

    int count();
	

}
