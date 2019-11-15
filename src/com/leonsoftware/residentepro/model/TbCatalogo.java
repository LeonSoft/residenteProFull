package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_catalogo database table.
 * 
 */
@Entity
@Table(name="tb_catalogo")
@NamedQuery(name="TbCatalogo.findAll", query="SELECT t FROM TbCatalogo t")
public class TbCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_catalogo")
	private String idCatalogo;

	@Column(name="descripcion_catalogo")
	private String descripcionCatalogo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbListaCatalogo
	@OneToMany(mappedBy="tbCatalogo")
	private List<TbListaCatalogo> tbListaCatalogos;

	public TbCatalogo() {
	}

	public String getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(String idCatalogo) {
		this.idCatalogo = idCatalogo;
	}

	public String getDescripcionCatalogo() {
		return this.descripcionCatalogo;
	}

	public void setDescripcionCatalogo(String descripcionCatalogo) {
		this.descripcionCatalogo = descripcionCatalogo;
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

	public List<TbListaCatalogo> getTbListaCatalogos() {
		return this.tbListaCatalogos;
	}

	public void setTbListaCatalogos(List<TbListaCatalogo> tbListaCatalogos) {
		this.tbListaCatalogos = tbListaCatalogos;
	}

	public TbListaCatalogo addTbListaCatalogo(TbListaCatalogo tbListaCatalogo) {
		getTbListaCatalogos().add(tbListaCatalogo);
		tbListaCatalogo.setTbCatalogo(this);

		return tbListaCatalogo;
	}

	public TbListaCatalogo removeTbListaCatalogo(TbListaCatalogo tbListaCatalogo) {
		getTbListaCatalogos().remove(tbListaCatalogo);
		tbListaCatalogo.setTbCatalogo(null);

		return tbListaCatalogo;
	}

}