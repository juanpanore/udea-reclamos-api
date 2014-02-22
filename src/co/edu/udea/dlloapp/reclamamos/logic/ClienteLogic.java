package co.edu.udea.dlloapp.reclamamos.logic;

import co.edu.udea.dlloapp.reclamamos.dataaccess.ClienteDao;
import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;

public class ClienteLogic implements IClienteLogic {

	ClienteDao clienteDao;
	
	public ClienteDto consultarCliente(Integer idTipoDocumento,
			String numeroDocumento) throws Exception {
		clienteDao = new ClienteDao();
		return clienteDao.consultarCliente(idTipoDocumento, numeroDocumento);
	}

}
