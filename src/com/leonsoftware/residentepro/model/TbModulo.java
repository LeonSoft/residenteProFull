package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_modulo database table.
 * 
 */
@Entity
@Table(name="tb_modulo")
@NamedQuery(name="TbModulo.findAll", query="SELECT t FROM TbModulo t")
public class TbModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_modulo")
	private String idModulo;

	@Column(name="descripcion_modulo")
	private String descripcionModulo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="nombre_modulo")
	private String nombreModulo;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	//bi-directional many-to-one association to TbMenu
	@OneToMany(mappedBy="tbModulo")
	private List<TbMenu> tbMenus;

	//bi-directional many-to-one association to TbModuloPerfil
	@OneToMany(mappedBy="tbModulo")
	private List<TbModuloPerfil> tbModuloPerfils;

	public TbModulo() {
	}

	public String getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(String idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescripcionModulo() {
		return this.descripcionModulo;
	}

	public void setDescripcionModulo(String descripcionModulo) {
		this.descripcionModulo = descripcionModulo;
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

	public String getNombreModulo() {
		return this.nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
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

	public List<TbMenu> getTbMenus() {
		return this.tbMenus;
	}

	public void setTbMenus(List<TbMenu> tbMenus) {
		this.tbMenus = tbMenus;
	}

	public TbMenu addTbMenus(TbMenu tbMenus) {
		getTbMenus().add(tbMenus);
		tbMenus.setTbModulo(this);

		return tbMenus;
	}

	public TbMenu removeTbMenus(TbMenu tbMenus) {
		getTbMenus().remove(tbMenus);
		tbMenus.setTbModulo(null);

		return tbMenus;
	}

	public List<TbModuloPerfil> getTbModuloPerfils() {
		return this.tbModuloPerfils;
	}

	public void setTbModuloPerfils(List<TbModuloPerfil> tbModuloPerfils) {
		this.tbModuloPerfils = tbModuloPerfils;
	}

	public TbModuloPerfil addTbModuloPerfil(TbModuloPerfil tbModuloPerfil) {
		getTbModuloPerfils().add(tbModuloPerfil);
		tbModuloPerfil.setTbModulo(this);

		return tbModuloPerfil;
	}

	public TbModuloPerfil removeTbModuloPerfil(TbModuloPerfil tbModuloPerfil) {
		getTbModuloPerfils().remove(tbModuloPerfil);
		tbModuloPerfil.setTbModulo(null);

		return tbModuloPerfil;
	}

}