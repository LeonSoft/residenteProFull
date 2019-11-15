/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leonsoftware.residentepro.util.services;


import java.util.List;
import javax.ejb.Local;

import com.leonsoftware.residentepro.model.TbListaCatalogo;
import com.leonsoftware.residentepro.util.excepcion.GeneralException;

/**
 *
 * @author LeonSoftware 2019
 */

@Local
public interface CatalogoFacade {
    public List<TbListaCatalogo> obtenerListaCatalogo(String pNombreCatalogo) throws GeneralException;
    
}
