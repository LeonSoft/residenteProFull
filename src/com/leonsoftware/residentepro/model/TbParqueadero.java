package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the tb_parqueadero database table.
 * 
 */
@Entity
@Table(name="tb_parqueadero")
@NamedQuery(name="TbParqueadero.findAll", query="SELECT t FROM TbParqueadero t")
public class TbParqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_parqueadero")
	private String idParqueadero;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="numero_parqueadero")
	private int numeroParqueadero;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	@Column(name="valor_parqueadero")
	private BigDecimal valorParqueadero;

	//bi-directional many-to-one association to TbInmueble
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="tb_inmueble_id_inmueble", referencedColumnName="id_inmueble"),
		@JoinColumn(name="tb_inmueble_tb_conjunto_id_conjunto", referencedColumnName="tb_conjunto_id_conjunto"),
		@JoinColumn(name="tb_inmueble_tipo_id_immueble", referencedColumnName="tipo_id_immueble")
		})
	private TbInmueble tbInmueble;

	public TbParqueadero() {
	}

	public String getIdParqueadero() {
		return this.idParqueadero;
	}

	public void setIdParqueadero(String idParqueadero) {
		this.idParqueadero = idParqueadero;
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

	public int getNumeroParqueadero() {
		return this.numeroParqueadero;
	}

	public void setNumeroParqueadero(int numeroParqueadero) {
		this.numeroParqueadero = numeroParqueadero;
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

	public BigDecimal getValorParqueadero() {
		return this.valorParqueadero;
	}

	public void setValorParqueadero(BigDecimal valorParqueadero) {
		this.valorParqueadero = valorParqueadero;
	}

	public TbInmueble getTbInmueble() {
		return this.tbInmueble;
	}

	public void setTbInmueble(TbInmueble tbInmueble) {
		this.tbInmueble = tbInmueble;
	}

}