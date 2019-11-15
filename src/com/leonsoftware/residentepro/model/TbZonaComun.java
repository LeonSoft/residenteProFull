package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_zona_comun database table.
 * 
 */
@Entity
@Table(name="tb_zona_comun")
@NamedQuery(name="TbZonaComun.findAll", query="SELECT t FROM TbZonaComun t")
public class TbZonaComun implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TbZonaComunPK id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dia_mant")
	private Date diaMant;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="frec_mant")
	private int frecMant;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_mant")
	private Date horaMant;

	@Column(name="id_zona_comun")
	private int idZonaComun;

	@Column(name="numero_personas")
	private int numeroPersonas;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	@Column(name="valor_zona_comun")
	private BigDecimal valorZonaComun;

	//bi-directional many-to-one association to TbReserva
	@OneToMany(mappedBy="tbZonaComun")
	private List<TbReserva> tbReservas;

	//bi-directional many-to-one association to TbConjunto
	@ManyToOne
	@JoinColumn(name="tb_conjunto_id_conjunto")
	private TbConjunto tbConjunto;

	public TbZonaComun() {
	}

	public TbZonaComunPK getId() {
		return this.id;
	}

	public void setId(TbZonaComunPK id) {
		this.id = id;
	}

	public Date getDiaMant() {
		return this.diaMant;
	}

	public void setDiaMant(Date diaMant) {
		this.diaMant = diaMant;
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

	public int getFrecMant() {
		return this.frecMant;
	}

	public void setFrecMant(int frecMant) {
		this.frecMant = frecMant;
	}

	public Date getHoraMant() {
		return this.horaMant;
	}

	public void setHoraMant(Date horaMant) {
		this.horaMant = horaMant;
	}

	public int getIdZonaComun() {
		return this.idZonaComun;
	}

	public void setIdZonaComun(int idZonaComun) {
		this.idZonaComun = idZonaComun;
	}

	public int getNumeroPersonas() {
		return this.numeroPersonas;
	}

	public void setNumeroPersonas(int numeroPersonas) {
		this.numeroPersonas = numeroPersonas;
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

	public BigDecimal getValorZonaComun() {
		return this.valorZonaComun;
	}

	public void setValorZonaComun(BigDecimal valorZonaComun) {
		this.valorZonaComun = valorZonaComun;
	}

	public List<TbReserva> getTbReservas() {
		return this.tbReservas;
	}

	public void setTbReservas(List<TbReserva> tbReservas) {
		this.tbReservas = tbReservas;
	}

	public TbReserva addTbReserva(TbReserva tbReserva) {
		getTbReservas().add(tbReserva);
		tbReserva.setTbZonaComun(this);

		return tbReserva;
	}

	public TbReserva removeTbReserva(TbReserva tbReserva) {
		getTbReservas().remove(tbReserva);
		tbReserva.setTbZonaComun(null);

		return tbReserva;
	}

	public TbConjunto getTbConjunto() {
		return this.tbConjunto;
	}

	public void setTbConjunto(TbConjunto tbConjunto) {
		this.tbConjunto = tbConjunto;
	}

}