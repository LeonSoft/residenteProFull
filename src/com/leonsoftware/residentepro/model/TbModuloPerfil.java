package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_modulo_perfil database table.
 * 
 */
@Entity
@Table(name="tb_modulo_perfil")
@NamedQuery(name="TbModuloPerfil.findAll", query="SELECT t FROM TbModuloPerfil t")
public class TbModuloPerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbModuloPerfilPK id;

	//bi-directional many-to-one association to TbModulo
	@ManyToOne
	@JoinColumn(name="tb_modulo_id_modulo")
	private TbModulo tbModulo;

	//bi-directional many-to-one association to TbPerfil
	@ManyToOne
	@JoinColumn(name="tb_perfil_id_perfil")
	private TbPerfil tbPerfil;

	public TbModuloPerfil() {
	}

	public TbModuloPerfilPK getId() {
		return this.id;
	}

	public void setId(TbModuloPerfilPK id) {
		this.id = id;
	}

	public TbModulo getTbModulo() {
		return this.tbModulo;
	}

	public void setTbModulo(TbModulo tbModulo) {
		this.tbModulo = tbModulo;
	}

	public TbPerfil getTbPerfil() {
		return this.tbPerfil;
	}

	public void setTbPerfil(TbPerfil tbPerfil) {
		this.tbPerfil = tbPerfil;
	}

}