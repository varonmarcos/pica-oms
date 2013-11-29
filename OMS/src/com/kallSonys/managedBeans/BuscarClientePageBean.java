package com.kallSonys.managedBeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.dto.StatusCustomerDTO;
import com.kallSonys.web.consts.Constantes;
import com.kallSonys.web.util.SelectItemUtils;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="buscarClientePageBean")
@CustomScoped(value = "#{window}")
public class BuscarClientePageBean{

	@EJB(mappedName="CustomerServiceBean")
	private CustomerServiceLocal customerServiceFacade;
	
	
	private CustomerDTO customerDTO;
	private List<CustomerDTO> listCustomers;
	private String selectedFilter=Constantes.IDENTIFICACION_FILTER;
	private String patternDate=Constantes.DATE_FORMAT_PATTERN;
	private boolean renderIdentificacion=Boolean.FALSE;
	private boolean renderProducto=Boolean.TRUE;
	private boolean renderFacturacion=Boolean.TRUE;
	private boolean renderTableCustomer=Boolean.FALSE;
	private boolean renderFormModifiedCustomer=Boolean.FALSE;
	private CustomerDTO customerSelected;
	private List<SelectItem> listStatusCustomer;
	private List<SelectItem> listCustomerType;
	private String statusSelected;
	private String customerTypeSelected;
	public String getStatusSelected() {
		return statusSelected;
	}


	public void setStatusSelected(String statusSelected) {
		this.statusSelected = statusSelected;
	}


	public String getCustomerTypeSelected() {
		return customerTypeSelected;
	}


	public void setCustomerTypeSelected(String customerTypeSelected) {
		this.customerTypeSelected = customerTypeSelected;
	}


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
		this.customerDTO=new CustomerDTO();
		this.listCustomers=new ArrayList<CustomerDTO>();
           
   	}
	
	/**
	 * Este metodo realiza la busqueda de clientes
	 */
	public void doBuscarCliente(){
		try{
			Map<String,Object> paramters = new HashMap<String, Object>();
			if(Constantes.IDENTIFICACION_FILTER.equals(this.selectedFilter))
			{
				paramters.put(Constantes.IDENTIFICACION_FILTER,this.identificacion);
				this.listCustomers=this.customerServiceFacade.getCustomerByIdentificador(paramters);
			
			}
			else if(Constantes.PRODUCTO_FILTER.equals(this.selectedFilter))
			{
				paramters.put(Constantes.PRODUCTO_FILTER,this.idProducto);
				this.listCustomers=this.customerServiceFacade.getCustomerByIdProduct(paramters);
			}else
			{
				paramters.put(Constantes.FECHA_INICIAL,this.fechaInicio);
				paramters.put(Constantes.FECHA_FIN,this.fechaFin);
				this.listCustomers=this.customerServiceFacade.getCustomerByIdFacturacion(paramters);
			}
						
			if(this.listCustomers.size()>0){
				this.renderTableCustomer=Boolean.TRUE;
			}else{
				this.renderTableCustomer=Boolean.FALSE;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
	/**
	 * Este metodo se encarga de mostrar las caja de texto
	 * @param event
	 */
	public void viewFilterFields(ValueChangeEvent event){
		try{
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
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void customerSelectionListener() {

	    this.customerSelected=this.getCustomerSelected();
	    this.statusSelected=this.customerSelected.getEstadoCliente();
	    this.customerTypeSelected=this.customerSelected.getTipoCliente();
	    this.renderFormModifiedCustomer=Boolean.TRUE;
	    this.loadSelectItemStatusCustomer();
	       
	}
	/**
	 * Este metodo construye el listado de status cliente
	 */
	private void loadSelectItemStatusCustomer(){
		List<StatusCustomerDTO> tiposStatus=StatusCustomerDTO.preloadData();
		try {
			this.listStatusCustomer=SelectItemUtils.buildSelectItems(tiposStatus, "codigo", "descripcion", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doModificarCliente(){
		try{
			this.customerSelected=this.getSpecifiedCustomer(customerSelected);
			Boolean response=this.customerServiceFacade.doUpdateCustomer(this.customerSelected);
			if(response){
				this.renderFormModifiedCustomer=Boolean.FALSE;
				this.addMessageToView();
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private CustomerDTO getSpecifiedCustomer(CustomerDTO cus){
		for(CustomerDTO c:this.listCustomers)
		{
			if(c.getIdCliente().equals(cus.getIdCliente()))
			{
				return c;
			}
		}
		return null;
	}
	
	
	private void addMessageToView(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null,new FacesMessage("Cliente modificado exitosamente"));
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


	public boolean isRenderTableCustomer() {
		return renderTableCustomer;
	}


	public void setRenderTableCustomer(boolean renderTableCustomer) {
		this.renderTableCustomer = renderTableCustomer;
	}


	public List<CustomerDTO> getListCustomers() {
		return listCustomers;
	}


	public void setListCustomers(List<CustomerDTO> listCustomers) {
		this.listCustomers = listCustomers;
	}


	public CustomerDTO getCustomerSelected() {
		return customerSelected;
	}


	public void setCustomerSelected(CustomerDTO customerSelected) {
		this.customerSelected = customerSelected;
	}


	public boolean isRenderFormModifiedCustomer() {
		return renderFormModifiedCustomer;
	}


	public void setRenderFormModifiedCustomer(boolean renderFormModifiedCustomer) {
		this.renderFormModifiedCustomer = renderFormModifiedCustomer;
	}


	public List<SelectItem> getListStatusCustomer() {
		return listStatusCustomer;
	}


	public void setListStatusCustomer(List<SelectItem> listStatusCustomer) {
		this.listStatusCustomer = listStatusCustomer;
	}

	public List<SelectItem> getListCustomerType() {
		return listCustomerType;
	}


	public void setListCustomerType(List<SelectItem> listCustomerType) {
		this.listCustomerType = listCustomerType;
	}


}
