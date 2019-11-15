package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_usuario database table.
 * 
 */
@Embeddable
public class TbUsuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="tipo_id_usuario")
	private String tipoIdUsuario;

	@Column(name="tb_perfil_id_perfil", insertable=false, updatable=false)
	private String tbPerfilIdPerfil;

	public TbUsuarioPK() {
	}
	public int getIdUsuario() {
		return this.idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getTipoIdUsuario() {
		return this.tipoIdUsuario;
	}
	public void setTipoIdUsuario(String tipoIdUsuario) {
		this.tipoIdUsuario = tipoIdUsuario;
	}
	public String getTbPerfilIdPerfil() {
		return this.tbPerfilIdPerfil;
	}
	public void setTbPerfilIdPerfil(String tbPerfilIdPerfil) {
		this.tbPerfilIdPerfil = tbPerfilIdPerfil;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbUsuarioPK)) {
			return false;
		}
		TbUsuarioPK castOther = (TbUsuarioPK)other;
		return 
			(this.idUsuario == castOther.idUsuario)
			&& this.tipoIdUsuario.equals(castOther.tipoIdUsuario)
			&& this.tbPerfilIdPerfil.equals(castOther.tbPerfilIdPerfil);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idUsuario;
		hash = hash * prime + this.tipoIdUsuario.hashCode();
		hash = hash * prime + this.tbPerfilIdPerfil.hashCode();
		
		return hash;
	}
}