package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dataaccess.ReclamacionDao;
import co.edu.udea.dlloapp.reclamamos.dto.ReclamoDto;

public class ReclamacionLogic implements IReclamacionLogic {

	ReclamacionDao reclamacionDao;
	
	public List<ReclamoDto> consultarListaReclamos() throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.consultarListaReclamos();
	}

	public Boolean guardarIncidente(ReclamoDto reclamo) throws Exception {
		reclamacionDao = new ReclamacionDao();
		return reclamacionDao.guardarIncidente(reclamo);
	}

}
