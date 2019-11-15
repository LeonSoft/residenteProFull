/**
 *
 * @author LeonSoftware 2017
 */
package com.leonsoftware.residentepro.util.cargaMensajes;


import com.leonsoftware.residentepro.util.services.CatalogoServiceImpl;

import java.util.ResourceBundle;
import java.util.logging.Logger;


/**
 * Clase de métodos utilitarios
 * @since 02/10/2017
 * @author Carolina Colorado
 * @version 1.0
 */
public class UtilitarioLeonSoftware {
    
    
    private final CatalogoServiceImpl EJBcatalogo = new CatalogoServiceImpl();

    public UtilitarioLeonSoftware() {
  
    }
        
    private static final Logger LOGGER = Logger.getLogger("UtilitarioLeonSoftware"); 


    /**
     * Método que carga archivo de mensajes
     * 
     * @return ResourceBundle
     */
    public ResourceBundle cargarMensajes(){
        LOGGER.info("LOGGER :: UtilitarioLeonSoftware :: cargarMensajes");           
        ResourceBundle mensajes = ResourceBundle.getBundle(ConstantesResidentePro.ARCHIVO_MENSAJES);                
        return  mensajes; 
    }       
    
}
