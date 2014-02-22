package co.edu.udea.dlloapp.reclamamos.dto;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@XmlRootElement
public class ReclamoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long codigo;
	private ClienteDto cliente;
	private TipoDocumentoDto tipoDocumento;
	private String numeroDocumento;
	private Date fechaIncidente;
	private MotivoDto motivo;
	private String descripcion;
	private Double valorReparacion;
	private Boolean culpable;
	private String lugarIncidente;

	public ReclamoDto() {
	}

	public ReclamoDto(Long codigo, ClienteDto cliente, Date fechaIncidente,
			MotivoDto motivo, String descripcion, Double valorReparacion,
			Boolean culpable, String lugarIncidente) {
		super();
		this.codigo = codigo;
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void convertJsonToDto(DBObject reclamoJson) {
		setCodigo(Long.parseLong(reclamoJson.get("codigo").toString()));
		
		DBObject tipoDocumentoJson = (BasicDBObject) reclamoJson.get("tipoDocumento");
		TipoDocumentoDto tipoDocumentoDto = new TipoDocumentoDto();
		tipoDocumentoDto.setId(Integer.parseInt(tipoDocumentoJson.get("id").toString()));
		tipoDocumentoDto.setNombre(tipoDocumentoJson.get("nombre").toString());
		setTipoDocumento(tipoDocumentoDto);
		
		setNumeroDocumento(reclamoJson.get("numeroDocumento").toString());
		setFechaIncidente(new Date(Long.parseLong(reclamoJson.get("fechaIncidente").toString())));

		DBObject motivoJson = (BasicDBObject) reclamoJson.get("motivo");
		MotivoDto motivoDto = new MotivoDto();
		motivoDto.setId(Integer.parseInt(motivoJson.get("id").toString()));
		motivoDto.setNombre(motivoJson.get("nombre").toString());
		setMotivo(motivoDto);

		setDescripcion(reclamoJson.get("descripcionIncidente").toString());
		setValorReparacion(Double.parseDouble(reclamoJson.get("valorReparacion").toString()));
		setLugarIncidente(reclamoJson.get("lugarIncidente").toString());
		setCulpable(Boolean.parseBoolean(reclamoJson.get("culpable").toString()));
	}

}
