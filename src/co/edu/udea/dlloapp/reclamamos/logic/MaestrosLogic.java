package co.edu.udea.dlloapp.reclamamos.logic;

import java.util.List;

import co.edu.udea.dlloapp.reclamamos.dataaccess.MaestrosDao;
import co.edu.udea.dlloapp.reclamamos.dto.MotivoDto;

import co.edu.udea.dlloapp.reclamamos.dto.TipoDocumentoDto;

public class MaestrosLogic implements IMaestrosLogic {

	MaestrosDao maestrosDao;
	
	public List<MotivoDto> consultarListaMotivos() throws Exception {
		maestrosDao = new MaestrosDao();
		return maestrosDao.consultarListaMotivos();
	}

	public List<TipoDocumentoDto> consultarTiposDocumentos() throws Exception {
		maestrosDao = new MaestrosDao();
		return maestrosDao.consultarTiposDocumentos();
	}
}
