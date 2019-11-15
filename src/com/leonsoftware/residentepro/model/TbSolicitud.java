package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_solicitud database table.
 * 
 */
@Entity
@Table(name="tb_solicitud")
@NamedQuery(name="TbSolicitud.findAll", query="SELECT t FROM TbSolicitud t")
public class TbSolicitud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="numero_radicado")
	private String numeroRadicado;

	@Column(name="asunto_solicitud")
	private String asuntoSolicitud;

	@Column(name="descripcion_solicitud")
	private String descripcionSolicitud;

	@Column(name="estado_solicitud")
	private String estadoSolicitud;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="tipo_solicitud")
	private String tipoSolicitud;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbRespuesta
	@OneToMany(mappedBy="tbSolicitud")
	private List<TbRespuesta> tbRespuestas;

	//bi-directional many-to-one association to TbInmueble
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="tb_inmueble_id_inmueble", referencedColumnName="id_inmueble"),
		@JoinColumn(name="tb_inmueble_tb_conjunto_id_conjunto", referencedColumnName="tb_conjunto_id_conjunto"),
		@JoinColumn(name="tb_inmueble_tipo_id_immueble", referencedColumnName="tipo_id_immueble")
		})
	private TbInmueble tbInmueble;

	public TbSolicitud() {
	}

	public String getNumeroRadicado() {
		return this.numeroRadicado;
	}

	public void setNumeroRadicado(String numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public String getAsuntoSolicitud() {
		return this.asuntoSolicitud;
	}

	public void setAsuntoSolicitud(String asuntoSolicitud) {
		this.asuntoSolicitud = asuntoSolicitud;
	}

	public String getDescripcionSolicitud() {
		return this.descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public String getEstadoSolicitud() {
		return this.estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
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

	public String getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
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

	public List<TbRespuesta> getTbRespuestas() {
		return this.tbRespuestas;
	}

	public void setTbRespuestas(List<TbRespuesta> tbRespuestas) {
		this.tbRespuestas = tbRespuestas;
	}

	public TbRespuesta addTbRespuesta(TbRespuesta tbRespuesta) {
		getTbRespuestas().add(tbRespuesta);
		tbRespuesta.setTbSolicitud(this);

		return tbRespuesta;
	}

	public TbRespuesta removeTbRespuesta(TbRespuesta tbRespuesta) {
		getTbRespuestas().remove(tbRespuesta);
		tbRespuesta.setTbSolicitud(null);

		return tbRespuesta;
	}

	public TbInmueble getTbInmueble() {
		return this.tbInmueble;
	}

	public void setTbInmueble(TbInmueble tbInmueble) {
		this.tbInmueble = tbInmueble;
	}

}