<?xml version='1.0' encoding='UTF-8' ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:icecore="http://www.icefaces.org/icefaces/core"
	xmlns:ace="http://www.icefaces.org/icefaces/components"
	xmlns:ice="http://www.icesoft.com/icefaces/component">
    <h:head>
        <title>OMS</title>
        <link rel="stylesheet" type="text/css" href="./xmlhttp/css/rime/rime.css"/>
      	<link rel="stylesheet" type="text/css" href="#{facesContext.externalContext.requestContextPath}/estilos.css" />
    </h:head>
    <h:body>
    <h:form>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td height="10" colspan="2">&nbsp;</td>
			</tr>
			<tr class="bl">
				<td height="56" colspan="2">
					
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<h:form name="formLogout">
								<ice:commandLink action="#{loginPageBean.logout}" >
										<img src="#{facesContext.externalContext.requestContextPath}/images/cerrar_sesion_off.gif" alt="Cerrar Sesión" name="cerrar_sesion_off" id="cerrar_sesion_off" width="120" height="21" border="0"/>
							   </ice:commandLink>							   
						   </h:form>
						</td>
						<td>
							<img src="#{facesContext.externalContext.requestContextPath}/images/drcho.gif" width="158" height="21"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<a href="indexJSP"><img src="#{facesContext.externalContext.requestContextPath}/images/Logo.png" width="120" alt="Portaflow" height="54" border="0"/></a>
						</td>
						<td align="right" valign="top">
							<img src="#{facesContext.externalContext.requestContextPath}/images/sp_foto.gif" width="588" height="54"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td class="az">
				<ui:include src="/menuHeader.xhtml"></ui:include>
			</td>
		</tr>
	</table>
	</td></tr>
	
	<tr class="bl">
				<td width="100%" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">					
    				<tr>
    				<td>
    				<table align="center">
	    				<tr>
	    					<td>
	    					 	<ice:outputLabel value="Su rol no posee permisos suficientes para ejecutar esta acción."/>
	    					</td>
	    				</tr>	    				
					</table>
					</td>
					</tr>
					</table>
				</td>
			</tr>
		</table>
		</h:form>
    </h:body>
</html>
