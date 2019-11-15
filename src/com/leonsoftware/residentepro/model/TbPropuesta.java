package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_propuesta database table.
 * 
 */
@Entity
@Table(name="tb_propuesta")
@NamedQuery(name="TbPropuesta.findAll", query="SELECT t FROM TbPropuesta t")
public class TbPropuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_propuesta")
	private int idPropuesta;

	@Column(name="descripcion_propuesta")
	private String descripcionPropuesta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="nombre_propuesta")
	private String nombrePropuesta;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbEleccion
	@OneToMany(mappedBy="tbPropuesta")
	private List<TbEleccion> tbEleccions;

	//bi-directional many-to-one association to TbOpcion
	@OneToMany(mappedBy="tbPropuesta")
	private List<TbOpcion> tbOpcions;

	//bi-directional many-to-one association to TbAsamblea
	@ManyToOne
	@JoinColumn(name="tb_asamblea_id_asamblea")
	private TbAsamblea tbAsamblea;

	public TbPropuesta() {
	}

	public int getIdPropuesta() {
		return this.idPropuesta;
	}

	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}

	public String getDescripcionPropuesta() {
		return this.descripcionPropuesta;
	}

	public void setDescripcionPropuesta(String descripcionPropuesta) {
		this.descripcionPropuesta = descripcionPropuesta;
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

	public String getNombrePropuesta() {
		return this.nombrePropuesta;
	}

	public void setNombrePropuesta(String nombrePropuesta) {
		this.nombrePropuesta = nombrePropuesta;
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

	public List<TbEleccion> getTbEleccions() {
		return this.tbEleccions;
	}

	public void setTbEleccions(List<TbEleccion> tbEleccions) {
		this.tbEleccions = tbEleccions;
	}

	public TbEleccion addTbEleccion(TbEleccion tbEleccion) {
		getTbEleccions().add(tbEleccion);
		tbEleccion.setTbPropuesta(this);

		return tbEleccion;
	}

	public TbEleccion removeTbEleccion(TbEleccion tbEleccion) {
		getTbEleccions().remove(tbEleccion);
		tbEleccion.setTbPropuesta(null);

		return tbEleccion;
	}

	public List<TbOpcion> getTbOpcions() {
		return this.tbOpcions;
	}

	public void setTbOpcions(List<TbOpcion> tbOpcions) {
		this.tbOpcions = tbOpcions;
	}

	public TbOpcion addTbOpcion(TbOpcion tbOpcion) {
		getTbOpcions().add(tbOpcion);
		tbOpcion.setTbPropuesta(this);

		return tbOpcion;
	}

	public TbOpcion removeTbOpcion(TbOpcion tbOpcion) {
		getTbOpcions().remove(tbOpcion);
		tbOpcion.setTbPropuesta(null);

		return tbOpcion;
	}

	public TbAsamblea getTbAsamblea() {
		return this.tbAsamblea;
	}

	public void setTbAsamblea(TbAsamblea tbAsamblea) {
		this.tbAsamblea = tbAsamblea;
	}

}