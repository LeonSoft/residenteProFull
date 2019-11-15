package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_eleccion database table.
 * 
 */
@Entity
@Table(name="tb_eleccion")
@NamedQuery(name="TbEleccion.findAll", query="SELECT t FROM TbEleccion t")
public class TbEleccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbEleccionPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_eleccion")
	private Date fechaEleccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="opcion_seleccionado")
	private int opcionSeleccionado;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbInmueble
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="tb_inmueble_id_inmueble", referencedColumnName="id_inmueble"),
		@JoinColumn(name="tb_inmueble_tb_conjunto_id_conjunto", referencedColumnName="tb_conjunto_id_conjunto"),
		@JoinColumn(name="tb_inmueble_tipo_id_immueble", referencedColumnName="tipo_id_immueble")
		})
	private TbInmueble tbInmueble;

	//bi-directional many-to-one association to TbPropuesta
	@ManyToOne
	@JoinColumn(name="tb_propuesta_id_propuesta")
	private TbPropuesta tbPropuesta;

	public TbEleccion() {
	}

	public TbEleccionPK getId() {
		return this.id;
	}

	public void setId(TbEleccionPK id) {
		this.id = id;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEleccion() {
		return this.fechaEleccion;
	}

	public void setFechaEleccion(Date fechaEleccion) {
		this.fechaEleccion = fechaEleccion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public int getOpcionSeleccionado() {
		return this.opcionSeleccionado;
	}

	public void setOpcionSeleccionado(int opcionSeleccionado) {
		this.opcionSeleccionado = opcionSeleccionado;
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

	public TbInmueble getTbInmueble() {
		return this.tbInmueble;
	}

	public void setTbInmueble(TbInmueble tbInmueble) {
		this.tbInmueble = tbInmueble;
	}

	public TbPropuesta getTbPropuesta() {
		return this.tbPropuesta;
	}

	public void setTbPropuesta(TbPropuesta tbPropuesta) {
		this.tbPropuesta = tbPropuesta;
	}

}