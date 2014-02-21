package co.edu.udea.dlloapp.reclamamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReclamoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ClienteDto cliente;
	private Date fechaIncidente;
	private MotivoDto motivo;
	private String descripcion;
	private Double valorReparacion;
	private Boolean culpable;
	private String lugarIncidente;

	public ReclamoDto() {
	}

	public ReclamoDto(ClienteDto cliente, Date fechaIncidente,
			MotivoDto motivo, String descripcion, Double valorReparacion,
			Boolean culpable, String lugarIncidente) {
		super();
		this.cliente = cliente;
		this.fechaIncidente = fechaIncidente;
		this.motivo = motivo;
		this.descripcion = descripcion;
		this.valorReparacion = valorReparacion;
		this.culpable = culpable;
		this.lugarIncidente = lugarIncidente;
	}

	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public Date getFechaIncidente() {
		return fechaIncidente;
	}

	public void setFechaIncidente(Date fechaIncidente) {
		this.fechaIncidente = fechaIncidente;
	}

	public MotivoDto getMotivo() {
		return motivo;
	}

	public void setMotivo(MotivoDto motivo) {
		this.motivo = motivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getValorReparacion() {
		return valorReparacion;
	}

	public void setValorReparacion(Double valorReparacion) {
		this.valorReparacion = valorReparacion;
	}

	public Boolean getCulpable() {
		return culpable;
	}

	public void setCulpable(Boolean culpable) {
		this.culpable = culpable;
	}

	public String getLugarIncidente() {
		return lugarIncidente;
	}

	public void setLugarIncidente(String lugarIncidente) {
		this.lugarIncidente = lugarIncidente;
	}

}
