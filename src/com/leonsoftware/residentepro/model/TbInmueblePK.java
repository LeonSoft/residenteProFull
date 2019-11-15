package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_inmueble database table.
 * 
 */
@Embeddable
public class TbInmueblePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="tipo_id_immueble")
	private String tipoIdImmueble;

	@Column(name="id_inmueble")
	private int idInmueble;

	@Column(name="tb_conjunto_id_conjunto", insertable=false, updatable=false)
	private String tbConjuntoIdConjunto;

	public TbInmueblePK() {
	}
	public String getTipoIdImmueble() {
		return this.tipoIdImmueble;
	}
	public void setTipoIdImmueble(String tipoIdImmueble) {
		this.tipoIdImmueble = tipoIdImmueble;
	}
	public int getIdInmueble() {
		return this.idInmueble;
	}
	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
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
		if (!(other instanceof TbInmueblePK)) {
			return false;
		}
		TbInmueblePK castOther = (TbInmueblePK)other;
		return 
			this.tipoIdImmueble.equals(castOther.tipoIdImmueble)
			&& (this.idInmueble == castOther.idInmueble)
			&& this.tbConjuntoIdConjunto.equals(castOther.tbConjuntoIdConjunto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.tipoIdImmueble.hashCode();
		hash = hash * prime + this.idInmueble;
		hash = hash * prime + this.tbConjuntoIdConjunto.hashCode();
		
		return hash;
	}
}