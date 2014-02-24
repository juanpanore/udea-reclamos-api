package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.Date;
import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dataaccess.ReclamacionDao;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;
import co.edu.udea.dlloapp.reclamamos.dto.ResponseReclamos;

public class ReclamacionLogic implements IReclamacionLogic {

	ReclamacionDao reclamacionDao;

	public ReclamoDto consultarDetalleReclamo(String codigo) throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.consultarDetalleReclamo(codigo);
	}

	public ResponseReclamos guardarIncidenteJson(ReclamoDto reclamoDto) throws Exception {
		reclamacionDao = new ReclamacionDao();
		reclamoDto.setCodigo(new Date().getTime());
		return reclamacionDao.guardarIncidente(reclamoDto);
	}

	public List<ReclamoDto> consultarListaReclamos() throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.consultarListaReclamos();
	}
}
