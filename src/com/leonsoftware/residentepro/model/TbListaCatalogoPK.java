package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_lista_catalogo database table.
 * 
 */
@Embeddable
public class TbListaCatalogoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_lista_catalogo")
	private String idListaCatalogo;

	@Column(name="tb_catalogo_id_catalogo", insertable=false, updatable=false)
	private String tbCatalogoIdCatalogo;

	public TbListaCatalogoPK() {
	}
	public String getIdListaCatalogo() {
		return this.idListaCatalogo;
	}
	public void setIdListaCatalogo(String idListaCatalogo) {
		this.idListaCatalogo = idListaCatalogo;
	}
	public String getTbCatalogoIdCatalogo() {
		return this.tbCatalogoIdCatalogo;
	}
	public void setTbCatalogoIdCatalogo(String tbCatalogoIdCatalogo) {
		this.tbCatalogoIdCatalogo = tbCatalogoIdCatalogo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbListaCatalogoPK)) {
			return false;
		}
		TbListaCatalogoPK castOther = (TbListaCatalogoPK)other;
		return 
			this.idListaCatalogo.equals(castOther.idListaCatalogo)
			&& this.tbCatalogoIdCatalogo.equals(castOther.tbCatalogoIdCatalogo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idListaCatalogo.hashCode();
		hash = hash * prime + this.tbCatalogoIdCatalogo.hashCode();
		
		return hash;
	}
}