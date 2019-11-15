package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_archivo database table.
 * 
 */
@Entity
@Table(name="tb_archivo")
@NamedQuery(name="TbArchivo.findAll", query="SELECT t FROM TbArchivo t")
public class TbArchivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_archivo")
	private int idArchivo;

	@Lob
	@Column(name="archivo_archivo")
	private byte[] archivoArchivo;

	@Column(name="descripcion_archivo")
	private String descripcionArchivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modifcacion")
	private Date fechaModifcacion;

	@Column(name="Nombre_archivo")
	private String nombre_archivo;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbConjunto
	@ManyToOne
	@JoinColumn(name="tb_conjunto_id_conjunto")
	private TbConjunto tbConjunto;

	public TbArchivo() {
	}

	public int getIdArchivo() {
		return this.idArchivo;
	}

	public void setIdArchivo(int idArchivo) {
		this.idArchivo = idArchivo;
	}

	public byte[] getArchivoArchivo() {
		return this.archivoArchivo;
	}

	public void setArchivoArchivo(byte[] archivoArchivo) {
		this.archivoArchivo = archivoArchivo;
	}

	public String getDescripcionArchivo() {
		return this.descripcionArchivo;
	}

	public void setDescripcionArchivo(String descripcionArchivo) {
		this.descripcionArchivo = descripcionArchivo;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModifcacion() {
		return this.fechaModifcacion;
	}

	public void setFechaModifcacion(Date fechaModifcacion) {
		this.fechaModifcacion = fechaModifcacion;
	}

	public String getNombre_archivo() {
		return this.nombre_archivo;
	}

	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
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

	public TbConjunto getTbConjunto() {
		return this.tbConjunto;
	}

	public void setTbConjunto(TbConjunto tbConjunto) {
		this.tbConjunto = tbConjunto;
	}

}