package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_modulo_perfil database table.
 * 
 */
@Embeddable
public class TbModuloPerfilPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tb_modulo_id_modulo", insertable=false, updatable=false)
	private String tbModuloIdModulo;

	@Column(name="tb_perfil_id_perfil", insertable=false, updatable=false)
	private String tbPerfilIdPerfil;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private java.util.Date fechaCreacion;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private java.util.Date fechaModificacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	public TbModuloPerfilPK() {
	}
	public String getTbModuloIdModulo() {
		return this.tbModuloIdModulo;
	}
	public void setTbModuloIdModulo(String tbModuloIdModulo) {
		this.tbModuloIdModulo = tbModuloIdModulo;
	}
	public String getTbPerfilIdPerfil() {
		return this.tbPerfilIdPerfil;
	}
	public void setTbPerfilIdPerfil(String tbPerfilIdPerfil) {
		this.tbPerfilIdPerfil = tbPerfilIdPerfil;
	}
	public java.util.Date getFechaCreacion() {
		return this.fechaCreacion;
	}
	public void setFechaCreacion(java.util.Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	public java.util.Date getFechaModificacion() {
		return this.fechaModificacion;
	}
	public void setFechaModificacion(java.util.Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}
	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbModuloPerfilPK)) {
			return false;
		}
		TbModuloPerfilPK castOther = (TbModuloPerfilPK)other;
		return 
			this.tbModuloIdModulo.equals(castOther.tbModuloIdModulo)
			&& this.tbPerfilIdPerfil.equals(castOther.tbPerfilIdPerfil)
			&& this.fechaCreacion.equals(castOther.fechaCreacion)
			&& this.usuarioCreacion.equals(castOther.usuarioCreacion)
			&& this.fechaModificacion.equals(castOther.fechaModificacion)
			&& this.usuarioModificacion.equals(castOther.usuarioModificacion);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tbModuloIdModulo.hashCode();
		hash = hash * prime + this.tbPerfilIdPerfil.hashCode();
		hash = hash * prime + this.fechaCreacion.hashCode();
		hash = hash * prime + this.usuarioCreacion.hashCode();
		hash = hash * prime + this.fechaModificacion.hashCode();
		hash = hash * prime + this.usuarioModificacion.hashCode();
		
		return hash;
	}
}