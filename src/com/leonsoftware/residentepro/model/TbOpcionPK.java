package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_opcion database table.
 * 
 */
@Embeddable
public class TbOpcionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_respuesta")
	private int idRespuesta;

	@Column(name="tb_propuesta_id_propuesta", insertable=false, updatable=false)
	private int tbPropuestaIdPropuesta;

	public TbOpcionPK() {
	}
	public int getIdRespuesta() {
		return this.idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public int getTbPropuestaIdPropuesta() {
		return this.tbPropuestaIdPropuesta;
	}
	public void setTbPropuestaIdPropuesta(int tbPropuestaIdPropuesta) {
		this.tbPropuestaIdPropuesta = tbPropuestaIdPropuesta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbOpcionPK)) {
			return false;
		}
		TbOpcionPK castOther = (TbOpcionPK)other;
		return 
			(this.idRespuesta == castOther.idRespuesta)
			&& (this.tbPropuestaIdPropuesta == castOther.tbPropuestaIdPropuesta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRespuesta;
		hash = hash * prime + this.tbPropuestaIdPropuesta;
		
		return hash;
	}
}