package com.kallSonys.common.dal.jpa.facade.appSeg;

import java.util.List;

import javax.ejb.Remote;

import com.kallSonys.common.dal.jpa.entitys.AppUsuariosxrol;


/**
 * @generated DT_ID=none
 */
@Remote
public interface AppUsuariosxrolFacadeRemote
{

	
	
	 void create(AppUsuariosxrol appUsuariosxrol);

    void edit(AppUsuariosxrol appUsuariosxrol);

    void remove(AppUsuariosxrol appUsuariosxrol);

    AppUsuariosxrol find(Object id);

    List<AppUsuariosxrol> findAll();

    List<AppUsuariosxrol> findRange(int[] range);

    int count();

}
