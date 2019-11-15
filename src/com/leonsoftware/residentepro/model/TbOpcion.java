package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb_opcion database table.
 * 
 */
@Entity
@Table(name="tb_opcion")
@NamedQuery(name="TbOpcion.findAll", query="SELECT t FROM TbOpcion t")
public class TbOpcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbOpcionPK id;

	@Column(name="descripcion_respuesta")
	private String descripcionRespuesta;

	//bi-directional many-to-one association to TbPropuesta
	@ManyToOne
	@JoinColumn(name="tb_propuesta_id_propuesta")
	private TbPropuesta tbPropuesta;

	public TbOpcion() {
	}

	public TbOpcionPK getId() {
		return this.id;
	}

	public void setId(TbOpcionPK id) {
		this.id = id;
	}

	public String getDescripcionRespuesta() {
		return this.descripcionRespuesta;
	}

	public void setDescripcionRespuesta(String descripcionRespuesta) {
		this.descripcionRespuesta = descripcionRespuesta;
	}

	public TbPropuesta getTbPropuesta() {
		return this.tbPropuesta;
	}

	public void setTbPropuesta(TbPropuesta tbPropuesta) {
		this.tbPropuesta = tbPropuesta;
	}

}