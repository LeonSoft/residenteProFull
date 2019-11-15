package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_eleccion database table.
 * 
 */
@Embeddable
public class TbEleccionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tb_votacion_cod_votacion")
	private String tbVotacionCodVotacion;

	@Column(name="tb_propuesta_id_propuesta", insertable=false, updatable=false)
	private int tbPropuestaIdPropuesta;

	public TbEleccionPK() {
	}
	public String getTbVotacionCodVotacion() {
		return this.tbVotacionCodVotacion;
	}
	public void setTbVotacionCodVotacion(String tbVotacionCodVotacion) {
		this.tbVotacionCodVotacion = tbVotacionCodVotacion;
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
		if (!(other instanceof TbEleccionPK)) {
			return false;
		}
		TbEleccionPK castOther = (TbEleccionPK)other;
		return 
			this.tbVotacionCodVotacion.equals(castOther.tbVotacionCodVotacion)
			&& (this.tbPropuestaIdPropuesta == castOther.tbPropuestaIdPropuesta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tbVotacionCodVotacion.hashCode();
		hash = hash * prime + this.tbPropuestaIdPropuesta;
		
		return hash;
	}
}