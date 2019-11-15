package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_pago database table.
 * 
 */
@Embeddable
public class TbPagoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_tipo_pago")
	private String idTipoPago;

	@Column(name="tb_cuota_id_tipo_cuota", insertable=false, updatable=false)
	private String tbCuotaIdTipoCuota;

	public TbPagoPK() {
	}
	public String getIdTipoPago() {
		return this.idTipoPago;
	}
	public void setIdTipoPago(String idTipoPago) {
		this.idTipoPago = idTipoPago;
	}
	public String getTbCuotaIdTipoCuota() {
		return this.tbCuotaIdTipoCuota;
	}
	public void setTbCuotaIdTipoCuota(String tbCuotaIdTipoCuota) {
		this.tbCuotaIdTipoCuota = tbCuotaIdTipoCuota;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TbPagoPK)) {
			return false;
		}
		TbPagoPK castOther = (TbPagoPK)other;
		return 
			this.idTipoPago.equals(castOther.idTipoPago)
			&& this.tbCuotaIdTipoCuota.equals(castOther.tbCuotaIdTipoCuota);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idTipoPago.hashCode();
		hash = hash * prime + this.tbCuotaIdTipoCuota.hashCode();
		
		return hash;
	}
}