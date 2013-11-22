package com.kallSonys.managedBeans;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import weblogic.jms.extensions.ConsumerInfo;
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
	private String patternDate=Constantes.DATE_FORMAT_PATTERN;
	private boolean renderIdentificacion=Boolean.FALSE;
	private boolean renderProducto=Boolean.TRUE;
	private boolean renderFacturacion=Boolean.TRUE;
	//Atributos por filters
	private String identificacion;
	private String idProducto;
	private Date fechaInicio;
	private Date fechaFin;
	
	
		
	
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
		Map<String,Object> paramters = new HashMap<String, Object>();
		if(Constantes.IDENTIFICACION_FILTER.equals(this.selectedFilter)){
			paramters.put(Constantes.IDENTIFICACION_FILTER,this.identificacion);
		}else if(Constantes.PRODUCTO_FILTER.equals(this.selectedFilter)){
			paramters.put(Constantes.PRODUCTO_FILTER,this.identificacion);
		}else{
			paramters.put(Constantes.FECHA_INICIAL,this.fechaInicio);
			paramters.put(Constantes.FECHA_FIN,this.fechaFin);
		}
		paramters.put(Constantes.FILTER,this.selectedFilter);
		this.customerServiceFacade.getCustomerByIdentificador(paramters);
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


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getPatternDate() {
		return patternDate;
	}


	public void setPatternDate(String patternDate) {
		this.patternDate = patternDate;
	}

	

}
