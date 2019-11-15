package com.leonsoftware.residentepro.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import com.leonsoftware.residentepro.model.TbUsuario;
import com.leonsoftware.residentepro.util.excepcion.GeneralException;

/**
 * Session Bean implementation class UsuarioFacade
 */
@Stateful
public class UsuarioServiceImpl implements UsuarioFacade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8092549001575775773L;
	
	@PersistenceContext(unitName = "residente_pu", type = PersistenceContextType.EXTENDED)
    private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UsuarioServiceImpl() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public TbUsuario buscarUsuario(TbUsuario pUsuario) throws GeneralException{  
    	TbUsuario usuario = null;
    	List<TbUsuario> listaUsuario;
    	Query consulta = em.createQuery("SELECT u FROM TbUsuario u WHERE u.usuario = :usuario AND u.claveUsuario = :claveUsuario ");
    	consulta.setParameter("usuario", pUsuario.getUsuario().trim());
    	consulta.setParameter("claveUsuario", pUsuario.getClaveUsuario().trim());                                   
        listaUsuario = consulta.getResultList();
        if(!listaUsuario.isEmpty()){
            usuario = listaUsuario.get(0);
        }
        return usuario;
    }   
    
    public EntityManager getEm() {
        return em;
    }

}
