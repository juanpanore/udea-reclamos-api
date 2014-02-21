package co.edu.udea.dlloapp.reclamamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PolizaDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String numeroPoliza;
	Date fechaInicioVigencia;
	Date fechaFinVigencia;
	String tipoVehiculo;
	String referencia;
	
	public PolizaDto() {
	}
	
	public PolizaDto(String numeroPoliza, Date fechaInicioVigencia,
			Date fechaFinVigencia, String tipoVehiculo, String referencia) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.fechaInicioVigencia = fechaInicioVigencia;
		this.fechaFinVigencia = fechaFinVigencia;
		this.tipoVehiculo = tipoVehiculo;
		this.referencia = referencia;
	}
	public String getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}
	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}
	public String getTipoVehiculo() {
		return tipoVehiculo;
	}
	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
}
