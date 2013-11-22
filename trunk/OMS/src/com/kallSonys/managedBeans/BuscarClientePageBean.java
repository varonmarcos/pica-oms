package com.kallSonys.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import weblogic.xml.xpath.stream.axes.EverythingAxis;


import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.web.consts.Constantes;
import com.kallSonys.web.util.SelectItemUtils;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.dto.TipoTarjetaCreditoDTO;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="buscarClientePageBean")
@RequestScoped
public class BuscarClientePageBean{

	@EJB(mappedName="CustomerServiceBean")
	private CustomerServiceLocal customerServiceFacade;
	
	FacesContext context = FacesContext.getCurrentInstance();
	
	private CustomerDTO customerDTO=new CustomerDTO();
	private String selectedFilter=Constantes.IDENTIFICACION_FILTER;
	private boolean renderIdentificacion=Boolean.FALSE;
	private boolean renderProducto=Boolean.TRUE;
	private boolean renderFacturacion=Boolean.TRUE;
		
	
	public boolean isRenderIdentificacion() {
		return renderIdentificacion;
	}


	public void setRenderIdentificacion(boolean renderIdentificacion) {
		this.renderIdentificacion = renderIdentificacion;
	}


	public boolean isRenderProducto() {
		return renderProducto;
	}


	public void setRenderProducto(boolean renderProducto) {
		this.renderProducto = renderProducto;
	}


	public boolean isRenderFacturacion() {
		return renderFacturacion;
	}


	public void setRenderFacturacion(boolean renderFacturacion) {
		this.renderFacturacion = renderFacturacion;
	}

	/**
	 * Minimal Constructor
	 */
	public BuscarClientePageBean(){
           
   	}
	
	/**
	 * Este metodo realiza la busqueda de clientes
	 */
	public void doBuscarCliente(){
	
		
		
	}
	
	/**
	 * Este metodo se encarga de mostrar las caja de texto
	 * @param event
	 */
	public void viewFilterFields(ValueChangeEvent event){
		if(Constantes.IDENTIFICACION_FILTER.equals(event.getNewValue())){
			this.setRenderProducto(Boolean.TRUE);
			this.setRenderFacturacion(Boolean.TRUE);
			this.setRenderIdentificacion(Boolean.FALSE);
		}else if(Constantes.FACTURACION_FILTER.equals(event.getNewValue())){
			this.setRenderProducto(Boolean.TRUE);
			this.setRenderFacturacion(Boolean.FALSE);
			this.setRenderIdentificacion(Boolean.TRUE);
		}else if(Constantes.PRODUCTO_FILTER.equals(event.getNewValue())){
			this.setRenderProducto(Boolean.FALSE);
			this.setRenderFacturacion(Boolean.TRUE);
			this.setRenderIdentificacion(Boolean.TRUE);
		}
		
	}
	

	
	
	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setClienteVO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}


	public CustomerServiceLocal getCustomerServiceFacade() {
		return customerServiceFacade;
	}


	public void setCustomerServiceFacade(CustomerServiceLocal customerServiceFacade) {
		this.customerServiceFacade = customerServiceFacade;
	}


	public String getSelectedFilter() {
		return selectedFilter;
	}


	public void setSelectedFilter(String selectedFilter) {
		this.selectedFilter = selectedFilter;
	}


	public void setCustomerDTO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}


}
