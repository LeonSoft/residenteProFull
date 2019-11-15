package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_lista_catalogo database table.
 * 
 */
@Entity
@Table(name="tb_lista_catalogo")
@NamedQuery(name="TbListaCatalogo.findAll", query="SELECT t FROM TbListaCatalogo t")
public class TbListaCatalogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbListaCatalogoPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="nombre_lista_catalogo")
	private String nombreListaCatalogo;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbCatalogo
	@ManyToOne
	@JoinColumn(name="tb_catalogo_id_catalogo")
	private TbCatalogo tbCatalogo;

	public TbListaCatalogo() {
	}

	public TbListaCatalogoPK getId() {
		return this.id;
	}

	public void setId(TbListaCatalogoPK id) {
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

	public String getNombreListaCatalogo() {
		return this.nombreListaCatalogo;
	}

	public void setNombreListaCatalogo(String nombreListaCatalogo) {
		this.nombreListaCatalogo = nombreListaCatalogo;
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

	public TbCatalogo getTbCatalogo() {
		return this.tbCatalogo;
	}

	public void setTbCatalogo(TbCatalogo tbCatalogo) {
		this.tbCatalogo = tbCatalogo;
	}

}