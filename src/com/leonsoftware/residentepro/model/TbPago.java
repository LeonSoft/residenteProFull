package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tb_pago database table.
 * 
 */
@Entity
@Table(name="tb_pago")
@NamedQuery(name="TbPago.findAll", query="SELECT t FROM TbPago t")
public class TbPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbPagoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_pago")
	private Date fechaPago;

	@Column(name="id_estado_pago")
	private String idEstadoPago;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	@Column(name="valor_pago")
	private BigDecimal valorPago;

	//bi-directional many-to-one association to TbCuota
	@ManyToOne
	@JoinColumn(name="tb_cuota_id_tipo_cuota")
	private TbCuota tbCuota;

	public TbPago() {
	}

	public TbPagoPK getId() {
		return this.id;
	}

	public void setId(TbPagoPK id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public String getIdEstadoPago() {
		return this.idEstadoPago;
	}

	public void setIdEstadoPago(String idEstadoPago) {
		this.idEstadoPago = idEstadoPago;
	}

	public String getUsuarioCreacion() {
		return this.usuarioCreacion;
	}

	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}

	public String getUsuarioModificacion() {
		return this.usuarioModificacion;
	}

	public void setUsuarioModificacion(String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	public BigDecimal getValorPago() {
		return this.valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public TbCuota getTbCuota() {
		return this.tbCuota;
	}

	public void setTbCuota(TbCuota tbCuota) {
		this.tbCuota = tbCuota;
	}

}