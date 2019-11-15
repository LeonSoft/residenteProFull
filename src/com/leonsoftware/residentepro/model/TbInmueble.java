package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_inmueble database table.
 * 
 */
@Entity
@Table(name="tb_inmueble")
@NamedQuery(name="TbInmueble.findAll", query="SELECT t FROM TbInmueble t")
public class TbInmueble implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbInmueblePK id;

	@Column(name="`apellido_residente*`")
	private String apellidoResidente_;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modifcacion")
	private Date fechaModifcacion;

	@Column(name="id_acudiente")
	private int idAcudiente;

	@Column(name="nombre_acudiente")
	private String nombreAcudiente;

	@Column(name="`nombre_residente*`")
	private String nombreResidente_;

	@Column(name="parentesco_acudiente")
	private String parentescoAcudiente;

	@Column(name="tel_acudiente")
	private String telAcudiente;

	@Column(name="tipo_id_acudiente")
	private String tipoIdAcudiente;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbCuota
	@OneToMany(mappedBy="tbInmueble")
	private List<TbCuota> tbCuotas;

	//bi-directional many-to-one association to TbEleccion
	@OneToMany(mappedBy="tbInmueble")
	private List<TbEleccion> tbEleccions;

	//bi-directional many-to-one association to TbConjunto
	@ManyToOne
	@JoinColumn(name="tb_conjunto_id_conjunto")
	private TbConjunto tbConjunto;

	//bi-directional many-to-one association to TbParqueadero
	@OneToMany(mappedBy="tbInmueble")
	private List<TbParqueadero> tbParqueaderos;

	//bi-directional many-to-one association to TbSolicitud
	@OneToMany(mappedBy="tbInmueble")
	private List<TbSolicitud> tbSolicituds;

	public TbInmueble() {
	}

	public TbInmueblePK getId() {
		return this.id;
	}

	public void setId(TbInmueblePK id) {
		this.id = id;
	}

	public String getApellidoResidente_() {
		return this.apellidoResidente_;
	}

	public void setApellidoResidente_(String apellidoResidente_) {
		this.apellidoResidente_ = apellidoResidente_;
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

	public int getIdAcudiente() {
		return this.idAcudiente;
	}

	public void setIdAcudiente(int idAcudiente) {
		this.idAcudiente = idAcudiente;
	}

	public String getNombreAcudiente() {
		return this.nombreAcudiente;
	}

	public void setNombreAcudiente(String nombreAcudiente) {
		this.nombreAcudiente = nombreAcudiente;
	}

	public String getNombreResidente_() {
		return this.nombreResidente_;
	}

	public void setNombreResidente_(String nombreResidente_) {
		this.nombreResidente_ = nombreResidente_;
	}

	public String getParentescoAcudiente() {
		return this.parentescoAcudiente;
	}

	public void setParentescoAcudiente(String parentescoAcudiente) {
		this.parentescoAcudiente = parentescoAcudiente;
	}

	public String getTelAcudiente() {
		return this.telAcudiente;
	}

	public void setTelAcudiente(String telAcudiente) {
		this.telAcudiente = telAcudiente;
	}

	public String getTipoIdAcudiente() {
		return this.tipoIdAcudiente;
	}

	public void setTipoIdAcudiente(String tipoIdAcudiente) {
		this.tipoIdAcudiente = tipoIdAcudiente;
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

	public List<TbCuota> getTbCuotas() {
		return this.tbCuotas;
	}

	public void setTbCuotas(List<TbCuota> tbCuotas) {
		this.tbCuotas = tbCuotas;
	}

	public TbCuota addTbCuota(TbCuota tbCuota) {
		getTbCuotas().add(tbCuota);
		tbCuota.setTbInmueble(this);

		return tbCuota;
	}

	public TbCuota removeTbCuota(TbCuota tbCuota) {
		getTbCuotas().remove(tbCuota);
		tbCuota.setTbInmueble(null);

		return tbCuota;
	}

	public List<TbEleccion> getTbEleccions() {
		return this.tbEleccions;
	}

	public void setTbEleccions(List<TbEleccion> tbEleccions) {
		this.tbEleccions = tbEleccions;
	}

	public TbEleccion addTbEleccion(TbEleccion tbEleccion) {
		getTbEleccions().add(tbEleccion);
		tbEleccion.setTbInmueble(this);

		return tbEleccion;
	}

	public TbEleccion removeTbEleccion(TbEleccion tbEleccion) {
		getTbEleccions().remove(tbEleccion);
		tbEleccion.setTbInmueble(null);

		return tbEleccion;
	}

	public TbConjunto getTbConjunto() {
		return this.tbConjunto;
	}

	public void setTbConjunto(TbConjunto tbConjunto) {
		this.tbConjunto = tbConjunto;
	}

	public List<TbParqueadero> getTbParqueaderos() {
		return this.tbParqueaderos;
	}

	public void setTbParqueaderos(List<TbParqueadero> tbParqueaderos) {
		this.tbParqueaderos = tbParqueaderos;
	}

	public TbParqueadero addTbParqueadero(TbParqueadero tbParqueadero) {
		getTbParqueaderos().add(tbParqueadero);
		tbParqueadero.setTbInmueble(this);

		return tbParqueadero;
	}

	public TbParqueadero removeTbParqueadero(TbParqueadero tbParqueadero) {
		getTbParqueaderos().remove(tbParqueadero);
		tbParqueadero.setTbInmueble(null);

		return tbParqueadero;
	}

	public List<TbSolicitud> getTbSolicituds() {
		return this.tbSolicituds;
	}

	public void setTbSolicituds(List<TbSolicitud> tbSolicituds) {
		this.tbSolicituds = tbSolicituds;
	}

	public TbSolicitud addTbSolicitud(TbSolicitud tbSolicitud) {
		getTbSolicituds().add(tbSolicitud);
		tbSolicitud.setTbInmueble(this);

		return tbSolicitud;
	}

	public TbSolicitud removeTbSolicitud(TbSolicitud tbSolicitud) {
		getTbSolicituds().remove(tbSolicitud);
		tbSolicitud.setTbInmueble(null);

		return tbSolicitud;
	}

}