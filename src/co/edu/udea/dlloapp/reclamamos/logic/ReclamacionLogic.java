package co.edu.udea.dlloapp.reclamamos.logic;

import java.rmi.UnknownHostException;
import java.util.Date;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dataaccess.ReclamacionDao;
import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;
import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;

public class ReclamacionLogic implements IReclamacionLogic {

	ReclamacionDao reclamacionDao;

	public List<ReclamoDto> consultarListaReclamos() throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.consultarListaReclamos();
	}

	public Boolean guardarIncidenteJson(ReclamoDto reclamoDto) throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.guardarIncidente(reclamoDto);
	}

	public Boolean guardarIncidente(String tipoDocumento,
			String numeroDocumento, Date fechaIncedente,
			String motivoIncidente, String descripcionIncidente,
			Double valorReparacion, Boolean culpable, String lugarIncidente) {

		Boolean estado = false;

		try {
			reclamacionDao = new ReclamacionDao();

			ReclamoDto reclamo = new ReclamoDto();
			ClienteDto cliente = new ClienteDto();
			cliente.setTipoDocumento(tipoDocumento);
			cliente.setNumeroDocumento(numeroDocumento);
			reclamo.setCliente(cliente);
			reclamo.setCulpable(culpable);
			reclamo.setDescripcion(descripcionIncidente);
			reclamo.setFechaIncidente(fechaIncedente);
			MotivoDto motivoDto = new MotivoDto();
			reclamo.setMotivo(motivoDto);
			reclamo.setValorReparacion(valorReparacion);

			estado = reclamacionDao.guardarIncidente(reclamo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return estado;
	}

}
