package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_perfil database table.
 * 
 */
@Entity
@Table(name="tb_perfil")
@NamedQuery(name="TbPerfil.findAll", query="SELECT t FROM TbPerfil t")
public class TbPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_perfil")
	private String idPerfil;

	@Column(name="descripción_perfil")
	private String descripciónPerfil;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="nombre_perfil")
	private String nombrePerfil;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbModuloPerfil
	@OneToMany(mappedBy="tbPerfil")
	private List<TbModuloPerfil> tbModuloPerfils;

	//bi-directional many-to-one association to TbUsuario
	@OneToMany(mappedBy="tbPerfil")
	private List<TbUsuario> tbUsuarios;

	public TbPerfil() {
	}

	public String getIdPerfil() {
		return this.idPerfil;
	}

	public void setIdPerfil(String idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripciónPerfil() {
		return this.descripciónPerfil;
	}

	public void setDescripciónPerfil(String descripciónPerfil) {
		this.descripciónPerfil = descripciónPerfil;
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

	public String getNombrePerfil() {
		return this.nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) {
		this.nombrePerfil = nombrePerfil;
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

	public List<TbModuloPerfil> getTbModuloPerfils() {
		return this.tbModuloPerfils;
	}

	public void setTbModuloPerfils(List<TbModuloPerfil> tbModuloPerfils) {
		this.tbModuloPerfils = tbModuloPerfils;
	}

	public TbModuloPerfil addTbModuloPerfil(TbModuloPerfil tbModuloPerfil) {
		getTbModuloPerfils().add(tbModuloPerfil);
		tbModuloPerfil.setTbPerfil(this);

		return tbModuloPerfil;
	}

	public TbModuloPerfil removeTbModuloPerfil(TbModuloPerfil tbModuloPerfil) {
		getTbModuloPerfils().remove(tbModuloPerfil);
		tbModuloPerfil.setTbPerfil(null);

		return tbModuloPerfil;
	}

	public List<TbUsuario> getTbUsuarios() {
		return this.tbUsuarios;
	}

	public void setTbUsuarios(List<TbUsuario> tbUsuarios) {
		this.tbUsuarios = tbUsuarios;
	}

	public TbUsuario addTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().add(tbUsuario);
		tbUsuario.setTbPerfil(this);

		return tbUsuario;
	}

	public TbUsuario removeTbUsuario(TbUsuario tbUsuario) {
		getTbUsuarios().remove(tbUsuario);
		tbUsuario.setTbPerfil(null);

		return tbUsuario;
	}

}