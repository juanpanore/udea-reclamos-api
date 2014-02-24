package co.edu.udea.dlloapp.reclamamos.logic;

import co.edu.udea.dlloapp.reclamamos.dto.ClienteDto;

/**
 * Interface de Lógica de negocio para los clientes.
 * 
 * @author Cristian Correa
 *
 */
public interface IClienteLogic {

	/**
	 * Método que permite consultar un cliente 
	 * 
	 * @author Cristian Correa
	 * @param idTipoDocumento Tipo de documento
	 * @param numeroDocumento Número de documento
	 * @return clienteDto Dto
	 * @throws Exception
	 */
	ClienteDto consultarCliente(Integer idTipoDocumento, String numeroDocumento)throws Exception;

}
