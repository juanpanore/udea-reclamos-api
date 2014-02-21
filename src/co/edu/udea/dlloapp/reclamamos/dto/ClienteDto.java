package co.edu.udea.dlloapp.reclamamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String tipoDocumento;
	String numeroDocumento;
	String primerNombre;
	String segundoNombre;
	String primerApellido;
	String segundoApellido;
	String tipoCliente;
	Date fechaNacimiento;
	PolizaDto poliza;
	
	public ClienteDto() {
		
	}

	public ClienteDto(String tipoDocumento, String numeroDocumento,
			String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, String tipoCliente, Date fechaNacimiento,
			PolizaDto poliza) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.tipoCliente = tipoCliente;
		this.fechaNacimiento = fechaNacimiento;
		this.poliza = poliza;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public PolizaDto getPoliza() {
		return poliza;
	}

	public void setPoliza(PolizaDto poliza) {
		this.poliza = poliza;
	}
	
	
	
	
}
