package com.kallSonys.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;



import com.kallSonys.business.Serv.CustomerServiceLocal;
import com.kallSonys.web.util.SelectItemUtils;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.dto.TipoTarjetaCreditoDTO;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="clientePageBean")
@CustomScoped(value = "#{window}")
public class ClientePageBean{

	@EJB(mappedName="CustomerServiceBean")
	private CustomerServiceLocal customerServiceFacade;
	
	FacesContext context = FacesContext.getCurrentInstance();
	private boolean loaded=Boolean.FALSE;
	private List<SelectItem> listTipoTarjetas;
	private CustomerDTO customerDTO=new CustomerDTO();
	private String selectedFilter;
	private boolean renderIdentificacion=Boolean.TRUE;
	private boolean renderProducto=Boolean.FALSE;
	private boolean renderFacturacion=Boolean.FALSE;
		
	
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


	public ClientePageBean(){
            setUpPrerender();
   	}
	
	
	private void setUpPrerender(){
		this.loadSelectItemTipoTarjeta();
		
	}
	
	private void loadSelectItemTipoTarjeta(){
		List<TipoTarjetaCreditoDTO> tiposTarjetas=TipoTarjetaCreditoDTO.preloadData();
		try {
			this.listTipoTarjetas=SelectItemUtils.buildSelectItems(tiposTarjetas, "idTipoTarjeta", "nombreTipoTarjeta", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void doAgregarCliente(){
		try{
			if(customerServiceFacade.createCustomer(this.customerDTO))
			{
				context.addMessage("",new FacesMessage(FacesMessage.FACES_MESSAGES,"Cliente creado con exito"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void viewFilterFields(ValueChangeEvent event){
		if("id".equals(event.getNewValue())){
			this.setRenderProducto(Boolean.FALSE);
			this.setRenderFacturacion(Boolean.FALSE);
			this.setRenderIdentificacion(Boolean.TRUE);
		}else if("fac".equals(event.getNewValue())){
			this.setRenderProducto(Boolean.FALSE);
			this.setRenderFacturacion(Boolean.TRUE);
			this.setRenderIdentificacion(Boolean.FALSE);
		}else if("pro".equals(event.getNewValue())){
			this.setRenderProducto(Boolean.TRUE);
			this.setRenderFacturacion(Boolean.FALSE);
			this.setRenderIdentificacion(Boolean.FALSE);
		}
		
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

	public CustomerDTO getCustomerDTO() {
		return customerDTO;
	}

	public void setClienteVO(CustomerDTO customerDTO) {
		this.customerDTO = customerDTO;
	}


	public boolean isLoaded() {
		return loaded;
	}


	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
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
