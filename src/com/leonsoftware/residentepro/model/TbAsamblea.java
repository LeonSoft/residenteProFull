package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_asamblea database table.
 * 
 */
@Entity
@Table(name="tb_asamblea")
@NamedQuery(name="TbAsamblea.findAll", query="SELECT t FROM TbAsamblea t")
public class TbAsamblea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_asamblea")
	private String idAsamblea;

	@Column(name="corum_asamblea")
	private int corumAsamblea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="duracion_asamblea")
	private Date duracionAsamblea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_asamblea")
	private Date fechaAsamblea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin_votacion")
	private Date fechaFinVotacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio_votacion")
	private Date fechaInicioVotacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbConjunto
	@OneToMany(mappedBy="tbAsamblea")
	private List<TbConjunto> tbConjuntos;

	//bi-directional many-to-one association to TbPropuesta
	@OneToMany(mappedBy="tbAsamblea")
	private List<TbPropuesta> tbPropuestas;

	public TbAsamblea() {
	}

	public String getIdAsamblea() {
		return this.idAsamblea;
	}

	public void setIdAsamblea(String idAsamblea) {
		this.idAsamblea = idAsamblea;
	}

	public int getCorumAsamblea() {
		return this.corumAsamblea;
	}

	public void setCorumAsamblea(int corumAsamblea) {
		this.corumAsamblea = corumAsamblea;
	}

	public Date getDuracionAsamblea() {
		return this.duracionAsamblea;
	}

	public void setDuracionAsamblea(Date duracionAsamblea) {
		this.duracionAsamblea = duracionAsamblea;
	}

	public Date getFechaAsamblea() {
		return this.fechaAsamblea;
	}

	public void setFechaAsamblea(Date fechaAsamblea) {
		this.fechaAsamblea = fechaAsamblea;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaFinVotacion() {
		return this.fechaFinVotacion;
	}

	public void setFechaFinVotacion(Date fechaFinVotacion) {
		this.fechaFinVotacion = fechaFinVotacion;
	}

	public Date getFechaInicioVotacion() {
		return this.fechaInicioVotacion;
	}

	public void setFechaInicioVotacion(Date fechaInicioVotacion) {
		this.fechaInicioVotacion = fechaInicioVotacion;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
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

	public List<TbConjunto> getTbConjuntos() {
		return this.tbConjuntos;
	}

	public void setTbConjuntos(List<TbConjunto> tbConjuntos) {
		this.tbConjuntos = tbConjuntos;
	}

	public TbConjunto addTbConjunto(TbConjunto tbConjunto) {
		getTbConjuntos().add(tbConjunto);
		tbConjunto.setTbAsamblea(this);

		return tbConjunto;
	}

	public TbConjunto removeTbConjunto(TbConjunto tbConjunto) {
		getTbConjuntos().remove(tbConjunto);
		tbConjunto.setTbAsamblea(null);

		return tbConjunto;
	}

	public List<TbPropuesta> getTbPropuestas() {
		return this.tbPropuestas;
	}

	public void setTbPropuestas(List<TbPropuesta> tbPropuestas) {
		this.tbPropuestas = tbPropuestas;
	}

	public TbPropuesta addTbPropuesta(TbPropuesta tbPropuesta) {
		getTbPropuestas().add(tbPropuesta);
		tbPropuesta.setTbAsamblea(this);

		return tbPropuesta;
	}

	public TbPropuesta removeTbPropuesta(TbPropuesta tbPropuesta) {
		getTbPropuestas().remove(tbPropuesta);
		tbPropuesta.setTbAsamblea(null);

		return tbPropuesta;
	}

}