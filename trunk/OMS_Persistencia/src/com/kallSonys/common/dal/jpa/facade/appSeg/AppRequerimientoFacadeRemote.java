package com.kallSonys.common.dal.jpa.facade.appSeg;

import java.util.List;

import com.kallSonys.common.dal.jpa.entitys.AppRequerimiento;
import javax.ejb.Remote;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AppRequerimientoFacadeRemote
{

    void create(AppRequerimiento appRequerimiento);

    void edit(AppRequerimiento appRequerimiento);

    void remove(AppRequerimiento appRequerimiento);

    AppRequerimiento find(Object id);

    List<AppRequerimiento> findAll();

    List<AppRequerimiento> findRange(int[] range);

    int count();

}
