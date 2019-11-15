/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonsoftware.residentepro.util.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.leonsoftware.residentepro.model.TbCatalogo;
import com.leonsoftware.residentepro.model.TbListaCatalogo;
import com.leonsoftware.residentepro.util.excepcion.GeneralException;

/**
 *
 * @author LeonSoftware 2017
 */
@Stateful
public class CatalogoServiceImpl implements CatalogoFacade, Serializable {

        
	/**
	 * 
	 */
	private static final long serialVersionUID = 3020743897612033186L;
	@PersistenceContext(unitName = "residente_pu", type = PersistenceContextType.EXTENDED)
    private EntityManager em;


    /**
     * Metodo para acceder a los registros de los catalogos
     * @param pNombreCatalogo
     * @return listaCatalogo
     * @throws SisgriException 
     */
    @Override
  public List<TbListaCatalogo> obtenerListaCatalogo(String pNombreCatalogo) throws GeneralException{
        TbCatalogo catalogo = null; 
        List<TbListaCatalogo> listaCatalogo = null;        
        try{   
            Query q = (TypedQuery<TbCatalogo>) em.createNamedQuery("Catalogo.findByIdCatalogo").setParameter("idCatalogo", pNombreCatalogo.trim());           
            catalogo = (TbCatalogo) q.getSingleResult();                
            if(catalogo != null){
                listaCatalogo = (List<TbListaCatalogo>) catalogo.getTbListaCatalogos();
            }
        }catch(Exception e) {
            throw new GeneralException(e.getMessage());            
        }      
       return listaCatalogo;       
    }
    
}
