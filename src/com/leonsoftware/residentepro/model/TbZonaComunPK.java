package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_zona_comun database table.
 * 
 */
@Embeddable
public class TbZonaComunPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tipo_zona_comun")
	private String tipoZonaComun;

	@Column(name="tb_conjunto_id_conjunto", insertable=false, updatable=false)
	private String tbConjuntoIdConjunto;

	public TbZonaComunPK() {
	}
	public String getTipoZonaComun() {
		return this.tipoZonaComun;
	}
	public void setTipoZonaComun(String tipoZonaComun) {
		this.tipoZonaComun = tipoZonaComun;
	}
	public String getTbConjuntoIdConjunto() {
		return this.tbConjuntoIdConjunto;
	}
	public void setTbConjuntoIdConjunto(String tbConjuntoIdConjunto) {
		this.tbConjuntoIdConjunto = tbConjuntoIdConjunto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbZonaComunPK)) {
			return false;
		}
		TbZonaComunPK castOther = (TbZonaComunPK)other;
		return 
			this.tipoZonaComun.equals(castOther.tipoZonaComun)
			&& this.tbConjuntoIdConjunto.equals(castOther.tbConjuntoIdConjunto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipoZonaComun.hashCode();
		hash = hash * prime + this.tbConjuntoIdConjunto.hashCode();
		
		return hash;
	}
}