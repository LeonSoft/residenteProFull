package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_conjunto database table.
 * 
 */
@Entity
@Table(name="tb_conjunto")
@NamedQuery(name="TbConjunto.findAll", query="SELECT t FROM TbConjunto t")
public class TbConjunto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_conjunto")
	private String idConjunto;

	@Column(name="direccion_conjunto")
	private String direccionConjunto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modifcacion")
	private Date fechaModifcacion;

	@Column(name="nombre_conjunto")
	private String nombreConjunto;

	@Column(name="numero_apartamentos")
	private String numeroApartamentos;

	@Column(name="numero_parqueaderos")
	private String numeroParqueaderos;

	@Column(name="tb_administrador_tipo_id_administrador")
	private String tbAdministradorTipoIdAdministrador;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbArchivo
	@OneToMany(mappedBy="tbConjunto")
	private List<TbArchivo> tbArchivos;

	//bi-directional many-to-one association to TbAsamblea
	@ManyToOne
	@JoinColumn(name="tb_asamblea_tipo_id_administrador")
	private TbAsamblea tbAsamblea;

	//bi-directional many-to-one association to TbInmueble
	@OneToMany(mappedBy="tbConjunto")
	private List<TbInmueble> tbInmuebles;

	//bi-directional many-to-one association to TbZonaComun
	@OneToMany(mappedBy="tbConjunto")
	private List<TbZonaComun> tbZonaComuns;

	public TbConjunto() {
	}

	public String getIdConjunto() {
		return this.idConjunto;
	}

	public void setIdConjunto(String idConjunto) {
		this.idConjunto = idConjunto;
	}

	public String getDireccionConjunto() {
		return this.direccionConjunto;
	}

	public void setDireccionConjunto(String direccionConjunto) {
		this.direccionConjunto = direccionConjunto;
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

	public String getNombreConjunto() {
		return this.nombreConjunto;
	}

	public void setNombreConjunto(String nombreConjunto) {
		this.nombreConjunto = nombreConjunto;
	}

	public String getNumeroApartamentos() {
		return this.numeroApartamentos;
	}

	public void setNumeroApartamentos(String numeroApartamentos) {
		this.numeroApartamentos = numeroApartamentos;
	}

	public String getNumeroParqueaderos() {
		return this.numeroParqueaderos;
	}

	public void setNumeroParqueaderos(String numeroParqueaderos) {
		this.numeroParqueaderos = numeroParqueaderos;
	}

	public String getTbAdministradorTipoIdAdministrador() {
		return this.tbAdministradorTipoIdAdministrador;
	}

	public void setTbAdministradorTipoIdAdministrador(String tbAdministradorTipoIdAdministrador) {
		this.tbAdministradorTipoIdAdministrador = tbAdministradorTipoIdAdministrador;
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

	public List<TbArchivo> getTbArchivos() {
		return this.tbArchivos;
	}

	public void setTbArchivos(List<TbArchivo> tbArchivos) {
		this.tbArchivos = tbArchivos;
	}

	public TbArchivo addTbArchivo(TbArchivo tbArchivo) {
		getTbArchivos().add(tbArchivo);
		tbArchivo.setTbConjunto(this);

		return tbArchivo;
	}

	public TbArchivo removeTbArchivo(TbArchivo tbArchivo) {
		getTbArchivos().remove(tbArchivo);
		tbArchivo.setTbConjunto(null);

		return tbArchivo;
	}

	public TbAsamblea getTbAsamblea() {
		return this.tbAsamblea;
	}

	public void setTbAsamblea(TbAsamblea tbAsamblea) {
		this.tbAsamblea = tbAsamblea;
	}

	public List<TbInmueble> getTbInmuebles() {
		return this.tbInmuebles;
	}

	public void setTbInmuebles(List<TbInmueble> tbInmuebles) {
		this.tbInmuebles = tbInmuebles;
	}

	public TbInmueble addTbInmueble(TbInmueble tbInmueble) {
		getTbInmuebles().add(tbInmueble);
		tbInmueble.setTbConjunto(this);

		return tbInmueble;
	}

	public TbInmueble removeTbInmueble(TbInmueble tbInmueble) {
		getTbInmuebles().remove(tbInmueble);
		tbInmueble.setTbConjunto(null);

		return tbInmueble;
	}

	public List<TbZonaComun> getTbZonaComuns() {
		return this.tbZonaComuns;
	}

	public void setTbZonaComuns(List<TbZonaComun> tbZonaComuns) {
		this.tbZonaComuns = tbZonaComuns;
	}

	public TbZonaComun addTbZonaComun(TbZonaComun tbZonaComun) {
		getTbZonaComuns().add(tbZonaComun);
		tbZonaComun.setTbConjunto(this);

		return tbZonaComun;
	}

	public TbZonaComun removeTbZonaComun(TbZonaComun tbZonaComun) {
		getTbZonaComuns().remove(tbZonaComun);
		tbZonaComun.setTbConjunto(null);

		return tbZonaComun;
	}

}