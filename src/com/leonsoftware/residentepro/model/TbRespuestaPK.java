package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_respuesta database table.
 * 
 */
@Embeddable
public class TbRespuestaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_respuesta")
	private int idRespuesta;

	@Column(name="tb_solicitud_numero_radicado", insertable=false, updatable=false)
	private String tbSolicitudNumeroRadicado;

	public TbRespuestaPK() {
	}
	public int getIdRespuesta() {
		return this.idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getTbSolicitudNumeroRadicado() {
		return this.tbSolicitudNumeroRadicado;
	}
	public void setTbSolicitudNumeroRadicado(String tbSolicitudNumeroRadicado) {
		this.tbSolicitudNumeroRadicado = tbSolicitudNumeroRadicado;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbRespuestaPK)) {
			return false;
		}
		TbRespuestaPK castOther = (TbRespuestaPK)other;
		return 
			(this.idRespuesta == castOther.idRespuesta)
			&& this.tbSolicitudNumeroRadicado.equals(castOther.tbSolicitudNumeroRadicado);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRespuesta;
		hash = hash * prime + this.tbSolicitudNumeroRadicado.hashCode();
		
		return hash;
	}
}