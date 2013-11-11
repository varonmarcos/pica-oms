package com.kallSonys.managedBeans;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import com.kallSonys.web.util.SelectItemUtils;
import com.kallSonys.web.vo.ClienteVO;
import com.kallSonys.web.vo.TipoTarjetaCreditoVO;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="clientePageBean")
@RequestScoped
public class ClientePageBean{

	FacesContext context = FacesContext.getCurrentInstance();
	private boolean loaded=Boolean.FALSE;
	private List<SelectItem> listTipoTarjetas;
	private String tipoTarjetaCreditoSelected;
	private ClienteVO clienteVO=new ClienteVO();
		
	
	public ClientePageBean(){
            setUpPrerender();
   	}
	
	
	private void setUpPrerender(){
		this.loadSelectItemTipoTarjeta();
		
	}
	
	private void loadSelectItemTipoTarjeta(){
		List<TipoTarjetaCreditoVO> tiposTarjetas=TipoTarjetaCreditoVO.preloadData();
		try {
			this.listTipoTarjetas=SelectItemUtils.buildSelectItems(tiposTarjetas, "idTipoTarjeta", "nombreTipoTarjeta", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doAgregarCliente(){
		System.out.println(this.clienteVO);
		String message = "El Usuario fue creado Correctamente"; 
	    context.addMessage(null, new FacesMessage(message));
		
	}
	
	
	/**
	 * Este metodo Inicializa el listado de tipo de tarjetas
	 */
	
	public List<SelectItem> getListTipoTarjetas() {
		return listTipoTarjetas;
	}

	public void setListTipoTarjetas(List<SelectItem> listTipoTarjetas) {
		this.listTipoTarjetas = listTipoTarjetas;
	}

	public String getTipoTarjetaCreditoSelected() {
		return tipoTarjetaCreditoSelected;
	}

	public void setTipoTarjetaCreditoSelected(String tipoTarjetaCreditoSelected) {
		this.tipoTarjetaCreditoSelected = tipoTarjetaCreditoSelected;
	}

	public ClienteVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}


	public boolean isLoaded() {
		return loaded;
	}


	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	
	

}
