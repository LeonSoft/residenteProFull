package com.leonsoftware.residentepro.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb_cuota database table.
 * 
 */
@Entity
@Table(name="tb_cuota")
@NamedQuery(name="TbCuota.findAll", query="SELECT t FROM TbCuota t")
public class TbCuota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_tipo_cuota")
	private String idTipoCuota;

	@Column(name="descripcion_cuota")
	private String descripcionCuota;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_pago_oportuno")
	private Date fechaPagoOportuno;

	@Column(name="frecuencia_pago")
	private String frecuenciaPago;

	@Column(name="numero_cuotas")
	private String numeroCuotas;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="numero_dias_pago")
	private Date numeroDiasPago;

	@Column(name="porcentaje_int_mora")
	private BigDecimal porcentajeIntMora;

	@Column(name="porcentaje_pago_anticipado")
	private BigDecimal porcentajePagoAnticipado;

	@Column(name="usuario_creacion")
	private String usuarioCreacion;

	@Column(name="usuario_modificacion")
	private String usuarioModificacion;

	@Column(name="valor_cobro_juridico")
	private BigDecimal valorCobroJuridico;

	@Column(name="valor_cuota")
	private BigDecimal valorCuota;

	//bi-directional many-to-one association to TbInmueble
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="tb_inmueble_id_inmueble", referencedColumnName="id_inmueble"),
		@JoinColumn(name="tb_inmueble_tb_conjunto_id_conjunto", referencedColumnName="tb_conjunto_id_conjunto"),
		@JoinColumn(name="tb_inmueble_tipo_id_immueble", referencedColumnName="tipo_id_immueble")
		})
	private TbInmueble tbInmueble;

	//bi-directional many-to-one association to TbPago
	@OneToMany(mappedBy="tbCuota")
	private List<TbPago> tbPagos;

	public TbCuota() {
	}

	public String getIdTipoCuota() {
		return this.idTipoCuota;
	}

	public void setIdTipoCuota(String idTipoCuota) {
		this.idTipoCuota = idTipoCuota;
	}

	public String getDescripcionCuota() {
		return this.descripcionCuota;
	}

	public void setDescripcionCuota(String descripcionCuota) {
		this.descripcionCuota = descripcionCuota;
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

	public Date getFechaPagoOportuno() {
		return this.fechaPagoOportuno;
	}

	public void setFechaPagoOportuno(Date fechaPagoOportuno) {
		this.fechaPagoOportuno = fechaPagoOportuno;
	}

	public String getFrecuenciaPago() {
		return this.frecuenciaPago;
	}

	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	public String getNumeroCuotas() {
		return this.numeroCuotas;
	}

	public void setNumeroCuotas(String numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public Date getNumeroDiasPago() {
		return this.numeroDiasPago;
	}

	public void setNumeroDiasPago(Date numeroDiasPago) {
		this.numeroDiasPago = numeroDiasPago;
	}

	public BigDecimal getPorcentajeIntMora() {
		return this.porcentajeIntMora;
	}

	public void setPorcentajeIntMora(BigDecimal porcentajeIntMora) {
		this.porcentajeIntMora = porcentajeIntMora;
	}

	public BigDecimal getPorcentajePagoAnticipado() {
		return this.porcentajePagoAnticipado;
	}

	public void setPorcentajePagoAnticipado(BigDecimal porcentajePagoAnticipado) {
		this.porcentajePagoAnticipado = porcentajePagoAnticipado;
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

	public BigDecimal getValorCobroJuridico() {
		return this.valorCobroJuridico;
	}

	public void setValorCobroJuridico(BigDecimal valorCobroJuridico) {
		this.valorCobroJuridico = valorCobroJuridico;
	}

	public BigDecimal getValorCuota() {
		return this.valorCuota;
	}

	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	public TbInmueble getTbInmueble() {
		return this.tbInmueble;
	}

	public void setTbInmueble(TbInmueble tbInmueble) {
		this.tbInmueble = tbInmueble;
	}

	public List<TbPago> getTbPagos() {
		return this.tbPagos;
	}

	public void setTbPagos(List<TbPago> tbPagos) {
		this.tbPagos = tbPagos;
	}

	public TbPago addTbPago(TbPago tbPago) {
		getTbPagos().add(tbPago);
		tbPago.setTbCuota(this);

		return tbPago;
	}

	public TbPago removeTbPago(TbPago tbPago) {
		getTbPagos().remove(tbPago);
		tbPago.setTbCuota(null);

		return tbPago;
	}

}