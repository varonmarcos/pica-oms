package com.kallSonys.managedBeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import com.kallSonys.business.Interfaces.CustomerServiceLocal;
import com.kallSonys.web.util.SelectItemUtils;
import com.kallSonys.business.dto.CustomerDTO;
import com.kallSonys.business.dto.TipoTarjetaCreditoDTO;

/**
 * 
 * @author juanaranda
 *
 */
@ManagedBean(name="clientePageBean")
@RequestScoped
public class ClientePageBean{

	@EJB(mappedName="CustomerServiceBean")
	private CustomerServiceLocal customerServiceFacade;
	
	FacesContext context = FacesContext.getCurrentInstance();
	private boolean loaded=Boolean.FALSE;
	private List<SelectItem> listTipoTarjetas;
	private String tipoTarjetaCreditoSelected;
	private CustomerDTO customerDTO=new CustomerDTO();
		
	
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
		
		if(customerServiceFacade.createCustomer(this.customerDTO)){
			System.out.println("El usuario se creo con exito");
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

	public String getTipoTarjetaCreditoSelected() {
		return tipoTarjetaCreditoSelected;
	}

	public void setTipoTarjetaCreditoSelected(String tipoTarjetaCreditoSelected) {
		this.tipoTarjetaCreditoSelected = tipoTarjetaCreditoSelected;
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


}
