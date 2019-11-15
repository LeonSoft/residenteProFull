package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the tb_respuesta database table.
 * 
 */
@Entity
@Table(name="tb_respuesta")
@NamedQuery(name="TbRespuesta.findAll", query="SELECT t FROM TbRespuesta t")
public class TbRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbRespuestaPK id;

	@Column(name="descripcion_respuesta")
	private String descripcionRespuesta;

	@Column(name="estado_respuesta")
	private String estadoRespuesta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_respuesta")
	private Date fechaRespuesta;

	@Column(name="id_usuario")
	private int idUsuario;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbSolicitud
	@ManyToOne
	@JoinColumn(name="tb_solicitud_numero_radicado")
	private TbSolicitud tbSolicitud;

	public TbRespuesta() {
	}

	public TbRespuestaPK getId() {
		return this.id;
	}

	public void setId(TbRespuestaPK id) {
		this.id = id;
	}

	public String getDescripcionRespuesta() {
		return this.descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public String getEstadoRespuesta() {
		return this.estadoRespuesta;
	}

	public void setEstadoRespuesta(String estadoRespuesta) {
		this.estadoRespuesta = estadoRespuesta;
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

	public Date getFechaRespuesta() {
		return this.fechaRespuesta;
	}

	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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

	public TbSolicitud getTbSolicitud() {
		return this.tbSolicitud;
	}

	public void setTbSolicitud(TbSolicitud tbSolicitud) {
		this.tbSolicitud = tbSolicitud;
	}

}