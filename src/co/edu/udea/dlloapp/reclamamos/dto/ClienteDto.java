package co.edu.udea.dlloapp.reclamamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@XmlRootElement
public class ClienteDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TipoDocumentoDto tipoDocumento;
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

	public ClienteDto(TipoDocumentoDto tipoDocumento, String numeroDocumento,
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

	public TipoDocumentoDto getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumentoDto tipoDocumento) {
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

	public void convertJsonToDto(DBObject clienteJson) {
		
		DBObject tipoDocumentoJson = (BasicDBObject) clienteJson.get("tipoDocumento");
		TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
		tipoDocumentoDto.setId(Integer.parseInt(tipoDocumentoJson.get("id").toString()));
		tipoDocumentoDto.setNombre(tipoDocumentoJson.get("nombre").toString());
		setTipoDocumento(tipoDocumentoDto);
		
		setNumeroDocumento(clienteJson.get("numeroDocumento").toString());
		setPrimerNombre(clienteJson.get("primerNombre").toString());
		setSegundoNombre(clienteJson.get("segundoNombre").toString());
		setPrimerApellido(clienteJson.get("primerApellido").toString());
		setSegundoApellido(clienteJson.get("segundoApellido").toString());
		setTipoCliente(clienteJson.get("tipoCliente").toString());
		setFechaNacimiento(new Date(Long.parseLong(clienteJson.get("fechaNacimiento").toString())));

		DBObject polizaJson = (BasicDBObject) clienteJson.get("Poliza");
		PolizaDto polizaDto = new PolizaDto();
		polizaDto.setTipoVehiculo(polizaJson.get("tipoVehiculo").toString());
		polizaDto.setReferencia(polizaJson.get("referencia").toString());
		polizaDto.setNumeroPoliza(polizaJson.get("numeroPoliza").toString());
		polizaDto.setFechaInicioVigencia(new Date(Long.parseLong(polizaJson.get("fechaInicioVigencia").toString())));
		polizaDto.setFechaFinVigencia(new Date(Long.parseLong(polizaJson.get("fechaFinVigencia").toString())));
		setPoliza(polizaDto);
	}
	
	
	
	
}
