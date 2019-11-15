package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_reserva database table.
 * 
 */
@Entity
@Table(name="tb_reserva")
@NamedQuery(name="TbReserva.findAll", query="SELECT t FROM TbReserva t")
public class TbReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_reserva")
	private String idReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_reserva")
	private Date fechaReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_reserva")
	private Date horaReserva;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbZonaComun
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="tb_zona_comun_tb_conjunto_id_conjunto", referencedColumnName="tb_conjunto_id_conjunto"),
		@JoinColumn(name="tb_zona_comun_tipo_zona_comun", referencedColumnName="tipo_zona_comun")
		})
	private TbZonaComun tbZonaComun;

	public TbReserva() {
	}

	public String getIdReserva() {
		return this.idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
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

	public Date getFechaReserva() {
		return this.fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public Date getHoraReserva() {
		return this.horaReserva;
	}

	public void setHoraReserva(Date horaReserva) {
		this.horaReserva = horaReserva;
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

	public TbZonaComun getTbZonaComun() {
		return this.tbZonaComun;
	}

	public void setTbZonaComun(TbZonaComun tbZonaComun) {
		this.tbZonaComun = tbZonaComun;
	}

}