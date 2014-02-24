package co.edu.udea.dlloapp.reclamamos.logic;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;

/**
 * Interface de L�gica de negocio para los clientes.
 * 
 * @author Cristian Correa
 *
 */
public interface IClienteLogic {

	/**
	 * M�todo que permite consultar un cliente 
	 * 
	 * @author Cristian Correa
	 * @param idTipoDocumento Tipo de documento
	 * @param numeroDocumento N�mero de documento
	 * @return clienteDto Dto
	 * @throws Exception
	 */
	ClienteDto consultarCliente(Integer idTipoDocumento, String numeroDocumento)throws Exception;

}
