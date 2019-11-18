/*
 * @author LeonSoftware 2017
 */
package com.leonsoftware.residentepro.controller;


import java.io.Serializable;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.leonsoftware.residentepro.model.TbUsuario;
import com.leonsoftware.residentepro.services.UsuarioFacade;
import com.leonsoftware.residentepro.util.cargaMensajes.ConstantesResidentePro;
import com.leonsoftware.residentepro.util.cargaMensajes.UtilitarioLeonSoftware;
import com.leonsoftware.residentepro.util.excepcion.GeneralException;


/**
 * Clase para la gestion del formulario de autenticacion
 * @author Carolina Colorado
 * @since 31/08/2017 
 * @version 2.0
 */

@Named("inicioController")
@ViewScoped
public class InicioController implements Serializable{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger("InicioController");
	
	@EJB
    private UsuarioFacade EJBusuario;
    private TbUsuario usuario;
    private ResourceBundle mensajes;
    
    @PostConstruct
    public void init(){
	    LOGGER.info("LOGGER :: CargaArchivoClienteController :: init");
	    this.mensajes = new UtilitarioLeonSoftware().cargarMensajes();
	    this.usuario = new TbUsuario();
    }
    

	/**
     * Método que invoca la autenticacion de usuario
     * @return regla de navegación
     */
    public String iniciaSesion(){        
        String reglaNavega = null;
        TbUsuario usuarioAux;        
        try{
            usuarioAux = this.EJBusuario.buscarUsuario(this.usuario) ;
            if (usuarioAux != null){
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioAux);
                reglaNavega = "usuarioExiste";
            }else{
                throw new GeneralException(this.mensajes.getString(ConstantesResidentePro.MSJ_ERROR_AUTENTICACION)); 
            }
        }catch(GeneralException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, e.getMessage(), e.getMessage()));
        }  
        return reglaNavega;
    }
    
	public String loggout (){
	    return "pagesResidente/inicio";
	}

    
    /*
    * Metodos SET y GET
    */

	public TbUsuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(TbUsuario usuario) {
		this.usuario = usuario;
	}
	
	public UsuarioFacade getEJBusuario() {
		return EJBusuario;
	}
	public void setEJBusuario(UsuarioFacade eJBusuario) {
		EJBusuario = eJBusuario;
	}
    public ResourceBundle getMensajes() {
		return mensajes;
	}
	public void setMensajes(ResourceBundle mensajes) {
		this.mensajes = mensajes;
	}

}
