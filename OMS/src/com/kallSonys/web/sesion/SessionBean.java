package com.kallSonys.web.sesion;

import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.kallSonys.business.dto.UserDTO;


@ManagedBean(name="sessionBean")
@SessionScoped
public class SessionBean {

	private static final long serialVersionUID = 2356312790334503309L;
	
	private static SessionBean sessionInstance;
	
	private static String SESSION_PATH_PROPERTIES = "com/kallSonys/web/properties/config.properties";
	private boolean showFormCrearProducto;
	private boolean showFormConsultarProducto;
	private boolean showFormCrearCliente;
	private boolean showFormConsultaCliente;
	private boolean showFormCrearCampana;
	private boolean showFormConsultaCampana;
	private UserDTO userInSession;
	private String msgCustomerCreatedOk;
	private Properties properties;
	
	
	public static synchronized SessionBean getInstance()
	{
		if (sessionInstance == null){
			sessionInstance = new SessionBean();
			sessionInstance.loadPropertiesFile();
		}
		
		return sessionInstance;
		
		
		
	}
	
	public void loadPropertiesFile(){
		
		try{
			this.properties.load(new FileInputStream("config.properties"));
		}catch (Exception e){
			
		}
		
	}
	
	public boolean isShowFormCrearProducto() {
		return showFormCrearProducto;
	}

	public void setShowFormCrearProducto(boolean showFormCrearProducto) {
		this.showFormCrearProducto = showFormCrearProducto;
	}

	public boolean isShowFormConsultarProducto() {
		return showFormConsultarProducto;
	}

	public void setShowFormConsultarProducto(boolean showFormConsultarProducto) {
		this.showFormConsultarProducto = showFormConsultarProducto;
	}

	public boolean isShowFormCrearCliente() {
		return showFormCrearCliente;
	}

	public void setShowFormCrearCliente(boolean showFormCrearCliente) {
		this.showFormCrearCliente = showFormCrearCliente;
	}

	public boolean isShowFormConsultaCliente() {
		return showFormConsultaCliente;
	}

	public void setShowFormConsultaCliente(boolean showFormConsultaCliente) {
		this.showFormConsultaCliente = showFormConsultaCliente;
	}

	public boolean isShowFormCrearCampana() {
		return showFormCrearCampana;
	}

	public void setShowFormCrearCampana(boolean showFormCrearCampana) {
		this.showFormCrearCampana = showFormCrearCampana;
	}

	public boolean isShowFormConsultaCampana() {
		return showFormConsultaCampana;
	}

	public void setShowFormConsultaCampana(boolean showFormConsultaCampana) {
		this.showFormConsultaCampana = showFormConsultaCampana;
	}

	public UserDTO getUserInSession() {
		return userInSession;
	}

	public void setUserInSession(UserDTO userInSession) {
		this.userInSession = userInSession;
	}


	public static SessionBean getSessionInstance() {
		return sessionInstance;
	}


	public static void setSessionInstance(SessionBean sessionInstance) {
		SessionBean.sessionInstance = sessionInstance;
	}


	public static String getSESSION_PATH_PROPERTIES() {
		return SESSION_PATH_PROPERTIES;
	}


	public static void setSESSION_PATH_PROPERTIES(String sESSION_PATH_PROPERTIES) {
		SESSION_PATH_PROPERTIES = sESSION_PATH_PROPERTIES;
	}


	public String getMsgCustomerCreatedOk() {
		this.properties.get("CREACION_CLIENTE_OK");
		return msgCustomerCreatedOk;
	}


	public void setMsgCustomerCreatedOk(String msgCustomerCreatedOk) {
		this.msgCustomerCreatedOk = msgCustomerCreatedOk;
	}
	
	
	

}
