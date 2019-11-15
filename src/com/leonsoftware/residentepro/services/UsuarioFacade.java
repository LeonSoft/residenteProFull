package com.leonsoftware.residentepro.services;


import javax.ejb.Local;

import com.leonsoftware.residentepro.model.TbUsuario;
import com.leonsoftware.residentepro.util.excepcion.GeneralException;

@Local
public interface UsuarioFacade {
	
	TbUsuario buscarUsuario (TbUsuario pUsuario) throws GeneralException;

}
